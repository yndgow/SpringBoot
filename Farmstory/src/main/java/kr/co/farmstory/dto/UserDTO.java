package kr.co.farmstory.dto;

import kr.co.farmstory.entity.UserEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDTO {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class SignUpReq{
        private String uid;
        private String pass2;
        private String name;
        private String nick;
        private String email;
        private String hp;

        public UserEntity toEntity(){

            return UserEntity.builder()
                    .uid(this.uid)
                    .pass(this.pass2)
                    .name(this.name)
                    .nick(this.nick)
                    .email(this.email)
                    .hp(this.hp)
                    .build();
        }
    }


}
