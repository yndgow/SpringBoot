package kr.co.farmstory.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "board_terms", schema = "java1_board", catalog = "")
public class BoardTermsVO {
    @Basic
    @Column(name = "terms")
    private String terms;
    @Basic
    @Column(name = "privacy")
    private String privacy;

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardTermsVO that = (BoardTermsVO) o;
        return Objects.equals(terms, that.terms) && Objects.equals(privacy, that.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms, privacy);
    }
}
