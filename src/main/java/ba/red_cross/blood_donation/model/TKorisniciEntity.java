package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_KORISNICI", schema = "dbo", catalog = "ck_db")
public class TKorisniciEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int korisnikId;
    private int kontaktId;
    private String korisnickoIme;
    private String sifra;
    private String tipKorisnika;
    private boolean vazi;

    @Id
    @Column(name = "KORISNIK_ID")
    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Basic
    @Column(name = "KONTAKT_ID")
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Basic
    @Column(name = "KORISNICKO_IME")
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Basic
    @Column(name = "SIFRA")
    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Basic
    @Column(name = "TIP_KORISNIKA")
    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
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

        TKorisniciEntity that = (TKorisniciEntity) o;

        if (korisnikId != that.korisnikId) return false;
        if (kontaktId != that.kontaktId) return false;
        if (vazi != that.vazi) return false;
        if (!Objects.equals(korisnickoIme, that.korisnickoIme))
            return false;
        if (!Objects.equals(sifra, that.sifra)) return false;
        if (!Objects.equals(tipKorisnika, that.tipKorisnika)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) korisnikId;
        result = 31 * result + kontaktId;
        result = 31 * result + (korisnickoIme != null ? korisnickoIme.hashCode() : 0);
        result = 31 * result + (sifra != null ? sifra.hashCode() : 0);
        result = 31 * result + (tipKorisnika != null ? tipKorisnika.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
