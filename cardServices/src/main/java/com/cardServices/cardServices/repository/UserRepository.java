package com.cardServices.cardServices.repository;

import com.cardServices.cardServices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.userName = ?1 where u.uid = ?2")
    void updateUserNameByUid(String userName, Integer uid);
    @Query("select u from User u where u.userName = ?1")
    Optional<User> findByUserName(String userName);
    @Transactional
    @Modifying
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.middleName = ?3, u.age = ?4, u.Email = ?5, u.mobile = ?6 where u.uid=?7")
    void updateUser(String firstName, String lastName, String middleName, Integer age, String Email, String mobile, Long Id);
//    @Query("select u from User u where u.email = ?1")
//    Optional<User> findByEmail(String Email);
}
