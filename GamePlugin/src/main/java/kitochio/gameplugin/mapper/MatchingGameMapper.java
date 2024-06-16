package kitochio.gameplugin.mapper;

import java.util.List;
import kitochio.gameplugin.mapper.data.MatchingGameScore;
import org.apache.ibatis.annotations.Select;

/**
 *
 */
public interface MatchingGameMapper {

  @Select("SELECT * FROM matchinggame_score ORDER BY score DESC LIMIT 5")
  List<MatchingGameScore> matchingGameScoreList();

}
