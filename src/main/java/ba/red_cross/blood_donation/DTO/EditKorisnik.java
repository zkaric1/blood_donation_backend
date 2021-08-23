package ba.red_cross.blood_donation.DTO;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class EditKorisnik {

    @NotBlank(message = "Ime korisnika ne može biti prazno!")
    private String ime;

    @NotBlank(message = "Prezime korisnika ne može biti prazno!")
    private String prezime;

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

    public EditKorisnik(@NotBlank(message = "Ime korisnika ne može biti prazno!") String ime, @NotBlank(message = "Prezime korisnika ne može biti prazno!") String prezime, LocalDate datumRodenja, @NotBlank(message = "Mjesto rođenja korisnika ne može biti prazno!") String mjestoRodenja, @NotBlank(message = "Mjesto prebivališta korisnika ne može biti prazno!") String mjestoPrebivalista, @NotBlank(message = "Adresa prebivališta korisnika ne može biti prazno!") String adresaPrebivalista, @NotBlank(message = "Kanton prebivališta korisnika ne može biti prazno!") String kantonPrebivalista, @NotBlank(message = "Kontakt telefon korisnika ne može biti prazno!") String kontaktTelefon, String zanimanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenja = datumRodenja;
        this.mjestoRodenja = mjestoRodenja;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.adresaPrebivalista = adresaPrebivalista;
        this.kantonPrebivalista = kantonPrebivalista;
        this.kontaktTelefon = kontaktTelefon;
        this.zanimanje = zanimanje;
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
}
