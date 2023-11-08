package com.demo.app.userservice;

import com.demo.app.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.demo.app.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
