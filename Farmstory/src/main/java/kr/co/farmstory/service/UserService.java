package kr.co.farmstory.service;

import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.repo.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }


    public int checkUid(String uid){
        return userRepository.countByUid(uid);
    }

    public void insertUser(UserDTO.SignUpReq signUpReq){
        UserEntity user = signUpReq.toEntity();
        user.userPass(passwordEncoder.encode(signUpReq.getPass2()));

        userRepository.save(user);
    }
}
