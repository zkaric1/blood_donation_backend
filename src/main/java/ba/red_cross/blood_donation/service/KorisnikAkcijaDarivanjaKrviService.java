package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.repository.KorisnikAkcijaDarivanjaKrviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class KorisnikAkcijaDarivanjaKrviService {

    @Autowired
    KorisnikAkcijaDarivanjaKrviRepository korisnikAkcijaDarivanjaKrviRepository;

    public List<KorisnikAkcijaDarivanjaKrvi> getAll() throws Exception{
        if (korisnikAkcijaDarivanjaKrviRepository.count() == 0) throw new Exception("Nema akcija za korisnike!");
        return korisnikAkcijaDarivanjaKrviRepository.findAll();
    }

    public KorisnikAkcijaDarivanjaKrvi findById(Long id) throws Exception{
        if (korisnikAkcijaDarivanjaKrviRepository.count() == 0) throw new Exception("Nema akcija za korisnike!");
        return korisnikAkcijaDarivanjaKrviRepository.findById(id).orElseThrow(() -> new Exception("Korisnik akcija darivanja krvi sa ID " + id + " ne postoji!"));
    }

    public List<KorisnikAkcijaDarivanjaKrvi> findAkcijeZaKorisnikaById (Long id) throws Exception {
        if (korisnikAkcijaDarivanjaKrviRepository.count() == 0) throw new Exception("Nema akcija za korisnike!");
        return korisnikAkcijaDarivanjaKrviRepository.findAllByKorisnikId(id);
    }

    public List<KorisnikAkcijaDarivanjaKrvi> findByAkcijaId (Long id) throws Exception {
        if (korisnikAkcijaDarivanjaKrviRepository.count() == 0) throw new Exception("Nema akcija za korisnike!");
        return korisnikAkcijaDarivanjaKrviRepository.findAllByKorisnikAkcijaId(id);
    }

    public KorisnikAkcijaDarivanjaKrvi createNew (KorisnikAkcijaDarivanjaKrvi akcijaDarivanjaKrvi) {
        return korisnikAkcijaDarivanjaKrviRepository.save(akcijaDarivanjaKrvi);
    }
}
