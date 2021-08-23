package ba.red_cross.blood_donation.DTO;

public class KorisnikAkcijaDarivanjaKrviDTO {
    private Long korisnikID;
    private Long akcijaID;

    public KorisnikAkcijaDarivanjaKrviDTO () {}

    public KorisnikAkcijaDarivanjaKrviDTO(Long korisnikID, Long akcijaID) {
        this.korisnikID = korisnikID;
        this.akcijaID = akcijaID;
    }

    public Long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public Long getAkcijaID() {
        return akcijaID;
    }

    public void setAkcijaID(Long akcijaID) {
        this.akcijaID = akcijaID;
    }
}
