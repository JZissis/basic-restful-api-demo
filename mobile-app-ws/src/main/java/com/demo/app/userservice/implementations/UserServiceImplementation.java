package com.demo.app.userservice.implementations;

import com.demo.app.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.demo.app.shared.Utils;
import com.demo.app.ui.model.response.UserRest;
import com.demo.app.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImplementation implements UserService {
    Map<String, UserRest> users;
    Utils utils;
    @Autowired
    public UserServiceImplementation(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest user = new UserRest();
        user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        user.setUserId(userId);
        if (users == null)
            users = new HashMap<>();
        users.put(userId, user);

        return user;
    }
}
