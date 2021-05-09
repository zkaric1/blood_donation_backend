package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
@Table(name = "T_TIP_KORISNIKA", schema = "dbo", catalog = "ck_db")
public class TTipKorisnikaEntity {
    private String tipKorisnika;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "TIP_KORISNIKA")
    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
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

        TTipKorisnikaEntity that = (TTipKorisnikaEntity) o;

        if (vazi != that.vazi) return false;
        if (tipKorisnika != null ? !tipKorisnika.equals(that.tipKorisnika) : that.tipKorisnika != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipKorisnika != null ? tipKorisnika.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
