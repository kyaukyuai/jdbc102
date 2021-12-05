# CSV JDBC

---

## 主要インタフェースの概要

### JDBC API

JDBC API は一連の抽象 Java インタフェースとして表現されます.
アプリケーションエンジニアはこれを使用して、特定のデータベースへの接続を開き、SQL 文を実行し、結果を処理することができます.

- java.sql.DriverManager: ドライバのロードを取り扱い、新規のデータベース接続の作成をサポートする.
- java.sql.Connection: 特定のデータベースへの接続を提供する.
- java.sql.Statement: 指定された接続上で SQL 文を実行するためのコンテナとして働く.
- java.sql.ResultSet: 指定された文の結果行へのアクセスを制御する.

Ref.
https://docs.oracle.com/javase/jp/1.3/guide/jdbc/spec/jdbc-spec.frame3.html
https://docs.oracle.com/javase/jp/1.3/guide/jdbc/spec/jdbc-spec.frame9.html

Ref.
https://github.com/h2database/h2database/blob/master/h2/src/main/org/h2/Driver.java
https://github.com/h2database/h2database/tree/master/h2/src/main/org/h2/jdbc
