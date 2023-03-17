package com.example.realestate;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM users WHERE mobileno LIKE %?1% AND pin LIKE %?2%", nativeQuery = true)
    public List<User> search(String phonekeyword, String pinkeyword);

}
