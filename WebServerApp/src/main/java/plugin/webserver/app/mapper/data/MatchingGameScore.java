package plugin.webserver.app.mapper.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DB接続用、ゲームスコアのデータ
 */
@Getter
@Setter
@NoArgsConstructor
public class MatchingGameScore {

  private int id;
  private int difficulty_id;
  private String playerName;
  private int score;
  private LocalDateTime registered_at;
}
