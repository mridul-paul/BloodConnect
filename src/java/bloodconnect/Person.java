package bloodconnect;

public abstract class Person {

    protected String name;
    protected int age;
    protected String gender;
    protected String phone;

    // Constructor
    public Person(String name, int age, String gender, String phone) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Abstract method
    public abstract String getType();


    // Getter methods

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
}