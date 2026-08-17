package bloodconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    // SQLite database location
    private static final String URL =
            "jdbc:sqlite:database/bloodconnect.db";


    // This method creates the required tables
    public static void createTables() {

        try {

            // Connect to SQLite database
            Connection connection =
                    DriverManager.getConnection(URL);

            // Create Statement object
            Statement statement =
                    connection.createStatement();


            // Donor table
            String donorTable = """
                    
                    CREATE TABLE IF NOT EXISTS donors (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        name TEXT NOT NULL,

                        age INTEGER NOT NULL,

                        gender TEXT NOT NULL,

                        blood_group TEXT NOT NULL,

                        phone TEXT NOT NULL,

                        city TEXT NOT NULL
                    )
                    
                    """;


            // Recipient table
            String recipientTable = """
                    
                    CREATE TABLE IF NOT EXISTS recipients (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        name TEXT NOT NULL,

                        age INTEGER NOT NULL,

                        gender TEXT NOT NULL,

                        blood_group TEXT NOT NULL,

                        phone TEXT NOT NULL,

                        hospital TEXT NOT NULL,

                        city TEXT NOT NULL
                    )
                    
                    """;


            // Execute donor table creation
            statement.execute(donorTable);

            // Execute recipient table creation
            statement.execute(recipientTable);


            // Close resources
            statement.close();

            connection.close();


            System.out.println(
                    "Tables created successfully!"
            );


        } catch (Exception e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage()
            );
        }
    }
}