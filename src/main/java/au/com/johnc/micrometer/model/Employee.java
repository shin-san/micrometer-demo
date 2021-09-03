package au.com.johnc.micrometer.model;

public class Employee {

    public String firstName;
    public String lastName;
    public String age;
    public String dob;

    public Employee() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = "27";
        this.dob = "01/01/1993";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
