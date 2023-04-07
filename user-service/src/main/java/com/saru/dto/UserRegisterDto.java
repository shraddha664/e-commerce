package com.saru.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    @NotNull(message = "User name should not be null")
    @Size(min = 2,max = 50,message = "User name should be at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "Invalid format for user name")
    private String userName;

    @NotNull(message = "password should not be null")
    @Size(min = 8,max = 16,message ="Password should be 8 to 16 characters")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}$",message = "Invalid format for password")
    private String password;

    @NotNull(message = "First name should not be null")
    @Size(min = 2,max = 50,message = "First name should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Invalid format for first name")
    private String firstName;

    @NotNull(message = "Last name should not be null")
    @Size(min = 2,max = 50,message = "Last name should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Invalid format for last name")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Invalid format for email ")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^(?:(?:\\d{3}-|\\(\\d{3}\\)\\s?)?\\d{3}-\\d{4}|\\d{10})$",message = "Invalid phone number format")
    private  String phoneNumber;

}
