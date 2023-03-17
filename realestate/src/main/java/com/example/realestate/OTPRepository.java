package com.example.realestate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OTPRepository extends JpaRepository<OTP,Integer>{
    @Query(value = "SELECT * FROM otp WHERE mobileno LIKE %?1% AND codegenerated LIKE %?2%  AND status LIKE %?3% ", nativeQuery = true)
    public List<OTP> search(String phonekeyword, String codegeneratedkeyword, String statuskeyword);
}
