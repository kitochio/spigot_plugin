package kitochio.gameplugin.mapper.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatchingGameDifficultyTime {

  private int id;
  private String difficulty;
  private int gameTime;
}
