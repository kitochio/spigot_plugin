package kitochio.matchinggameplugin;

import java.util.Objects;
import kitochio.matchinggameplugin.command.MatchingGameCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    MatchingGameCommand matchingGameCommand = new MatchingGameCommand();
    Objects.requireNonNull(getCommand("MatchingGame")).setExecutor(matchingGameCommand);
  }
}
