package kitochio.gameplugin.mapper.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchingGameSpawnBlock {

  private int id;
  private int difficulty_id;
  private String blockName;
  private int point;
}
