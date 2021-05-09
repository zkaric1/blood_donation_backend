package ba.red_cross.blood_donation;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "T_ORGANIZACIJA", schema = "dbo", catalog = "ck_db")
public class TOrganizacijaEntity {
    private String organizacija;
    private String naziv;
    private String nadredjena;
    private String idBroj;
    private String poreskiBroj;
    private String adresa;
    private String banka;
    private String brojRacuna;
    private String telefon;
    private String fax;
    private String email;
    private String web;
    private byte[] logo;
    private boolean vazi;

    @Id
    @Column(name = "ORGANIZACIJA")
    public String getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(String organizacija) {
        this.organizacija = organizacija;
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
    @Column(name = "NADREDJENA")
    public String getNadredjena() {
        return nadredjena;
    }

    public void setNadredjena(String nadredjena) {
        this.nadredjena = nadredjena;
    }

    @Basic
    @Column(name = "ID_BROJ")
    public String getIdBroj() {
        return idBroj;
    }

    public void setIdBroj(String idBroj) {
        this.idBroj = idBroj;
    }

    @Basic
    @Column(name = "PORESKI_BROJ")
    public String getPoreskiBroj() {
        return poreskiBroj;
    }

    public void setPoreskiBroj(String poreskiBroj) {
        this.poreskiBroj = poreskiBroj;
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
    @Column(name = "BANKA")
    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
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
    @Column(name = "TELEFON")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Basic
    @Column(name = "FAX")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
    @Column(name = "WEB")
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Basic
    @Column(name = "LOGO")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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

        TOrganizacijaEntity that = (TOrganizacijaEntity) o;

        if (vazi != that.vazi) return false;
        if (organizacija != null ? !organizacija.equals(that.organizacija) : that.organizacija != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;
        if (nadredjena != null ? !nadredjena.equals(that.nadredjena) : that.nadredjena != null) return false;
        if (idBroj != null ? !idBroj.equals(that.idBroj) : that.idBroj != null) return false;
        if (poreskiBroj != null ? !poreskiBroj.equals(that.poreskiBroj) : that.poreskiBroj != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (banka != null ? !banka.equals(that.banka) : that.banka != null) return false;
        if (brojRacuna != null ? !brojRacuna.equals(that.brojRacuna) : that.brojRacuna != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (!Arrays.equals(logo, that.logo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizacija != null ? organizacija.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (nadredjena != null ? nadredjena.hashCode() : 0);
        result = 31 * result + (idBroj != null ? idBroj.hashCode() : 0);
        result = 31 * result + (poreskiBroj != null ? poreskiBroj.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (banka != null ? banka.hashCode() : 0);
        result = 31 * result + (brojRacuna != null ? brojRacuna.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(logo);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
