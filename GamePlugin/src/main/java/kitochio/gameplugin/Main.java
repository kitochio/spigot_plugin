package kitochio.gameplugin;

import java.util.Objects;
import kitochio.gameplugin.command.MatchingGameCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        MatchingGameCommand matchingGameCommand = new MatchingGameCommand();
        Objects.requireNonNull(getCommand("MatchingGame")).setExecutor(matchingGameCommand);
    }
}
