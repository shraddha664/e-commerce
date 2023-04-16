package com.saru.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {

//    @NotBlank(message = "Address line1 is mandatory")
//    @Size(min = 10,max = 50,message = "Should contain at least 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 .-]{5,50}$",message = "Address line1 should contain at least 5 characters")
    private String addressLine1;

    private String addressLine2;

//    @NotBlank(message = "Zip code is mandatory")
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code must be 5 to 9 digits")
    private String zipCode;

//    @NotBlank(message = "City is mandatory")
//    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "User name should contain at least 2 characters")
    private String city;

//    @NotBlank(message = "State is mandatory")
//    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]{2,50}$",message = " State name should contain at least 2 characters")
    private String state;

//    @NotBlank(message = "Country name is mandatory")
//    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "Country name should contain at least 2 characters")
    private String country;

}
