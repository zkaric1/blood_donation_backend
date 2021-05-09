package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
@Table(name = "T_ZANIMANJA", schema = "dbo", catalog = "ck_db")
public class TZanimanjaEntity {
    private String zanimanje;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "ZANIMANJE")
    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    @Basic
    @Column(name = "NAZIV")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "VAZI")
    public boolean isVazi() {
        return vazi;
    }

    public void setVazi(boolean vazi) {
        this.vazi = vazi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TZanimanjaEntity that = (TZanimanjaEntity) o;

        if (vazi != that.vazi) return false;
        if (zanimanje != null ? !zanimanje.equals(that.zanimanje) : that.zanimanje != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zanimanje != null ? zanimanje.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
