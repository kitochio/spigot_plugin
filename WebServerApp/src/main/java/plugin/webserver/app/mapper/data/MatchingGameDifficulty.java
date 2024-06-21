package plugin.webserver.app.mapper.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DB接続用、難易度と制限時間のデータ
 */
@Getter
@Setter
@NoArgsConstructor
public class MatchingGameDifficulty {

  private int id;
  private String difficulty;
  private int gameTime;

}
