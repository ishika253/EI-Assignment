package databaseconnectionpool;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(3); // Pool of 3 connections

        // Acquire connections
        DatabaseConnection conn1 = connectionPool.acquireConnection();
        DatabaseConnection conn2 = connectionPool.acquireConnection();
        DatabaseConnection conn3 = connectionPool.acquireConnection();
        
        // Attempt to acquire a fourth connection (should be null)
        DatabaseConnection conn4 = connectionPool.acquireConnection();
        if (conn4 == null) {
            System.out.println("No available connections!");
        }

        // Release connections back to the pool
        connectionPool.releaseConnection(conn1);
        connectionPool.releaseConnection(conn2);
        connectionPool.releaseConnection(conn3);

        // Re-acquire connections
        DatabaseConnection conn5 = connectionPool.acquireConnection();
        conn5.connect(); // Should work as we released earlier
        connectionPool.releaseConnection(conn5);
    }
}
