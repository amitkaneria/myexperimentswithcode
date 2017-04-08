package common;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static UserAddress getUserAddressInstance(){
        UserAddress userAddress = new UserAddress();
        userAddress.setFirstName("Amit");
        userAddress.setLastName("Kaneria");
        List<String> address = new ArrayList<>();
        address.add("130 Laidlaw Ave");
        address.add("Jersey City");
        address.add("NJ 07307");
        userAddress.setAddress(address);

        return userAddress;
    }

    public static User getUserInstance(){
        User user = new User();
        user.setFirstName("Amit");
        user.setLastName("Kaneria");

        return user;
    }
}