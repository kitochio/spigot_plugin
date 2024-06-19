package kitochio.gameplugin.data;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * MatchingGameのゲーム設定データを扱うオブジェクト 難易度、制限時間、出現するブロックの情報を持つ。
 */
@Getter
@Setter
public class MatchingGameConfig {

  private int difficulty;
  private String difficultyName;
  private int gameTime;
  private List<String> spawnBlocks = new ArrayList<String>();

  public MatchingGameConfig() {
    spawnBlocks.add("iron_block");
  }
}
