package org.vikram.singletonpattern;

class DBConnection2{

    private DBConnection2(){

    }

    private static final class DBConnection2Holder {
        private static final DBConnection2 dbConnection = new DBConnection2();
    }

    public static DBConnection2 getInstance(){

        return DBConnection2Holder.dbConnection;
    }
}
public class Main2 {
    public static void main(String[] args) {
        DBConnection2 dbConnection = DBConnection2.getInstance();
        System.out.println(dbConnection.toString());
    }
}
