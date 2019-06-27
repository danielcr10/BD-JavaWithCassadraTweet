import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    private static final String TABLE_NAME = "Tweets";
    private Session session;

    public TweetRepository(Session session) {
        this.session = session;
    }

    public void createTable() {
        System.out.println("createTable – init");

        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME).append("(")
                .append("ttext text PRIMARY KEY, ")
                .append("usr text,")
                .append("date text);");
        final String query = sb.toString();
        System.out.println("createTable – command: " + query.toUpperCase());

        session.execute(query);
        System.out.println("createTable – end");
    }

    public void insertTweet(Tweet tweet) {
        System.out.println("insetTweet – init");

        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(TABLE_NAME).append("(usr, ttext, date) ") //tem queguardar a string do user e o geolocatio guarda latitude e longitude
                .append("VALUES ('").append(tweet.getUsername()).append("', '")
                .append(tweet.getTweetText()).append("', '")
                .append(tweet.getDateSent()).append("');");
        final String query = sb.toString();
        System.out.println("insetTweet – command: " + query.toUpperCase());
        session.execute(query);

        System.out.println("insetTweet – end");

    }

    public List<Tweet> selectAll() {
        System.out.println("selectAll – init");

        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);
        System.out.println("SELECT * FROM "+TABLE_NAME.toUpperCase());

        final String query = sb.toString();
        System.out.println("selectAll – command: " + query.toUpperCase());
        ResultSet rs = session.execute(query);
        List<Tweet> tweets = new ArrayList<Tweet>();
        for (Row r : rs) {
            Tweet tt = new Tweet(r.getString("usr"),
                    r.getString("ttext"), r.getString("date"));
            System.out.println("@" + tt.getUsername() + ":" + " " + tt.getTweetText());
            tweets.add(tt);
        }


        System.out.println("selectAll – end");
        return tweets;
    }

    public void deleteTweet(String ttext) {
        System.out.println("deleteTweet – init");
        StringBuilder sb = new StringBuilder("DELETE FROM ")
                .append(TABLE_NAME).append(" WHERE ttext = '")
                .append(ttext).append("';");

        final String query = sb.toString();
        System.out.println("deleteTweet – command: " + query.toUpperCase());
        session.execute(query);
        System.out.println("deleteTweet – end");

    }

    public void deleteTable(String tableName) {
        System.out.println("deleteTable – init");

        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ").append(tableName);

        final String query = sb.toString();
        System.out.println("deleteTable – command: " + query.toUpperCase());
        session.execute(query);

        System.out.println("deleteTable – end");

    }

    /**
     * Tabelas para listar todos tweets favoritados
     */
    public void createTableTweetsByFavorited(){
        System.out.println("createTableTweetsByFavorited – init");

        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME+"ByFavorited").append("(")
                .append("usr text,")
                .append("ttext text PRIMARY KEY, ")
                .append("date text);");
        final String query = sb.toString();
        System.out.println("createTableTweetsByFavorited – command: " + query.toUpperCase());

        session.execute(query);
        System.out.println("createTableTweetsByFavorited – end");
    }
}