package org.vikram.singletonpattern;

class DBConnection{
    private static volatile DBConnection dbConnection = null;

    private DBConnection(){

    }

    public static DBConnection getInstance(){
        if(dbConnection==null){
            synchronized (DBConnection.class){
                if(dbConnection==null){
                    dbConnection=new DBConnection();
                }
            }
        }

        return dbConnection;
    }
}
public class Main1 {
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
        System.out.println(dbConnection.toString());
    }
}
