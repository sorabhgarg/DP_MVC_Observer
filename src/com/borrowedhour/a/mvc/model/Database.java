package com.borrowedhour.a.mvc.model;

/**
 * Created by borrowedhour on 8/16/15.
 */
public class Database {

    private static Database dbInstance;

    private Database() {
    }

    public static synchronized Database getDbInstance() {
    //This lazy initialization needs to be synchronized to make it thread safe, to do away with this complexity,
    // popularly people initialize in the declaration.
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }

    public void connect(){
        System.out.println("Connected to db.");
    }


    public void disconnect(){
        System.out.println("Dis-connected from db.");
    }
}
