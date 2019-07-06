import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import twitter4j.GeoLocation;

import java.util.Random;

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
            System.out.println("Cria tabela");
            tr.createTable();

            System.out.println("Cria tabela por usuario");
            tr.createTableByUser();

            GeoLocation geo = new GeoLocation(8748943, 9474740);
            Tweet tweet = new Tweet("NeymarJr", "Eai fake?",
                    "02-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null );

            Tweet tweet2 = new Tweet("Messi", "isso eh problema",
                    "02-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    false, geo, false,null);

            Tweet tweet3 = new Tweet("Obama", "Hey fake",
                    "02-03-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);

            Tweet tweet4 = new Tweet("NeymarJr", "Chegando com os refri",
                    "22-01-13", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);

            Tweet tweet5 = new Tweet("Suarez", "Olha a dentada",
                    "15-06-14", 12,
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, false,null);

            Tweet tweet6 = new Tweet("Messi", "Fui eliminado",
                    "07-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);

            System.out.println("Insere Tweets");

            tr.insertTweet(tweet);
            tr.insertTweet(tweet2);
            tr.insertTweet(tweet3);
            tr.insertTweet(tweet4);
            tr.insertTweet(tweet5);
            tr.insertTweet(tweet6);

            System.out.println("Insere TweetsByUser");

            tr.insertTweetByUser(tweet);
            tr.insertTweetByUser(tweet2);
            tr.insertTweetByUser(tweet3);
            tr.insertTweetByUser(tweet4);
            tr.insertTweetByUser(tweet5);
            tr.insertTweetByUser(tweet6);

            System.out.println("\n\nBuscando tweets em Tweets");
            tr.selectAll();

            System.out.println("Buscando tweets em TweetsByUser");
            tr.selectAllByUser();

            System.out.println("Buscando tweets por usuario: Messi");
            tr.selectAllByUser("Messi");


            System.out.println("Deleting tweet \"Olha a dentada\" - id=12 na tabela Tweets");
            tr.deleteTweet(12);

            System.out.println("Deleting tweet \"Olha a dentada\" - id=12 na tabela TweetsByUser");
            tr.deleteTweetByUser(12, "Suarez");

            System.out.println("Buscando tweets depois do delete em Tweets");
            tr.selectAll();

            System.out.println("Buscando tweets depois do delete em TweetsByUser");
            tr.selectAllByUser();

            System.out.println("Deleta tabela Tweets");
            tr.deleteTable("Tweets");

            System.out.println("Deleta tabela TweetsByUser");
            tr.deleteTable("TweetsByUser");

            System.out.println("Deleta keyspace");
            sr.deleteKeyspace("tweets");


        } finally {
            if (cluster != null) cluster.close();
        }
    }
}