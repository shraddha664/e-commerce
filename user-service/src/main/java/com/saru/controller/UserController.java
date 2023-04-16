package com.saru.controller;

import com.saru.dto.AddressDto;
import com.saru.dto.UserRegisterDto;
import com.saru.dto.UserResponseDto;
import com.saru.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;

    @Operation(summary = "Register's user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully retrieved"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterDto userRegisterDto){
        userService.saveUser(userRegisterDto);
        return ResponseEntity.status(200).body("User saved successfully");
    }


    @Operation(summary = "Save user address by using userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully saved"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @PostMapping("/{userId}/address")
    public ResponseEntity<String> saveAddress(@PathVariable("userId") Long userId,@Valid @RequestBody AddressDto addressDto){
        userService.saveAddress(userId,addressDto);
        return ResponseEntity.status(200).body("Address saved successfully");
    }

    @Operation(summary = "Fetch user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully retrieved"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable("userId") Long userId){
        log.info("inside get user info of controller");
        return ResponseEntity.status(200).body(userService.getUserDetails(userId));
    }

    @Operation(summary = "Update user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully updated"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @PutMapping("/{userId}")
    public ResponseEntity<String>  updateUserDetails(@PathVariable("userId")Long userId, @RequestBody UserRegisterDto userRegisterDto){
        userService.updateUserDetails(userId,userRegisterDto);
        return ResponseEntity.status(200).body( "User Details updated successfully");
    }

    @Operation(summary = "Update user's address ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully updated"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @PutMapping("/{userId}/address/{addressId}")
    public ResponseEntity<String>  updateAddress(@PathVariable("userId")Long userId,@PathVariable("addressId")Long addressId, @RequestBody AddressDto addressDto){
        return ResponseEntity.status(200).body(userService.updateAddress(userId,addressId,addressDto));
    }

    @Operation(summary = "Delete user's particular address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="Successfully deleted"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "404",description = "Data not found")
    })
    @DeleteMapping("/{userId}/address/{addressId}")
    public ResponseEntity<String>  deleteAddress(@PathVariable("userId")Long userId,@PathVariable("addressId")Long addressId){
        return ResponseEntity.status(200).body(userService.deleteAddress(userId,addressId));
    }
}
