package ba.red_cross.blood_donation.DTO;


import ba.red_cross.blood_donation.model.Rola;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class RegisterRequest {

    @NotBlank(message = "Ime korisnika ne može biti prazno!")
    private String ime;

    @NotBlank(message = "Korisničke ime ne može biti prazno!")
    private String korisnickoIme;

    @NotBlank(message = "Prezime korisnika ne može biti prazno!")
    private String prezime;

    @NotBlank(message = "Spol korisnika ne može biti prazno!")
    private String spol;

    private LocalDate datumRodenja;

    @NotBlank(message = "Mjesto rođenja korisnika ne može biti prazno!")
    private String mjestoRodenja;

    @NotBlank(message = "Mjesto prebivališta korisnika ne može biti prazno!")
    private String mjestoPrebivalista;

    @NotBlank(message = "Adresa prebivališta korisnika ne može biti prazno!")
    private String adresaPrebivalista;

    @NotBlank(message = "Kanton prebivališta korisnika ne može biti prazno!")
    private String kantonPrebivalista;

    @NotBlank(message = "Kontakt telefon korisnika ne može biti prazno!")
    private String kontaktTelefon;

    private String zanimanje;
    private String krvnaGrupa;
    private int brojDarivanjaKrvi;

    @NotBlank(message = "Email adresa ne može biti prazno!")
    private String emailAdresa;

    @NotBlank(message = "Lozinka ne može biti prazno!")
    private String lozinka;

    public RegisterRequest() {
    }

    public RegisterRequest(String ime, String prezime, String korisnickoIme, String spol, LocalDate datumRodenja, String mjestoRodenja, String mjestoPrebivalista, String adresaPrebivalista, String kantonPrebivalista, String kontaktTelefon, String zanimanje, String krvnaGrupa, int brojDarivanjaKrvi, String emailAdresa, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.spol = spol;
        this.datumRodenja = datumRodenja;
        this.mjestoRodenja = mjestoRodenja;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.adresaPrebivalista = adresaPrebivalista;
        this.kantonPrebivalista = kantonPrebivalista;
        this.kontaktTelefon = kontaktTelefon;
        this.zanimanje = zanimanje;
        this.krvnaGrupa = krvnaGrupa;
        this.brojDarivanjaKrvi = brojDarivanjaKrvi;
        this.emailAdresa = emailAdresa;
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public LocalDate getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(LocalDate datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getMjestoRodenja() {
        return mjestoRodenja;
    }

    public void setMjestoRodenja(String mjestoRodenja) {
        this.mjestoRodenja = mjestoRodenja;
    }

    public String getMjestoPrebivalista() {
        return mjestoPrebivalista;
    }

    public void setMjestoPrebivalista(String mjestoPrebivalista) {
        this.mjestoPrebivalista = mjestoPrebivalista;
    }

    public String getAdresaPrebivalista() {
        return adresaPrebivalista;
    }

    public void setAdresaPrebivalista(String adresaPrebivalista) {
        this.adresaPrebivalista = adresaPrebivalista;
    }

    public String getKantonPrebivalista() {
        return kantonPrebivalista;
    }

    public void setKantonPrebivalista(String kantonPrebivalista) {
        this.kantonPrebivalista = kantonPrebivalista;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public int getBrojDarivanjaKrvi() {
        return brojDarivanjaKrvi;
    }

    public void setBrojDarivanjaKrvi(int brojDarivanjaKrvi) {
        this.brojDarivanjaKrvi = brojDarivanjaKrvi;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}
