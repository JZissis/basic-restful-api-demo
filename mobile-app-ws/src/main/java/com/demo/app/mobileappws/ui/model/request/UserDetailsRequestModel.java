package com.demo.app.mobileappws.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First name cannot be left empty.")
    @Size(min = 2, message = "First name cannot be smaller than 2 characters.")
    private String firstName;
    @NotNull(message = "Last name cannot be left empty.")
    @Size(min = 2, message = "Last name cannot be smaller than 2 characters.")
    private String lastName; 
    @NotNull(message = "Email cannot be left empty.")
    @Email
    private String email;
    @NotNull(message = "Password cannot be left empty.")
    @Size(min = 6, max = 16, message = "Password must be between 6 to 16 characters long.")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
