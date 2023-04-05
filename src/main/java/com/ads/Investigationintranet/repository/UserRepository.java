package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select u from User u " +
            "join fetch u.role r " +
            "left join fetch u.moduleAccesses ma " +
            "join fetch ma.module m " +
            "where u.userName = ?1")
    User findUserByUsername(String username);

//    User findUserByUsername(String username);

}
