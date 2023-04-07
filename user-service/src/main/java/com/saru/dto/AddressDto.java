package com.saru.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {

    @NotBlank(message = "Address line1 is mandatory")
    @Size(min = 10,max = 50,message = "Should contain at least 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 .-]+$",message = "Invalid format for address line1")
    private String addressLine1;

    private String addressLine2;

   @NotBlank(message = "Zip code is mandatory")
//    @Size(min = 5,max = 9,message = "Should contain at least 5 digits")
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code must be 5 to 9 digits")
    private String zipCode;

    @NotBlank(message = "City is mandatory")
    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Invalid format for user name")
    private String city;

    @NotBlank(message = "State is mandatory")
    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Invalid format for state")
    private String state;

    @NotBlank(message = "Country name is mandatory")
    @Size(min = 2,max = 50,message = "Should contain at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Invalid format for country")
    private String country;

}
