package bloodconnect;

public class Donor extends Person {

    private String bloodGroup;
    private String city;


    // Constructor
    public Donor(
            String name,
            int age,
            String gender,
            String bloodGroup,
            String phone,
            String city) {

        super(name, age, gender, phone);

        this.bloodGroup = bloodGroup;
        this.city = city;
    }


    // Getters

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getCity() {
        return city;
    }


    // Implementation of abstract method

    @Override
    public String getType() {

        return "Donor";
    }
}