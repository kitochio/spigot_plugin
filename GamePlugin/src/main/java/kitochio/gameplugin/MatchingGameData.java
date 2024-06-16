package kitochio.gameplugin;

import java.io.InputStream;
import java.util.List;
import kitochio.gameplugin.mapper.MatchingGameMapper;
import kitochio.gameplugin.mapper.data.MatchingGameScore;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * DB接続やそれに付随する登録や更新処理を行うクラスです。
 */
public class MatchingGameData {

  private SqlSessionFactory sqlSessionFactory;
  private MatchingGameMapper mapper;

  public MatchingGameData() {
    try {
      InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
      this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession session = sqlSessionFactory.openSession(true);
      this.mapper = session.getMapper(MatchingGameMapper.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * matchinggame_scoreテーブルから一覧でスコア情報を取得する
   *
   * @return スコア情報
   */
  public List<MatchingGameScore> selectListScore(){
    return mapper.matchingGameScoreList();
  }

}
