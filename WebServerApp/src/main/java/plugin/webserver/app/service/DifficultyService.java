package plugin.webserver.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import plugin.webserver.app.mapper.GameDifficultyMapper;
import plugin.webserver.app.mapper.data.MatchingGameDifficulty;

@Service
public class DifficultyService {

  private final GameDifficultyMapper mapper;

  public DifficultyService(GameDifficultyMapper mapper) {
    this.mapper = mapper;
  }

  public List<MatchingGameDifficulty> searchDifficulty() throws Exception {

  }
}
