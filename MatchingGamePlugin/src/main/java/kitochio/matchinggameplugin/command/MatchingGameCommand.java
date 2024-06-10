package kitochio.matchinggameplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MatchingGameCommand extends BaseCommand {

  @Override
  protected boolean onExecutePlayerCommand(Player player, Command command, String s, String[] strings) {
    player.sendMessage("Hello World!");
    return true;
  }

  //コマンドを実行したのがプレイヤー以外の場合は何もしない
  @Override
  protected boolean onExecuteNPCCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    return false;
  }
}
