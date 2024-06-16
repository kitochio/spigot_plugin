package kitochio.gameplugin.command;

import java.time.format.DateTimeFormatter;
import java.util.List;
import kitochio.gameplugin.MatchingGameData;
import kitochio.gameplugin.mapper.data.MatchingGameScore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ペアとなるブロックを探して触れて、ポイントを獲得するミニゲームを起動するコマンドです
 */
public class MatchingGameCommand extends BaseCommand {

  private final MatchingGameData matchingGameData = new MatchingGameData();

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
              player.sendMessage("難易度をLEVEL１に設定します");
            }
            case "2" -> {
              player.sendMessage("難易度をLEVEL2に設定します");
            }
            case "3" -> {
              player.sendMessage("難易度をLEVEL3に設定します");
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
}
