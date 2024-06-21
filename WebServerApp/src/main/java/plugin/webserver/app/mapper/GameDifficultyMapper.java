package plugin.webserver.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.webserver.app.mapper.data.MatchingGameDifficulty;

@Mapper
public interface GameDifficultyMapper {

  @Select("select * from matchinggame_difficulty")
  List<MatchingGameDifficulty> selectConfigList();
}
