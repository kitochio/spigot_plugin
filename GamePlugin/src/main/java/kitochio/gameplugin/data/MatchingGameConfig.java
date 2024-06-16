package kitochio.gameplugin.data;

import java.util.List;

/**
 * MatchingGameのゲーム設定データを扱うオブジェクト 難易度、制限時間、出現するブロックの情報を持つ。
 */
public class MatchingGameConfig {

  private int difficulty;
  private int gameTime;
  private List<String> spawnBlocks;
}
