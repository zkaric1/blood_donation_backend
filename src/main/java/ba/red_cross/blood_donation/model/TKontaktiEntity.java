package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "T_KONTAKTI", schema = "dbo", catalog = "ck_db")
public class TKontaktiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int kontaktId;
    private String organizacija;
    private String prezime;
    private String ime;
    private String adresa;
    private String postanskiBroj;
    private String telefon;
    private String mobitel;
    private String email;
    private String facebook;
    private String skype;
    private String twiter;
    private byte[] slika;
    private String datumRodjenja;
    private String obrazovanje;
    private String zanimanje;
    private String poslodavac;
    private String brojRacuna;
    private String banka;
    private String krvnaGrupa;
    private Boolean pol;
    private String napomena;
    private boolean vazi;

    @Id
    @Column(name = "KONTAKT_ID")
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Basic
    @Column(name = "ORGANIZACIJA")
    public String getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(String organizacija) {
        this.organizacija = organizacija;
    }

    @Basic
    @Column(name = "PREZIME")
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "IME")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "ADRESA")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "POSTANSKI_BROJ")
    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    @Basic
    @Column(name = "TELEFON")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Basic
    @Column(name = "MOBITEL")
    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "FACEBOOK")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Basic
    @Column(name = "SKYPE")
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Basic
    @Column(name = "TWITER")
    public String getTwiter() {
        return twiter;
    }

    public void setTwiter(String twiter) {
        this.twiter = twiter;
    }

    @Basic
    @Column(name = "SLIKA")
    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    @Basic
    @Column(name = "DATUM_RODJENJA")
    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Basic
    @Column(name = "OBRAZOVANJE")
    public String getObrazovanje() {
        return obrazovanje;
    }

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
    }

    @Basic
    @Column(name = "ZANIMANJE")
    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    @Basic
    @Column(name = "POSLODAVAC")
    public String getPoslodavac() {
        return poslodavac;
    }

    public void setPoslodavac(String poslodavac) {
        this.poslodavac = poslodavac;
    }

    @Basic
    @Column(name = "BROJ_RACUNA")
    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    @Basic
    @Column(name = "BANKA")
    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }

    @Basic
    @Column(name = "KRVNA_GRUPA")
    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    @Basic
    @Column(name = "POL")
    public Boolean getPol() {
        return pol;
    }

    public void setPol(Boolean pol) {
        this.pol = pol;
    }

    @Basic
    @Column(name = "NAPOMENA")
    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
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

        TKontaktiEntity that = (TKontaktiEntity) o;

        if (kontaktId != that.kontaktId) return false;
        if (vazi != that.vazi) return false;
        if (organizacija != null ? !organizacija.equals(that.organizacija) : that.organizacija != null) return false;
        if (prezime != null ? !prezime.equals(that.prezime) : that.prezime != null) return false;
        if (ime != null ? !ime.equals(that.ime) : that.ime != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (postanskiBroj != null ? !postanskiBroj.equals(that.postanskiBroj) : that.postanskiBroj != null)
            return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;
        if (mobitel != null ? !mobitel.equals(that.mobitel) : that.mobitel != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (facebook != null ? !facebook.equals(that.facebook) : that.facebook != null) return false;
        if (skype != null ? !skype.equals(that.skype) : that.skype != null) return false;
        if (twiter != null ? !twiter.equals(that.twiter) : that.twiter != null) return false;
        if (!Arrays.equals(slika, that.slika)) return false;
        if (datumRodjenja != null ? !datumRodjenja.equals(that.datumRodjenja) : that.datumRodjenja != null)
            return false;
        if (obrazovanje != null ? !obrazovanje.equals(that.obrazovanje) : that.obrazovanje != null) return false;
        if (zanimanje != null ? !zanimanje.equals(that.zanimanje) : that.zanimanje != null) return false;
        if (poslodavac != null ? !poslodavac.equals(that.poslodavac) : that.poslodavac != null) return false;
        if (brojRacuna != null ? !brojRacuna.equals(that.brojRacuna) : that.brojRacuna != null) return false;
        if (banka != null ? !banka.equals(that.banka) : that.banka != null) return false;
        if (krvnaGrupa != null ? !krvnaGrupa.equals(that.krvnaGrupa) : that.krvnaGrupa != null) return false;
        if (pol != null ? !pol.equals(that.pol) : that.pol != null) return false;
        if (napomena != null ? !napomena.equals(that.napomena) : that.napomena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId;
        result = 31 * result + (organizacija != null ? organizacija.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (postanskiBroj != null ? postanskiBroj.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (mobitel != null ? mobitel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (twiter != null ? twiter.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(slika);
        result = 31 * result + (datumRodjenja != null ? datumRodjenja.hashCode() : 0);
        result = 31 * result + (obrazovanje != null ? obrazovanje.hashCode() : 0);
        result = 31 * result + (zanimanje != null ? zanimanje.hashCode() : 0);
        result = 31 * result + (poslodavac != null ? poslodavac.hashCode() : 0);
        result = 31 * result + (brojRacuna != null ? brojRacuna.hashCode() : 0);
        result = 31 * result + (banka != null ? banka.hashCode() : 0);
        result = 31 * result + (krvnaGrupa != null ? krvnaGrupa.hashCode() : 0);
        result = 31 * result + (pol != null ? pol.hashCode() : 0);
        result = 31 * result + (napomena != null ? napomena.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
