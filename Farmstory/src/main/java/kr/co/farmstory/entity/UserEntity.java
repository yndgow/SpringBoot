package kr.co.farmstory.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}