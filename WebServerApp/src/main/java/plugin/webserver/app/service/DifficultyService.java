package plugin.webserver.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import plugin.webserver.app.mapper.GameDifficultyMapper;
import plugin.webserver.app.mapper.data.MatchingGameDifficulty;
import plugin.webserver.app.mapper.data.MatchingGameSpawnBlock;

@Service
public class DifficultyService {

  private final GameDifficultyMapper mapper;

  public DifficultyService(GameDifficultyMapper mapper) {
    this.mapper = mapper;
  }

  public List<MatchingGameDifficulty> searchDifficultyList() {
    return mapper.selectDifficultyList();
  }

  public MatchingGameDifficulty searchDifficulty(String difficulty) {
    return mapper.selectDifficulty(difficulty);
  }

  public List<MatchingGameSpawnBlock> serchSpawnBlockList(int id) {
    return mapper.selectSpawnBlockList(id);
  }
}