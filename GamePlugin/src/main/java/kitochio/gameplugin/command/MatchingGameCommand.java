package kitochio.gameplugin.command;

import java.time.format.DateTimeFormatter;
import java.util.List;
import kitochio.gameplugin.MatchingGameData;
import kitochio.gameplugin.data.MatchingGameConfig;
import kitochio.gameplugin.mapper.data.MatchingGameDifficultyTime;
import kitochio.gameplugin.mapper.data.MatchingGameScore;
import kitochio.gameplugin.mapper.data.MatchingGameSpawnBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ペアとなるブロックを探して触れて、ポイントを獲得するミニゲームを起動するコマンドです
 */
public class MatchingGameCommand extends BaseCommand {

  private final MatchingGameData matchingGameData = new MatchingGameData();
  private final MatchingGameConfig matchingGameConfig = new MatchingGameConfig();

  @Override
  protected boolean onExecutePlayerCommand(Player player, Command command, String s, String[] strings) {
    if (strings.length >= 1) {
      //第一引数にendが入力されたらゲーム終了、rankが入力されたらランキングを表示
      switch (strings[0]) {
        case "end" -> {
          player.sendMessage("ゲームを終了します");
          return false;
        }
        case "rank" -> {
          player.sendMessage("ランキングを表示します");
          sendPlayerScoreList(player);
          return false;
        }
        case "level" -> {
          switch (strings[1]) {
            case "1" -> {
              gameConfigSetting(1);
              gameConfigSendMessage(player);
              return false;
            }
            case "2" -> {
              gameConfigSetting(2);
              gameConfigSendMessage(player);
              return false;
            }
            case "3" -> {
              gameConfigSetting(3);
              gameConfigSendMessage(player);
              return false;
            }
          }
        }
        default -> {
          player.sendMessage("設定のない引数が入力されました\nend:ゲームを終了　rank:ランキングを表示\nlevel:難易度変更（ふたつめの引数に1〜３を入力）");
          return false;
        }
      }
    }
    player.sendMessage("ゲームを開始します");
    return true;
  }


  //コマンドを実行したのがプレイヤー以外の場合は何もしない
  @Override
  protected boolean onExecuteNPCCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    return false;
  }

  /**
   * 現在登録されているランキングの一覧をメッセージに送る
   *
   * @param player コマンドを実行したプレイヤー
   */
  private void sendPlayerScoreList(Player player) {
    List<MatchingGameScore> matchingGameScoreList = matchingGameData.selectListScore();
    int i = 0;
    for (MatchingGameScore matchingGameScore : matchingGameScoreList) {
      i++;
      player.sendMessage(i + "位 | "
          + matchingGameScore.getPlayerName() + " | "
          + matchingGameScore.getScore() + " | "
          + matchingGameScore.getRegisteredAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
  }

  /**
   * ゲーム設定情報をプレイヤーに通知する
   *
   * @param player コマンドを実行したプレイヤー
   */
  private void gameConfigSendMessage(Player player) {
    player.sendMessage("難易度を" + matchingGameConfig.getDifficultyName() + "に設定します");
    player.sendMessage("制限時間は" + matchingGameConfig.getGameTime() + "秒です");
    player.sendMessage("出現するブロック");
    matchingGameConfig.getSpawnBlocks().forEach(player::sendMessage);
  }

  /**
   * 指定した難易度の設定情報をDBから取得する
   *
   * @param difficulty 取得したい難易度
   */
  private void gameConfigSetting(int difficulty) {
    MatchingGameDifficultyTime matchingGameDifficultyTime = matchingGameData.selectDifficultyTime(difficulty);
    matchingGameConfig.setGameTime(matchingGameDifficultyTime.getGameTime());
    matchingGameConfig.setDifficultyName(matchingGameDifficultyTime.getDifficulty());

    //出現ブロックリスト取得
    List<MatchingGameSpawnBlock> matchingGameSpawnBlockList = matchingGameData.selectMatchingGameSpawnBlock(difficulty);
    matchingGameConfig.getSpawnBlocks().clear();
    for (MatchingGameSpawnBlock matchingGameSpawnBlock : matchingGameSpawnBlockList) {
      matchingGameConfig.getSpawnBlocks().add(matchingGameSpawnBlock.getBlockName());
    }
  }
}
