package com.demo.app.userservice;

import java.util.Map;

import com.demo.app.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.demo.app.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
    UserRest getUserById(String userId);
    Map<String, UserRest> getUsers();
    void setUsers(Map<String, UserRest> users);
}
