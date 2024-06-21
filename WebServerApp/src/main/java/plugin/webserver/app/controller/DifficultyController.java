package plugin.webserver.app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plugin.webserver.app.mapper.data.MatchingGameDifficulty;
import plugin.webserver.app.mapper.data.MatchingGameSpawnBlock;
import plugin.webserver.app.service.DifficultyService;

@RestController
public class DifficultyController {

  public final DifficultyService service;

  public DifficultyController(DifficultyService service) {
    this.service = service;
  }

  @RequestMapping(value = "/difficultyList", method = RequestMethod.GET)
  public List<MatchingGameDifficulty> difficultyList() {
    return service.searchDifficultyList();
  }

  @RequestMapping(value = "/difficulty", method = RequestMethod.GET)
  public MatchingGameDifficulty difficulty(@RequestParam String difficulty) {
    return service.searchDifficulty(difficulty);
  }

  @RequestMapping(value = "/SpawnBlockList", method = RequestMethod.GET)
  public List<MatchingGameSpawnBlock> SpawnBlockList(@RequestParam int id) {
    return service.serchSpawnBlockList(id);
  }
}
