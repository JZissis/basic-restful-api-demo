package com.demo.app.mobileappws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "First name cannot be left empty.")
    @Size(min = 2, message = "First name cannot be smaller than 2 characters.")
    private String firstName;
    @NotNull(message = "Last name cannot be left empty.")
    @Size(min = 2, message = "Last name cannot be smaller than 2 characters.")
    private String lastName;

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
}
