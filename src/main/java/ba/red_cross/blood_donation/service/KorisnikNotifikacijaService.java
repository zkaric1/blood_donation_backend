package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.Notifikacija;
import ba.red_cross.blood_donation.repository.KorisnikNotifikacijaRepository;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import ba.red_cross.blood_donation.repository.NotifikacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KorisnikNotifikacijaService {

    @Autowired
    KorisnikNotifikacijaRepository korisnikNotifikacijaRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    NotifikacijaRepository notifikacijaRepository;

    public void obrisiNotifikacijeZaKorisnika(Long korisnikId) throws Exception {
        Korisnik korisnik = korisnikRepository.findByID(korisnikId);
        if(korisnik == null) {
            throw new Exception("Korisnik ne postoji");
        }
        korisnikNotifikacijaRepository.deleteKorisnikNotifikacijaByKorisnik_ID(korisnikId);
    }

    public void obrisiNotifikacijuZaKorisnika(Long korisnikId, Long notifikacijaId) throws Exception {
        boolean korisnikPostoji = korisnikRepository.existsById(korisnikId);
        if(!korisnikPostoji) {
            throw new Exception("Korisnik ne postoji");
        }
        boolean notifikacijaPostoji = notifikacijaRepository.existsById(notifikacijaId);
        if(!notifikacijaPostoji) {
            throw new Exception("Notifikacija ne postoji");
        }
        korisnikNotifikacijaRepository.deleteKorisnikNotifikacijaByKorisnik_IDAndNotifikacija_ID(korisnikId,notifikacijaId);
    }
}
