    package db;

    import db.DbExeption;
    import java.sql.Connection;
    import java.io.IOException;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;

    /**
     *
     * @author gueel
     */
    public class Conexao {

        private static String user = "root";
        private static String password = "Galinha3d";

        private static Connection conn = null;

        public static Connection getConnection() {
            if (conn == null) {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", user, password);

                } catch (SQLException e) {
                    throw new DbExeption(e.getMessage());
                }
            }
            return conn;
        }

        public static void closeConnection(Connection conn) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DbExeption(e.getMessage());
                }
            }
        }

        public static void closeConnection(Connection conn, Statement st) {
            if (conn != null && st != null) {
                try {
                    conn.close();
                    st.close();
                } catch (SQLException e) {
                    throw new DbExeption(e.getMessage());
                }
            }

        }

        public static void closeConnection(Connection conn, Statement st, ResultSet rs) {
            if (conn != null && st != null && rs != null) {
                try {
                    conn.close();
                    st.close();
                    rs.close();
                } catch (SQLException e) {
                    throw new DbExeption(e.getMessage());
                }
            }
        }
    }
