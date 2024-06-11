## Javaのアプリ開発の学習のために　マインクラフトのプラグインを作成しました

### 設計
1. コマンドでゲームを実行すること
   - plugin.ymlにコマンドを登録し、setExecutor()で紐づける

2. ペア登録された複数のEntityが出現すること
   - world.getBlockAt(location).setType(Material.DIAMOND_BLOCK);でEntityを出現させる
   - 同じ鉱石を2個出現することを複数回繰り返し、その繰り返し回数をメタデータとしてブロックに記録する
   - setMetadata()によりメタデータを設定

3. ペアのEntity同士に触れるとEntityが消滅すること
   - PlayerInteractEvent()からイベントを受け取る
   - 触れたブロックのメタデータから何回目のペアかを確認し過去一回まで保存する
   - 過去に触れたブロックの回目と現在触れたブロックの回目が同じなら消滅させる

4. 制限時間を設定できること
   - runTaskTimer()で開始と終了を判別する

5. スコアをDBに登録できること
   - MySQLサーバをDockerで構築しMyBatisで接続する

6. スコアはリストで確認できること
   - MySQLサーバをDockerで構築しMyBatisで接続する

7. ペアのEntityに触れるとエフェクトを再生する
   - villager_happy　と　ENTITY_PLAYER_LEVELUP　を再生する

8. 上空からブロックが降ってくる
   - FallingBlockクラスを使用することで落下させる

9. ペアが揃った場合にそのブロックをアイテムとして出現させる
   - ペアが揃ったアイテム名を使用して、プレイヤー位置に該当のアイテムを出現させる

10. 難易度をWebアプリで変更できる
    - SpringBootを使用してWebアプリケーションを作成する

フローチャート
![フローチャート](https://github.com/kitochio/spigot_plugin/blob/images/FlowChart.jpg)

システム概要
![システム概要](https://github.com/kitochio/spigot_plugin/blob/images/SystemOverview.jpg)

### 機能要件
1. コマンドでゲームを実行すること
2. ペア登録された複数のEntityが出現すること
3. ペアのEntity同士に触れるとEntityが消滅すること
4. 制限時間を設定できる
5. スコアをDBに登録する
6. スコアはリストで確認できる

### 非機能要件
7. ペアのEntityにふれるとエフェクトを再生する
8. 上空からブロックが降ってくる
9. ダイヤブロックを揃えるとダイヤ、金ブロックを揃えると金をゲットできる
10. 難易度をWebアプリで変更できる

### 対応するバージョン
- Spigot 1.20.6
- Mincraft 1.20.6
