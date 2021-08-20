package ba.red_cross.blood_donation.DTO;

import ba.red_cross.blood_donation.model.Korisnik;


public class DTOKorisnici {

    private Korisnik korisnik;
    public DTOKorisnici(){}
    public DTOKorisnici(Korisnik korisnik) {
      //  this.kontakt = kontakt;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
