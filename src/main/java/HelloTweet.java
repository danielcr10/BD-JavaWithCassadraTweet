import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class HelloTweet {
    public static void main(String[] args) {
        System.out.println("Sup");
        Cluster cluster = null;
        try {
            cluster = Cluster.builder()
                    .addContactPoint("localhost")
                    .build();
            Session session = cluster.connect();
            ResultSet rs = session.execute("select release_version from system.local");
            Row row = rs.one();
            System.out.println(row.getString("release_version"));

            KeyspaceRepository sr = new KeyspaceRepository(session);
            sr.createKeyspace("tweets", "SimpleStrategy", 1);
            System.out.println("Creating Repository");

            sr.useKeyspace("tweets");
            System.out.println("Repositorio tweet");

            TweetRepository tr = new TweetRepository(session);
            tr.createTable();
            System.out.println("Cria tabela");

            Tweet tweet = new Tweet("NeymarJr", "Eai fake?", "02-02-19");
            tr.insertTweet(tweet);
            Tweet tweet2 = new Tweet("Messi", "isso eh problema", "02-02-19");
            tr.insertTweet(tweet2);
            Tweet tweet3 = new Tweet("Obama", "Hey fake", "02-03-19");
            tr.insertTweet(tweet3);
            Tweet tweet4 = new Tweet("NeymarJr", "Chegando com os refri", "22-01-13");
            tr.insertTweet(tweet4);
            Tweet tweet5 = new Tweet("Suarez", "Olha a dentada",
                    "15-06-14");
            tr.insertTweet(tweet5);
            System.out.println("Inseretweets");

            tr.selectAll();
            System.out.println("Buscando tweets");

            tr.deleteTweet("Olha a dentada");
            System.out.println("Deleting tweet \"Olha a dentada\"");

            tr.deleteTable("Tweets");
            System.out.println("Deleta tabela Tweets");

            sr.deleteKeyspace("tweets");
            System.out.println("Deleta keyspace");

        } finally {
            if (cluster != null) cluster.close();
        }
    }
}