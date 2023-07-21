package model;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String dob;
    private String address;
    private String gender;
    private String city;
    private String password;

    public User() {

    }

    public User(String firstName, String lastName, String email, String mobile, String dob, String address, String gender, String city, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.city = city;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String email, String mobile, String dob, String address, String gender, String city, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.city = city;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
