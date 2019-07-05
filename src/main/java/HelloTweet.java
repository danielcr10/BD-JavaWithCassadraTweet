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

            System.out.println("Inseretweets");
//            String username, String tweetText, String dateSent,
//            long id, String source, boolean isTruncated,
//            GeoLocation geolocation, boolean isFavorited, List<Long> contributors
            GeoLocation geo = new GeoLocation(8748943, 9474740);
            Tweet tweet = new Tweet("NeymarJr", "Eai fake?",
                    "02-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null );
            tr.insertTweet(tweet);
            Tweet tweet2 = new Tweet("Messi", "isso eh problema",
                    "02-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    false, geo, false,null);
            tr.insertTweet(tweet2);
            Tweet tweet3 = new Tweet("Obama", "Hey fake",
                    "02-03-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);
            tr.insertTweet(tweet3);
            Tweet tweet4 = new Tweet("NeymarJr", "Chegando com os refri",
                    "22-01-13", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);
            tr.insertTweet(tweet4);
            Tweet tweet5 = new Tweet("Suarez", "Olha a dentada",
                    "15-06-14", 12,
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, false,null);
            tr.insertTweet(tweet5);
            Tweet tweet6 = new Tweet("Messi", "Fui eliminado",
                    "07-02-19", new Random().nextLong(),
                    "a href=\"http://twitter.com\" rel=\"nofollow\"&gt;Twitter Web Client",
                    true, geo, true,null);
            tr.insertTweet(tweet6);

            tr.insertTweetByUser(tweet);
            tr.insertTweetByUser(tweet2);
            tr.insertTweetByUser(tweet3);
            tr.insertTweetByUser(tweet4);
            tr.insertTweetByUser(tweet5);
            tr.insertTweetByUser(tweet6);

            System.out.println("\n\nBuscando tweets em TweetsByUser");
            tr.selectAllByUser();

            System.out.println("\n\nBuscando tweets por usuario: Messi");
            tr.selectAllByUser("Messi");

            System.out.println("Buscando tweets por usuario: Suarez");
            tr.selectAllByUser("Suarez");

            System.out.println("Buscando tweets");
            tr.selectAll();

            System.out.println("Deleting tweet \"Olha a dentada\" - id=12");
            tr.deleteTweet(12);

            System.out.println("Buscando tweets depois do delete");
            tr.selectAll();

            System.out.println("Deleta tabela Tweets");
            tr.deleteTable("Tweets");


            System.out.println("Deleta keyspace");
            sr.deleteKeyspace("tweets");


        } finally {
            if (cluster != null) cluster.close();
        }
    }
}