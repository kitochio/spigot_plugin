package kitochio.gameplugin.mapper.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * MatchingGameのスコア情報を扱うオブジェクト。 DBに存在するテーブルと連動します
 */
@Getter
@Setter
public class MatchingGameScore {

  private int id;
  private int difficulty;
  private String playerName;
  private int score;
  private LocalDateTime RegisteredAt;
}
