package plugin.webserver.app.mapper.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DB接続用、出現するブロックの種類のデータ
 */
@Getter
@Setter
@NoArgsConstructor
public class MatchingGameSpawnBlock {

  private int id;
  private int difficulty_id;
  private String blockName;
  private int point;
}
