package ba.red_cross.blood_donation;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_UPOSLENICI", schema = "dbo", catalog = "ck_db")
public class VUposleniciEntity {
    private Integer kontaktId;
    private String prezimeIme;
    private Boolean vazi;

    @Basic
    @Column(name = "KONTAKT_ID")
    public Integer getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(Integer kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Basic
    @Column(name = "PREZIME_IME")
    public String getPrezimeIme() {
        return prezimeIme;
    }

    public void setPrezimeIme(String prezimeIme) {
        this.prezimeIme = prezimeIme;
    }

    @Basic
    @Column(name = "VAZI")
    public Boolean getVazi() {
        return vazi;
    }

    public void setVazi(Boolean vazi) {
        this.vazi = vazi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VUposleniciEntity that = (VUposleniciEntity) o;

        if (kontaktId != null ? !kontaktId.equals(that.kontaktId) : that.kontaktId != null) return false;
        if (prezimeIme != null ? !prezimeIme.equals(that.prezimeIme) : that.prezimeIme != null) return false;
        if (vazi != null ? !vazi.equals(that.vazi) : that.vazi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId != null ? kontaktId.hashCode() : 0;
        result = 31 * result + (prezimeIme != null ? prezimeIme.hashCode() : 0);
        result = 31 * result + (vazi != null ? vazi.hashCode() : 0);
        return result;
    }
}
