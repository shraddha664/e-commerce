package com.saru.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserResponseDto {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private  String phoneNumber;
    private List<AddressDto> addressDtoList;

}
