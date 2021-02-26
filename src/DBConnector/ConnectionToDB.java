package DBConnector;

import java.sql.*;

public class ConnectionToDB {

    public static void  connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/jennapetersen/IdeaProjects/MobilePay_DB/DB/mobilepay.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            String sqlCompany = "SELECT * FROM Company";
            String sqlUsers = "SELECT * FROM Users";
            String sqlUserTransactions = "SELECT * FROM Transactions";
            String sqlCompanyTransactions = "SELECT * FROM CompanyTransactions";

            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sqlCompany);

            System.out.println(sqlCompany);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\n" +
                        rs.getString(2) + "\n" +
                        rs.getString(3) + "\n" +
                        rs.getString(4) + "\n" +
                        rs.getInt(5) + "\n"

                );
            }

            Statement stmt2  = conn.createStatement();
            ResultSet rs2    = stmt2.executeQuery(sqlUserTransactions);

            System.out.println(sqlUserTransactions);
            while (rs2.next()) {
                System.out.println(rs2.getInt(1) + "\n" +
                        rs2.getInt(2) + "\n" +
                        rs2.getInt(3) + "\n" +
                        rs2.getDouble(4) + "\n"
                );
            }

            Statement stmt3  = conn.createStatement();
            ResultSet rs3    = stmt3.executeQuery(sqlCompanyTransactions);

            System.out.println(sqlCompanyTransactions);
            while (rs3.next()) {
                System.out.println(rs3.getInt(1) + "\n" +
                        rs3.getInt(2) + "\n" +
                        rs3.getInt(3) + "\n" +
                        rs3.getDouble(4) + "\n"
                );
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        connect();
    }

    }

