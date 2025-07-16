package com.vedant.user_service.dao;

import com.vedant.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET name = :name, email = :email, timestamp = :timestamp WHERE user_id = :userId", nativeQuery = true)
    int updateUserByUserId(@Param("userId") Long userId,
                                                     @Param("name") String name,
                                                     @Param("email") String email,
                                                     @Param("timestamp") Timestamp timestamp);


}
