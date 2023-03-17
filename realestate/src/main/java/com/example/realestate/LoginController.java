package com.example.realestate;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller

public class LoginController {

    @Autowired
    private LoginAttemptsRepository loginAttemptsRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPRepository otpRepository;

    @ResponseBody
    @RequestMapping(value = "/mobilelogin", method = RequestMethod.POST)
    public String mobileLogin(@RequestParam String phone, @RequestParam String pin){
        String result="{phone:"+phone+",pin: "+pin+"}";
        LoginAttempts LA=new LoginAttempts(phone,pin,"");
        loginAttemptsRepository.save(LA);
        List<User> USR=userRepository.search(phone,pin);

        if(USR.isEmpty()){
            result="{login:invalid}";
        }else{
            //INSERT CODE FOR GENERATING OTP
            String OTPGenerated=generateOTP(phone,USR.get(0).getId());
            NetworkActivity netOps = new NetworkActivity();
            HashMap<String,Object> map=new HashMap<>();
            map.put("recepients",phone);
            map.put("message",OTPGenerated);
            map.put("accesskey","sga2022now");
            String smsurl="https://comms.sgasecurity.com/sgasms/executesender.php";
            try {
                netOps.executeURL(smsurl,map);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            result="{\"login\":\"valid\",\"userid\":\""+USR.get(0).getId().toString()+"\"}";
        }

        return result;
    }
    public String generateOTP(String phone,Integer personlogginid){
        Random rand = new Random();
        int otp_code = rand.nextInt(10000,99999);
        OTP myotp=new OTP(personlogginid,phone,Integer.toString(otp_code),"-1","pending");
        otpRepository.save(myotp);
        System.out.println("New otp id: "+myotp.getId().toString());
        return Integer.toString(otp_code);

    }

    @ResponseBody
    @RequestMapping(value = "/confirmotp",method = RequestMethod.POST)
    public String confirmsOTP(@RequestParam String otpsentback,@RequestParam String phonenumber){
        try{
        System.out.println("phone:"+phonenumber+" otpsentback:"+otpsentback);
        List<OTP> otpList=otpRepository.search(phonenumber,otpsentback,"pending");
        if(otpList.isEmpty()){
            return "{otp:invalid}";
        }else{
            return "(otp:valid}";
        }
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }


    }



}
