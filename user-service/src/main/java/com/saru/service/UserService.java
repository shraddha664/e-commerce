package com.saru.service;

import com.saru.dto.AddressDto;
import com.saru.dto.UserRegisterDto;
import com.saru.dto.UserResponseDto;

public interface UserService {
    void saveUser(UserRegisterDto userRegisterDto);

    void saveAddress(Long userId,AddressDto addressDto);

   UserResponseDto getUserDetails(Long userId);

    void updateUserDetails(Long userId, UserRegisterDto userRegisterDto);

    String updateAddress(Long userId, Long addressId, AddressDto addressDto);

    String deleteAddress(Long userId, Long addressId);
}
