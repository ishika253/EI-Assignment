package databaseconnectionpool;

public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("MySQL Database Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("MySQL Database Disconnected");
    }
}
