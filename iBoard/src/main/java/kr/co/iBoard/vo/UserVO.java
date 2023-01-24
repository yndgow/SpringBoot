package kr.co.iBoard.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserVO {
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
