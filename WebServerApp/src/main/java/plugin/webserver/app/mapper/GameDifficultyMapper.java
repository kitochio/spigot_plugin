package plugin.webserver.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.webserver.app.mapper.data.MatchingGameDifficulty;
import plugin.webserver.app.mapper.data.MatchingGameSpawnBlock;

@Mapper
public interface GameDifficultyMapper {

  @Select("select * from matchinggame_difficulty")
  List<MatchingGameDifficulty> selectDifficultyList();

  @Select("select * from matchinggame_difficulty where difficulty = #{difficulty}")
  MatchingGameDifficulty selectDifficulty(String difficulty);

  @Select("select * from spawn_block s inner join matchinggame_difficulty m  on s.difficulty_id = m.id where difficulty_id = #{id}")
  List<MatchingGameSpawnBlock> selectSpawnBlockList(int id);
}
