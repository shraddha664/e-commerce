package com.saru.repository;

import com.saru.dto.AddressDto;
import com.saru.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Modifying
    @Query("UPDATE Address a SET a.addressLine1 = :#{#addressDto.addressLine1}, a.addressLine2 = :#{#addressDto.addressLine2}, a.city = :#{#addressDto.city}, a.state = :#{#addressDto.state}, a.zipCode = :#{#addressDto.zipCode}, a.country = :#{#addressDto.country} WHERE a.id = :addressId AND a.user.id = :userId")
    int updateAddress(@Param("userId") Long userId, @Param("addressId") Long addressId, @Param("addressDto")AddressDto addressDto);

    @Modifying
    @Query("Delete From Address a Where id=:addressId And a.user.id=:userId")
    int deleteAddressByIdAndUserId(@Param("userId") Long userId,@Param("addressId") Long addressId);
}
