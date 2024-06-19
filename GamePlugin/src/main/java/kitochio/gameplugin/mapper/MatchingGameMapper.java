package kitochio.gameplugin.mapper;

import java.util.List;
import kitochio.gameplugin.mapper.data.MatchingGameDifficultyTime;
import kitochio.gameplugin.mapper.data.MatchingGameScore;
import kitochio.gameplugin.mapper.data.MatchingGameSpawnBlock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * DBから取得したデータを格納する
 */
public interface MatchingGameMapper {

  @Select("SELECT * FROM matchinggame_score ORDER BY score DESC LIMIT 5")
  List<MatchingGameScore> matchingGameScoreList();

  @Select("select * from matchinggame_difficulty where id = #{i}")
  MatchingGameDifficultyTime matchingGameDifficultyTime(@Param("i") int i);

  @Select("select * from spawn_block where difficulty_id = #{i}")
  List<MatchingGameSpawnBlock> matchingGameSpawnBlockList(@Param("i") int i);
}
