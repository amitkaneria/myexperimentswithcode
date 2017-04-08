package common;

import java.util.List;

public class UserAddress {
    private String firstName;
    private String lastName;
    private List<String> address;

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

    public List<String> getAddress() {
        return address;
    }
    public void setAddress(List<String> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}