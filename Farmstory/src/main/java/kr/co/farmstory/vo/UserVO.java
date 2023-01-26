package kr.co.farmstory.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserVO {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return getGrade() == userVO.getGrade() && Objects.equals(getUid(), userVO.getUid()) && Objects.equals(getPass(), userVO.getPass()) && Objects.equals(getName(), userVO.getName()) && Objects.equals(getNick(), userVO.getNick()) && Objects.equals(getEmail(), userVO.getEmail()) && Objects.equals(getHp(), userVO.getHp()) && Objects.equals(getZip(), userVO.getZip()) && Objects.equals(getAddr1(), userVO.getAddr1()) && Objects.equals(getAddr2(), userVO.getAddr2()) && Objects.equals(getRegip(), userVO.getRegip()) && Objects.equals(getRdate(), userVO.getRdate()) && Objects.equals(getWdate(), userVO.getWdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getPass(), getName(), getNick(), getEmail(), getHp(), getGrade(), getZip(), getAddr1(), getAddr2(), getRegip(), getRdate(), getWdate());
    }
}
