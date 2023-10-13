package com.tnt.hp.ServiceImpl;

import com.tnt.hp.Entity.User;
import com.tnt.hp.Repository.UserRepo;
import com.tnt.hp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    private String passwordEncryptor(String pw){
        Argon2PasswordEncoder pwEncoder  = new Argon2PasswordEncoder();
        String encPw = pwEncoder.encode(pw);
        return encPw;
    }

    private boolean passwordVerifier(String encPwfromDb, String pwFromUi ){
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        return passwordEncoder.matches(pwFromUi, encPwfromDb );
    }

    private boolean checkIfUserExists(User user){
        String emailId = user.getEmailId();
        Optional<User> existingUser = userRepo.findById(emailId);
        if(existingUser.isPresent()){return true;}
        return false;
    }

    @Override
    public String addUser(User newUser) {
        if(checkIfUserExists(newUser)){
           // Task : @Sowmya find a better way to do this
            return "User Already Exists, please Sign In";}
       String password = newUser.getPassword();
       String encPw = passwordEncryptor(password);
       newUser.setPassword(encPw);
       userRepo.save(newUser);
       return "User Added";
    }

    @Override
    public String signIn(String emailId, String password) {
        Optional<User> existingUser = userRepo.findById(emailId);
        User activeUser = null;
        String encPw = null;
        if(existingUser == null){
          // Task : @Sowmya find a better way to do this
            return "Could not find an Existing User, please Sign up";
        }else if(existingUser.isPresent()){
             activeUser = existingUser.get();
            encPw = activeUser.getPassword();
             if(passwordVerifier(encPw,password)){
                 //System.out.println("password correct and user exists");
                 return "password correct and user exists";
             }
        }
        return "user exists but wrong password";

    }
}
