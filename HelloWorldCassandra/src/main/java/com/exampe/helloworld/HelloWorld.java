package com.exampe.helloworld;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.utils.UUIDs;

public class HelloWorld {

    public static void main(String[] args){
        System.out.println("Hello world");
        Cluster cluster = null;
        try{
            cluster = Cluster.builder().addContactPoint("localhost").build();

            Session session = cluster.connect();

            ResultSet rs = session.execute("select release_version from system.local");
            Row row = rs.one();
            System.out.println(row.getString("release_version"));

            KeyspaceRepository sr = new KeyspaceRepository(session);
            sr.createKeyspace("library", "SimpleStrategy", 1);
            System.out.println("Create Repository");

            sr.useKeyspace("library");
            System.out.println("Using repository library");

            BookRepository br = new BookRepository(session);
            br.createTable();
            System.out.println("Create table book");

            br.alterTablebooks("publisher", "text");
            System.out.println("Alter table book");

            br.createTableBooksByTitle();
            System.out.println("Create table book - step 2");

            Book book = new Book(UUIDs.timeBased(), "Effective Java 1", "Joshua Bloch a",
                    "Programming 1");
            br.insertbook(book);
            Book book2 = new Book(UUIDs.timeBased(), "Effective Java 2", "Joshua Bloch a",
                    "Programming 2");
            br.insertbook(book2);
            System.out.println("Insert books");

            br.selectAll();

            br.deleteBookByTitle("Effective Java");
            br.deleteTable("books");
            br.deleteTable("booksByTitle");
            System.out.println("Delete books");

            sr.deleteKeyspace("library");
            System.out.println("Delete keyspace library");

        } finally {
            if (cluster != null) cluster.close();
        }
    }
}
