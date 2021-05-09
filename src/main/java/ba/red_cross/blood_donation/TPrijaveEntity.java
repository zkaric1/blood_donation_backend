package ba.red_cross.blood_donation;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "T_PRIJAVE", schema = "dbo", catalog = "ck_db")
public class TPrijaveEntity {
    private int prijavaId;
    private short korisnikId;
    private byte racunarId;
    private Timestamp vrijemePrijave;

    @Id
    @Column(name = "PRIJAVA_ID")
    public int getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(int prijavaId) {
        this.prijavaId = prijavaId;
    }

    @Basic
    @Column(name = "KORISNIK_ID")
    public short getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(short korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Basic
    @Column(name = "RACUNAR_ID")
    public byte getRacunarId() {
        return racunarId;
    }

    public void setRacunarId(byte racunarId) {
        this.racunarId = racunarId;
    }

    @Basic
    @Column(name = "VRIJEME_PRIJAVE")
    public Timestamp getVrijemePrijave() {
        return vrijemePrijave;
    }

    public void setVrijemePrijave(Timestamp vrijemePrijave) {
        this.vrijemePrijave = vrijemePrijave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPrijaveEntity that = (TPrijaveEntity) o;

        if (prijavaId != that.prijavaId) return false;
        if (korisnikId != that.korisnikId) return false;
        if (racunarId != that.racunarId) return false;
        if (vrijemePrijave != null ? !vrijemePrijave.equals(that.vrijemePrijave) : that.vrijemePrijave != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prijavaId;
        result = 31 * result + (int) korisnikId;
        result = 31 * result + (int) racunarId;
        result = 31 * result + (vrijemePrijave != null ? vrijemePrijave.hashCode() : 0);
        return result;
    }
}
