# BD-JavaWithCassadraTweet

/home/daniel/Downloads/jdk-12.0.1/bin/java -javaagent:/app/idea-IC/lib/idea_rt.jar=43535:/app/idea-IC/bin -Dfile.encoding=UTF-8 -classpath /home/daniel/puc/191/BD-JavaWithCassandraTweet/target/classes:/home/daniel/.m2/repository/com/datastax/cassandra/cassandra-driver-core/3.7.1/cassandra-driver-core-3.7.1.jar:/home/daniel/.m2/repository/io/netty/netty-handler/4.0.56.Final/netty-handler-4.0.56.Final.jar:/home/daniel/.m2/repository/io/netty/netty-buffer/4.0.56.Final/netty-buffer-4.0.56.Final.jar:/home/daniel/.m2/repository/io/netty/netty-common/4.0.56.Final/netty-common-4.0.56.Final.jar:/home/daniel/.m2/repository/io/netty/netty-transport/4.0.56.Final/netty-transport-4.0.56.Final.jar:/home/daniel/.m2/repository/io/netty/netty-codec/4.0.56.Final/netty-codec-4.0.56.Final.jar:/home/daniel/.m2/repository/com/google/guava/guava/19.0/guava-19.0.jar:/home/daniel/.m2/repository/io/dropwizard/metrics/metrics-core/3.2.2/metrics-core-3.2.2.jar:/home/daniel/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:/home/daniel/.m2/repository/com/github/jnr/jnr-ffi/2.1.7/jnr-ffi-2.1.7.jar:/home/daniel/.m2/repository/com/github/jnr/jffi/1.2.16/jffi-1.2.16.jar:/home/daniel/.m2/repository/org/ow2/asm/asm/5.0.3/asm-5.0.3.jar:/home/daniel/.m2/repository/org/ow2/asm/asm-commons/5.0.3/asm-commons-5.0.3.jar:/home/daniel/.m2/repository/org/ow2/asm/asm-analysis/5.0.3/asm-analysis-5.0.3.jar:/home/daniel/.m2/repository/org/ow2/asm/asm-tree/5.0.3/asm-tree-5.0.3.jar:/home/daniel/.m2/repository/org/ow2/asm/asm-util/5.0.3/asm-util-5.0.3.jar:/home/daniel/.m2/repository/com/github/jnr/jnr-x86asm/1.0.2/jnr-x86asm-1.0.2.jar:/home/daniel/.m2/repository/com/github/jnr/jnr-posix/3.0.44/jnr-posix-3.0.44.jar:/home/daniel/.m2/repository/com/github/jnr/jnr-constants/0.9.9/jnr-constants-0.9.9.jar:/home/daniel/.m2/repository/org/twitter4j/twitter4j-core/4.0.7/twitter4j-core-4.0.7.jar HelloTweet
Picked up JAVA_TOOL_OPTIONS: -Djava.io.tmpdir=/home/daniel/.var/app/com.jetbrains.IntelliJ-IDEA-Community/cache/tmp/
Sup
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
3.11.4
Creating Repository
Repositorio tweet
Cria tabela
createTable – init
createTable – command: CREATE TABLE IF NOT EXISTS TWEETS(USR TEXT, TTEXT TEXT, DATE TEXT, ID BIGINT PRIMARY KEY, SOURCE TEXT, ISTRUNCATED BOOLEAN, LATITUDE DOUBLE, LONGITUDE DOUBLE, ISFAVORITED BOOLEAN, CONTRIBUTORS LIST<BIGINT>);
createTable – end
Cria tabela por usuario
createTable – init
createTable – command: CREATE TABLE IF NOT EXISTS TWEETSBYUSER(USR TEXT, TTEXT TEXT, DATE TEXT, ID BIGINT, SOURCE TEXT, ISTRUNCATED BOOLEAN, LATITUDE DOUBLE, LONGITUDE DOUBLE, ISFAVORITED BOOLEAN, CONTRIBUTORS LIST<BIGINT>, PRIMARY KEY ((ID, USR)));
createTable – end
Insere Tweets
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('NEYMARJR', 'EAI FAKE?', '02-02-19', -1454100678410326837, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweet – end
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('MESSI', 'ISSO EH PROBLEMA', '02-02-19', -82179786846801341, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', FALSE, 8748943.0, 9474740.0, FALSE, NULL);
insertTweet – end
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('OBAMA', 'HEY FAKE', '02-03-19', 7483171046020323633, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweet – end
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('NEYMARJR', 'CHEGANDO COM OS REFRI', '22-01-13', 4926445673016545348, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweet – end
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('SUAREZ', 'OLHA A DENTADA', '15-06-14', 12, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, FALSE, NULL);
insertTweet – end
insertTweet – init
insetTweet – command: INSERT INTO TWEETS(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED,LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('MESSI', 'FUI ELIMINADO', '07-02-19', 9173019729753634489, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweet – end
Insere TweetsByUser
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('NEYMARJR', 'EAI FAKE?', '02-02-19', -1454100678410326837, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweetByUser – end
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('MESSI', 'ISSO EH PROBLEMA', '02-02-19', -82179786846801341, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', FALSE, 8748943.0, 9474740.0, FALSE, NULL);
insertTweetByUser – end
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('OBAMA', 'HEY FAKE', '02-03-19', 7483171046020323633, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweetByUser – end
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('NEYMARJR', 'CHEGANDO COM OS REFRI', '22-01-13', 4926445673016545348, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweetByUser – end
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('SUAREZ', 'OLHA A DENTADA', '15-06-14', 12, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, FALSE, NULL);
insertTweetByUser – end
insertTweetByUser – init
insetTweet – command: INSERT INTO TWEETSBYUSER(USR, TTEXT, DATE, ID, SOURCE, ISTRUNCATED, LATITUDE, LONGITUDE, ISFAVORITED, CONTRIBUTORS) VALUES ('MESSI', 'FUI ELIMINADO', '07-02-19', 9173019729753634489, 'A HREF="HTTP://TWITTER.COM" REL="NOFOLLOW"&GT;TWITTER WEB CLIENT', TRUE, 8748943.0, 9474740.0, TRUE, NULL);
insertTweetByUser – end


Buscando tweets em Tweets
selectAll – init
SELECT * FROM TWEETS
selectAll – command: SELECT * FROM TWEETS

@Suarez: Olha a dentada
Dados do tweet - Data: 15-06-14
id: 12
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@NeymarJr: Chegando com os refri
Dados do tweet - Data: 22-01-13
id: 4926445673016545348
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@NeymarJr: Eai fake?
Dados do tweet - Data: 02-02-19
id: -1454100678410326837
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: Fui eliminado
Dados do tweet - Data: 07-02-19
id: 9173019729753634489
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Obama: Hey fake
Dados do tweet - Data: 02-03-19
id: 7483171046020323633
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: isso eh problema
Dados do tweet - Data: 02-02-19
id: -82179786846801341
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: false
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

selectAll – end

Buscando tweets em TweetsByUser
selectAllByUser – init
selectAllByUser – command: SELECT * FROM TWEETSBYUSER

@NeymarJr: Eai fake?
Dados do tweet - Data: 02-02-19
id: -1454100678410326837
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Obama: Hey fake
Dados do tweet - Data: 02-03-19
id: 7483171046020323633
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: Fui eliminado
Dados do tweet - Data: 07-02-19
id: 9173019729753634489
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Suarez: Olha a dentada
Dados do tweet - Data: 15-06-14
id: 12
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: isso eh problema
Dados do tweet - Data: 02-02-19
id: -82179786846801341
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: false
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@NeymarJr: Chegando com os refri
Dados do tweet - Data: 22-01-13
id: 4926445673016545348
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:
selectAllByUser – end
Buscando tweets por usuario: Messi
selectAllByUser – init
selectAllByUser – command: SELECT * FROM TWEETSBYUSER WHERE USR = 'MESSI' ALLOW FILTERING;

@Messi: Fui eliminado
Dados do tweet - Data: 07-02-19
id: 9173019729753634489
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: isso eh problema
Dados do tweet - Data: 02-02-19
id: -82179786846801341
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: false
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:
selectAllByUser – end

Deleting tweet "Olha a dentada" - id=12 na tabela Tweets
deleteTweet – init
deleteTweet – command: DELETE FROM TWEETS WHERE ID = 12;
deleteTweet – end

Deleting tweet "Olha a dentada" - id=12 na tabela TweetsByUser
deleteTweetByUser – init
deleteTweet – command: DELETE FROM TWEETSBYUSER WHERE ID = 12 AND USR = 'SUAREZ';
deleteTweetByUser – end

Buscando tweets depois do delete em Tweets
selectAll – init
SELECT * FROM TWEETS
selectAll – command: SELECT * FROM TWEETS

@NeymarJr: Chegando com os refri
Dados do tweet - Data: 22-01-13
id: 4926445673016545348
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@NeymarJr: Eai fake?
Dados do tweet - Data: 02-02-19
id: -1454100678410326837
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: Fui eliminado
Dados do tweet - Data: 07-02-19
id: 9173019729753634489
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Obama: Hey fake
Dados do tweet - Data: 02-03-19
id: 7483171046020323633
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: isso eh problema
Dados do tweet - Data: 02-02-19
id: -82179786846801341
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: false
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

selectAll – end

Buscando tweets depois do delete em TweetsByUser
selectAllByUser – init
selectAllByUser – command: SELECT * FROM TWEETSBYUSER

@NeymarJr: Eai fake?
Dados do tweet - Data: 02-02-19
id: -1454100678410326837
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Obama: Hey fake
Dados do tweet - Data: 02-03-19
id: 7483171046020323633
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: Fui eliminado
Dados do tweet - Data: 07-02-19
id: 9173019729753634489
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@Messi: isso eh problema
Dados do tweet - Data: 02-02-19
id: -82179786846801341
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: false
isFavorited?: false
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:

@NeymarJr: Chegando com os refri
Dados do tweet - Data: 22-01-13
id: 4926445673016545348
source: a href="http://twitter.com" rel="nofollow"&gt;Twitter Web Client
isTruncated?: true
isFavorited?: true
geolocalizacao - latitude: 8748943.0
geolocalizacao - longitude: 9474740.0
contributors:
selectAllByUser – end
Deleta tabela Tweets
deleteTable – init
deleteTable – command: DROP TABLE IF EXISTS TWEETS
deleteTable – end
Deleta tabela TweetsByUser
deleteTable – init
deleteTable – command: DROP TABLE IF EXISTS TWEETSBYUSER
deleteTable – end
Deleta keyspace
deleteKeyspace – init
deleteKeyspace – command: DROP KEYSPACE TWEETS
deleteKeyspace – end

Process finished with exit code 0
