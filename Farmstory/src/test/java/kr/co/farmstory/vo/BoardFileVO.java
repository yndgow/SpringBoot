package kr.co.farmstory.vo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "board_file", schema = "java1_board", catalog = "")
public class BoardFileVO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fno")
    private int fno;
    @Basic
    @Column(name = "parent")
    private Integer parent;
    @Basic
    @Column(name = "newName")
    private String newName;
    @Basic
    @Column(name = "oriName")
    private String oriName;
    @Basic
    @Column(name = "download")
    private Integer download;
    @Basic
    @Column(name = "rdate")
    private Timestamp rdate;

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Timestamp getRdate() {
        return rdate;
    }

    public void setRdate(Timestamp rdate) {
        this.rdate = rdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardFileVO that = (BoardFileVO) o;
        return fno == that.fno && Objects.equals(parent, that.parent) && Objects.equals(newName, that.newName) && Objects.equals(oriName, that.oriName) && Objects.equals(download, that.download) && Objects.equals(rdate, that.rdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fno, parent, newName, oriName, download, rdate);
    }
}
