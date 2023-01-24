package kr.co.iBoard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "board_user")
public class UserEntity {
    @Id
    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private int grade;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;
    private LocalDateTime rdate;
    private String wdate;
}
