package kr.co.farmstory.vo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "board_user", schema = "java1_board", catalog = "")
public class BoardUserVO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uid")
    private String uid;
    @Basic
    @Column(name = "pass")
    private String pass;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "nick")
    private String nick;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "hp")
    private String hp;
    @Basic
    @Column(name = "grade")
    private Byte grade;
    @Basic
    @Column(name = "zip")
    private String zip;
    @Basic
    @Column(name = "addr1")
    private String addr1;
    @Basic
    @Column(name = "addr2")
    private String addr2;
    @Basic
    @Column(name = "regip")
    private String regip;
    @Basic
    @Column(name = "rdate")
    private Timestamp rdate;
    @Basic
    @Column(name = "sessId")
    private String sessId;
    @Basic
    @Column(name = "sessLimitDate")
    private Timestamp sessLimitDate;
    @Basic
    @Column(name = "wdate")
    private Timestamp wdate;
    @Basic
    @Column(name = "pass1")
    private String pass1;
    @Basic
    @Column(name = "pass2")
    private String pass2;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip;
    }

    public Timestamp getRdate() {
        return rdate;
    }

    public void setRdate(Timestamp rdate) {
        this.rdate = rdate;
    }

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public Timestamp getSessLimitDate() {
        return sessLimitDate;
    }

    public void setSessLimitDate(Timestamp sessLimitDate) {
        this.sessLimitDate = sessLimitDate;
    }

    public Timestamp getWdate() {
        return wdate;
    }

    public void setWdate(Timestamp wdate) {
        this.wdate = wdate;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardUserVO that = (BoardUserVO) o;
        return Objects.equals(uid, that.uid) && Objects.equals(pass, that.pass) && Objects.equals(name, that.name) && Objects.equals(nick, that.nick) && Objects.equals(email, that.email) && Objects.equals(hp, that.hp) && Objects.equals(grade, that.grade) && Objects.equals(zip, that.zip) && Objects.equals(addr1, that.addr1) && Objects.equals(addr2, that.addr2) && Objects.equals(regip, that.regip) && Objects.equals(rdate, that.rdate) && Objects.equals(sessId, that.sessId) && Objects.equals(sessLimitDate, that.sessLimitDate) && Objects.equals(wdate, that.wdate) && Objects.equals(pass1, that.pass1) && Objects.equals(pass2, that.pass2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, pass, name, nick, email, hp, grade, zip, addr1, addr2, regip, rdate, sessId, sessLimitDate, wdate, pass1, pass2);
    }
}
