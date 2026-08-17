package bloodconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecipientOperations
        implements DatabaseOperations<Recipient> {

    private static final String URL =
            "jdbc:sqlite:database/bloodconnect.db";


    // =====================================================
    // ADD RECIPIENT
    // =====================================================

    @Override
    public void add(Recipient recipient)
            throws Exception {

        Connection connection =
                DriverManager.getConnection(URL);


        // Check duplicate recipient
        String checkSql =
                "SELECT COUNT(*) FROM recipients WHERE phone = ?";


        PreparedStatement checkStatement =
                connection.prepareStatement(checkSql);


        checkStatement.setString(
                1,
                recipient.getPhone()
        );


        ResultSet result =
                checkStatement.executeQuery();


        if (result.next()
                && result.getInt(1) > 0) {

            System.out.println(
                    "Recipient already exists!"
            );

            result.close();
            checkStatement.close();
            connection.close();

            return;
        }


        result.close();
        checkStatement.close();


        // Insert recipient
        String sql = """
                
                INSERT INTO recipients
                (name, age, gender, blood_group, phone, hospital, city)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                
                """;


        PreparedStatement statement =
                connection.prepareStatement(sql);


        statement.setString(
                1,
                recipient.getName()
        );

        statement.setInt(
                2,
                recipient.getAge()
        );

        statement.setString(
                3,
                recipient.getGender()
        );

        statement.setString(
                4,
                recipient.getBloodGroup()
        );

        statement.setString(
                5,
                recipient.getPhone()
        );

        statement.setString(
                6,
                recipient.getHospital()
        );

        statement.setString(
                7,
                recipient.getCity()
        );


        statement.executeUpdate();


        statement.close();
        connection.close();


        System.out.println(
                "Recipient added successfully!"
        );
    }


    // =====================================================
    // GET ALL RECIPIENTS
    // =====================================================

    @Override
    public ArrayList<Recipient> getAll()
            throws Exception {

        ArrayList<Recipient> recipients =
                new ArrayList<>();


        String sql =
                "SELECT * FROM recipients";


        Connection connection =
                DriverManager.getConnection(URL);


        PreparedStatement statement =
                connection.prepareStatement(sql);


        ResultSet result =
                statement.executeQuery();


        while (result.next()) {

            Recipient recipient =
                    new Recipient(

                            result.getString("name"),

                            result.getInt("age"),

                            result.getString("gender"),

                            result.getString("blood_group"),

                            result.getString("phone"),

                            result.getString("hospital"),

                            result.getString("city")
                    );


            recipients.add(recipient);
        }


        result.close();
        statement.close();
        connection.close();


        return recipients;
    }


    // =====================================================
    // SEARCH RECIPIENT BY BLOOD GROUP
    // =====================================================

    @Override
    public ArrayList<Recipient> searchByBloodGroup(
            String bloodGroup)
            throws Exception {

        ArrayList<Recipient> recipients =
                new ArrayList<>();


        String sql =
                "SELECT * FROM recipients WHERE blood_group = ?";


        Connection connection =
                DriverManager.getConnection(URL);


        PreparedStatement statement =
                connection.prepareStatement(sql);


        statement.setString(
                1,
                bloodGroup
        );


        ResultSet result =
                statement.executeQuery();


        while (result.next()) {

            Recipient recipient =
                    new Recipient(

                            result.getString("name"),

                            result.getInt("age"),

                            result.getString("gender"),

                            result.getString("blood_group"),

                            result.getString("phone"),

                            result.getString("hospital"),

                            result.getString("city")
                    );


            recipients.add(recipient);
        }


        result.close();
        statement.close();
        connection.close();


        return recipients;
    }
}