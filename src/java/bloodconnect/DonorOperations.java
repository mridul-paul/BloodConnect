package bloodconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DonorOperations
        implements DatabaseOperations<Donor> {

    private static final String URL =
            "jdbc:sqlite:database/bloodconnect.db";


    // =====================================================
    // ADD DONOR
    // =====================================================

    @Override
    public void add(Donor donor) throws Exception {

        Connection connection =
                DriverManager.getConnection(URL);


        // Check whether donor already exists
        String checkSql =
                "SELECT COUNT(*) FROM donors WHERE phone = ?";

        PreparedStatement checkStatement =
                connection.prepareStatement(checkSql);

        checkStatement.setString(
                1,
                donor.getPhone()
        );


        ResultSet result =
                checkStatement.executeQuery();


        if (result.next()
                && result.getInt(1) > 0) {

            System.out.println(
                    "Donor already exists!"
            );

            result.close();
            checkStatement.close();
            connection.close();

            return;
        }


        result.close();
        checkStatement.close();


        // Insert new donor
        String sql = """
                
                INSERT INTO donors
                (name, age, gender, blood_group, phone, city)
                VALUES (?, ?, ?, ?, ?, ?)
                
                """;


        PreparedStatement statement =
                connection.prepareStatement(sql);


        statement.setString(
                1,
                donor.getName()
        );

        statement.setInt(
                2,
                donor.getAge()
        );

        statement.setString(
                3,
                donor.getGender()
        );

        statement.setString(
                4,
                donor.getBloodGroup()
        );

        statement.setString(
                5,
                donor.getPhone()
        );

        statement.setString(
                6,
                donor.getCity()
        );


        statement.executeUpdate();


        statement.close();
        connection.close();


        System.out.println(
                "Donor added successfully!"
        );
    }


    // =====================================================
    // GET ALL DONORS
    // =====================================================

    @Override
    public ArrayList<Donor> getAll()
            throws Exception {

        ArrayList<Donor> donors =
                new ArrayList<>();


        String sql =
                "SELECT * FROM donors";


        Connection connection =
                DriverManager.getConnection(URL);


        PreparedStatement statement =
                connection.prepareStatement(sql);


        ResultSet result =
                statement.executeQuery();


        while (result.next()) {

            Donor donor = new Donor(

                    result.getString("name"),

                    result.getInt("age"),

                    result.getString("gender"),

                    result.getString("blood_group"),

                    result.getString("phone"),

                    result.getString("city")
            );


            donors.add(donor);
        }


        result.close();
        statement.close();
        connection.close();


        return donors;
    }


    // =====================================================
    // SEARCH DONOR BY BLOOD GROUP
    // =====================================================

    @Override
    public ArrayList<Donor> searchByBloodGroup(
            String bloodGroup)
            throws Exception {

        ArrayList<Donor> donors =
                new ArrayList<>();


        String sql =
                "SELECT * FROM donors WHERE blood_group = ?";


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

            Donor donor = new Donor(

                    result.getString("name"),

                    result.getInt("age"),

                    result.getString("gender"),

                    result.getString("blood_group"),

                    result.getString("phone"),

                    result.getString("city")
            );


            donors.add(donor);
        }


        result.close();
        statement.close();
        connection.close();


        return donors;
    }
    // =====================================================
// FIND COMPATIBLE DONORS
// =====================================================

public ArrayList<Donor> findCompatibleDonors(
        String recipientBloodGroup)
        throws Exception {

    ArrayList<Donor> donors =
            new ArrayList<>();

    String sql =
            "SELECT * FROM donors WHERE blood_group = ?";

    Connection connection =
            DriverManager.getConnection(URL);

    PreparedStatement statement =
            connection.prepareStatement(sql);

    String[] compatibleGroups =
            getCompatibleDonorGroups(
                    recipientBloodGroup
            );

    for (String group : compatibleGroups) {

        statement.setString(
                1,
                group
        );

        ResultSet result =
                statement.executeQuery();

        while (result.next()) {

            Donor donor = new Donor(

                    result.getString("name"),

                    result.getInt("age"),

                    result.getString("gender"),

                    result.getString("blood_group"),

                    result.getString("phone"),

                    result.getString("city")
            );

            donors.add(donor);
        }

        result.close();
    }

    statement.close();
    connection.close();

    return donors;
}


// =====================================================
// BLOOD COMPATIBILITY LOGIC
// =====================================================

private String[] getCompatibleDonorGroups(
        String recipientBloodGroup) {

    switch (recipientBloodGroup) {

        case "O-":
            return new String[]{"O-"};

        case "O+":
            return new String[]{"O-", "O+"};

        case "A-":
            return new String[]{"O-", "A-"};

        case "A+":
            return new String[]{
                    "O-",
                    "O+",
                    "A-",
                    "A+"
            };

        case "B-":
            return new String[]{
                    "O-",
                    "B-"
            };

        case "B+":
            return new String[]{
                    "O-",
                    "O+",
                    "B-",
                    "B+"
            };

        case "AB-":
            return new String[]{
                    "O-",
                    "A-",
                    "B-",
                    "AB-"
            };

        case "AB+":
            return new String[]{
                    "O-",
                    "O+",
                    "A-",
                    "A+",
                    "B-",
                    "B+",
                    "AB-",
                    "AB+"
            };

        default:
            return new String[]{};
    }
}
}