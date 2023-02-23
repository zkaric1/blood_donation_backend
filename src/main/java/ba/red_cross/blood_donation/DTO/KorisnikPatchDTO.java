package ba.red_cross.blood_donation.DTO;

public class KorisnikPatchDTO {

    private String mjestoPrebivalista;
    private String adresaPrebivalista;
    private String kantonPrebivalista;
    private String kontaktTelefon;
    private String zanimanje;
    private String emailAdresa;
    private String korisnickoIme;

    public KorisnikPatchDTO() {}
    public KorisnikPatchDTO(String mjestoPrebivalista,
                            String adresaPrebivalista,
                            String kantonPrebivalista,
                            String kontaktTelefon,
                            String zanimanje,
                            String emailAdresa,
                            String korisnickoIme) {
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.adresaPrebivalista = adresaPrebivalista;
        this.kantonPrebivalista = kantonPrebivalista;
        this.kontaktTelefon = kontaktTelefon;
        this.zanimanje = zanimanje;
        this.emailAdresa = emailAdresa;
        this.korisnickoIme = korisnickoIme;
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

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}
