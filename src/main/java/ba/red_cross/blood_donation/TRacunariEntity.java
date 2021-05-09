package ba.red_cross.blood_donation;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "T_RACUNARI", schema = "dbo", catalog = "ck_db")
public class TRacunariEntity {
    private byte racunarId;
    private String naziv;
    private String nazivPrikaz;
    private byte[] certifikat;
    private boolean vazi;

    @Id
    @Column(name = "RACUNAR_ID")
    public byte getRacunarId() {
        return racunarId;
    }

    public void setRacunarId(byte racunarId) {
        this.racunarId = racunarId;
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
    @Column(name = "NAZIV_PRIKAZ")
    public String getNazivPrikaz() {
        return nazivPrikaz;
    }

    public void setNazivPrikaz(String nazivPrikaz) {
        this.nazivPrikaz = nazivPrikaz;
    }

    @Basic
    @Column(name = "CERTIFIKAT")
    public byte[] getCertifikat() {
        return certifikat;
    }

    public void setCertifikat(byte[] certifikat) {
        this.certifikat = certifikat;
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

        TRacunariEntity that = (TRacunariEntity) o;

        if (racunarId != that.racunarId) return false;
        if (vazi != that.vazi) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;
        if (nazivPrikaz != null ? !nazivPrikaz.equals(that.nazivPrikaz) : that.nazivPrikaz != null) return false;
        if (!Arrays.equals(certifikat, that.certifikat)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) racunarId;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (nazivPrikaz != null ? nazivPrikaz.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(certifikat);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
