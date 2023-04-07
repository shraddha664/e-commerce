package com.saru.service;

import com.saru.dto.AddressDto;
import com.saru.dto.UserRegisterDto;
import com.saru.dto.UserResponseDto;
import com.saru.error.UserServiceException;
import com.saru.model.Address;
import com.saru.model.User;
import com.saru.repository.AddressRepository;
import com.saru.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional
    public void saveUser(UserRegisterDto userRegisterDto) {
        userRepository.save( User.builder()
                .userName(userRegisterDto.getUserName())
                .password(userRegisterDto.getPassword())
                .email(userRegisterDto.getEmail())
                .firstName(userRegisterDto.getFirstName())
                .lastName(userRegisterDto.getLastName())
                .phoneNumber(userRegisterDto.getPhoneNumber())
                .build());
    }

    @Override
    @Transactional
    public void saveAddress(Long userId,AddressDto addressDto) {
        User user=userRepository.findById(userId).orElseThrow(()->new UserServiceException("No such user exists"));

        Address address=Address.builder()
                .user(user)
                .addressLine1(addressDto.getAddressLine1())
                .addressLine2(addressDto.getAddressLine2())
                .city(addressDto.getCity())
                .zipCode(addressDto.getZipCode())
                .state(addressDto.getState())
                .country(addressDto.getCountry())
                .build();
        addressRepository.save(address);
        user.getAddresses().add(address);
        userRepository.save(user);

    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserDetails(Long userId) {
        log.info("inside getUserDetails of userServiceImpl");

        User user= userRepository.findById(userId).orElseThrow(()->new UserServiceException("No such user exists"));
        log.info(String.format("user info->%s,%s,%s,%s,%s,%s",user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getPhoneNumber()));
        List<AddressDto> addressDtoList = user.getAddresses().stream()
                .map(address -> AddressDto.builder()
                        .zipCode(address.getZipCode())
                        .state(address.getState())
                        .country(address.getCountry())
                        .addressLine2(address.getAddressLine2())
                        .addressLine1(address.getAddressLine1())
                        .city(address.getCity())
                        .build())
                .collect(Collectors.toList());

        return UserResponseDto.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .addressDtoList(addressDtoList)
                .build();
    }

    @Override
    @Transactional
    public void updateUserDetails(Long userId, UserRegisterDto userRegisterDto) {
        log.info("inside updateUserDetails of service ");
        User user=userRepository.findById(userId).orElseThrow(()->new UserServiceException("No such user exist"));
        if (userRegisterDto.getUserName()!=null){
            user.setUserName(userRegisterDto.getUserName());
        }
        if (userRegisterDto.getPhoneNumber()!=null){
            user.setPhoneNumber(userRegisterDto.getPhoneNumber());

        }if (userRegisterDto.getFirstName()!=null){
            user.setFirstName(userRegisterDto.getFirstName());

        }
        if (userRegisterDto.getEmail()!=null){
            user.setEmail(userRegisterDto.getEmail());
        }
        if (userRegisterDto.getLastName()!=null){
            user.setLastName(userRegisterDto.getLastName());
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public String updateAddress(Long userId, Long addressId, AddressDto addressDto) {
      if (addressRepository.updateAddress(userId,addressId,addressDto)>0){
          return "Address updated successfully";
      }else {
          throw new UserServiceException("No such user or address found");
      }
    }

    @Override
    @Transactional
    public String deleteAddress(Long userId, Long addressId) {
      if ( addressRepository.deleteAddressByIdAndUserId(userId,addressId)>0){
          return "Address deleted successfully";
      }else {
          throw new UserServiceException("No such user or address found");
      }
    }
}
