-- mininggame_score テーブルの削除と作成
DROP TABLE IF EXISTS mininggame_score;

CREATE TABLE mininggame_score (
  id INT UNSIGNED AUTO_INCREMENT,
  player_name VARCHAR(100) NOT NULL,
  score INT NOT NULL,
  registered_at DATETIME NOT NULL,
  PRIMARY KEY(id)
);

-- データの挿入
INSERT INTO mininggame_score (player_name, score, registered_at) VALUES ('TestUser', 1000, NOW());

-- matchinggame_config テーブルの削除と作成
DROP TABLE IF EXISTS matchinggame_config;

CREATE TABLE matchinggame_config (
  id INT UNSIGNED AUTO_INCREMENT,
  game_time INT NOT NULL,
  difficulty INT NOT NULL,
  PRIMARY KEY(id),
  UNIQUE(difficulty)
);

-- データの挿入
INSERT INTO matchinggame_config (game_time, difficulty) VALUES (30, 1);
INSERT INTO matchinggame_config (game_time, difficulty) VALUES (60, 2);
INSERT INTO matchinggame_config (game_time, difficulty) VALUES (40, 3);

-- spawn_block テーブルの削除と作成
DROP TABLE IF EXISTS spawn_block;

CREATE TABLE spawn_block (
  id INT UNSIGNED AUTO_INCREMENT,
  difficulty INT NOT NULL,
  block_name VARCHAR(100) NOT NULL,
  point INT NOT NULL,
  PRIMARY KEY(id),
  UNIQUE(difficulty, block_name)
);

-- データの挿入
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (1, 'iron_block', 10);
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (2, 'iron_block', 10);
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (2, 'gold_block', 30);
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (3, 'iron_block', 10);
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (3, 'gold_block', 30);
INSERT INTO spawn_block (difficulty, block_name, point) VALUES (3, 'diamond_block', 100);

-- matchinggame_score テーブルの削除と作成
DROP TABLE IF EXISTS matchinggame_score;

CREATE TABLE matchinggame_score (
  id INT UNSIGNED AUTO_INCREMENT,
  difficulty INT NOT NULL,
  player_name VARCHAR(100) NOT NULL,
  score INT NOT NULL,
  registered_at DATETIME NOT NULL,
  PRIMARY KEY(id)
);

-- データの挿入
INSERT INTO matchinggame_score (difficulty, player_name, score, registered_at) VALUES (1, 'test_player', 100, NOW());
