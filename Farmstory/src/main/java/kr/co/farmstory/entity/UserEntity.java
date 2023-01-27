package kr.co.farmstory.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "board_user")
public class UserEntity{

    @Id
    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private String hp;
    private int grade;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;
    private String rdate;
    private String wdate;

    @Builder
    public UserEntity(String uid, String pass, String name, String email, String nick, String hp){
        this.uid = uid;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.nick = nick;
        this.hp = hp;
    }

    public void userPass(String pass){
        this.pass = pass;
    }
}