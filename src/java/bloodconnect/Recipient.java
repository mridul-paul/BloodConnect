package bloodconnect;

public class Recipient extends Person {

    private String bloodGroup;
    private String hospital;
    private String city;


    // Constructor
    public Recipient(
            String name,
            int age,
            String gender,
            String bloodGroup,
            String phone,
            String hospital,
            String city) {

        super(name, age, gender, phone);

        this.bloodGroup = bloodGroup;
        this.hospital = hospital;
        this.city = city;
    }


    // Getters

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getHospital() {
        return hospital;
    }

    public String getCity() {
        return city;
    }


    // Implementation of abstract method

    @Override
    public String getType() {

        return "Recipient";
    }
}