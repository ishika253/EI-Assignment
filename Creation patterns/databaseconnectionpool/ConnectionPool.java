package databaseconnectionpool;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final List<DatabaseConnection> availableConnections;
    private final List<DatabaseConnection> usedConnections;
    private final int maxPoolSize;

    public ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.availableConnections = new ArrayList<>();
        this.usedConnections = new ArrayList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxPoolSize; i++) {
            availableConnections.add(new MySQLConnection());
        }
    }

    public DatabaseConnection acquireConnection() {
        if (availableConnections.isEmpty()) {
            return null; // or throw an exception
        }
        DatabaseConnection connection = availableConnections.remove(availableConnections.size() - 1);
        usedConnections.add(connection);
        connection.connect();
        return connection;
    }

    public void releaseConnection(DatabaseConnection connection) {
        if (usedConnections.remove(connection)) {
            connection.disconnect();
            availableConnections.add(connection);
        }
    }
}
