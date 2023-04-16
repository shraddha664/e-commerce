package com.saru.repository;

import com.saru.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("Select u From User u Where u.userName=:userName Or u.email=:userEmail Or u.phoneNumber=:phoneNumber")
    Optional<List<User>> findByUserNameOrEmailOrPhoneNumber(@Param("userName") String userName, @Param("userEmail") String email, @Param("phoneNumber") String phoneNumber);
}
