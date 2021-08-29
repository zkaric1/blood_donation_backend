package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.KorisnikAkcijaDarivanjaKrviDTO;
import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.repository.AkcijeDarivanjaKrviRepository;
import ba.red_cross.blood_donation.repository.KorisnikAkcijaDarivanjaKrviRepository;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class KorisnikAkcijaDarivanjaKrviService {

    @Autowired
    KorisnikAkcijaDarivanjaKrviRepository korisnikAkcijaDarivanjaKrviRepository;
    @Autowired
    KorisnikService korisnikService;
    @Autowired
    AkcijeDarivanjaKrviService akcijeDarivanjaKrviService;

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

    public KorisnikAkcijaDarivanjaKrvi createNew (KorisnikAkcijaDarivanjaKrviDTO akcijaDarivanja) throws Exception {
        Korisnik korisnik = korisnikService.getKorisnikById(akcijaDarivanja.getKorisnikID());
        AkcijaDarivanjaKrvi akcijaDarivanjaKrvi = akcijeDarivanjaKrviService.getAkcijeDarivanjaKrviById(akcijaDarivanja.getAkcijaID());
        KorisnikAkcijaDarivanjaKrvi novaAkcija = new KorisnikAkcijaDarivanjaKrvi(korisnik, akcijaDarivanjaKrvi, "DA");
        return korisnikAkcijaDarivanjaKrviRepository.save(novaAkcija);
    }

    public List<AkcijaDarivanjaKrvi> findAkcijeByKorisnikId (Long id) {
        List<AkcijaDarivanjaKrvi> akcije = new ArrayList<>();
        List<Long> idAkcija = korisnikAkcijaDarivanjaKrviRepository.findAkcijeByKorisnikID(id);

        for (int i = 0; i<idAkcija.size(); i++) {
            akcije.add(akcijeDarivanjaKrviService.getAkcijeDarivanjaKrviById(idAkcija.get(i)));
        }

        return  akcije;
    }

    public Integer getBrojDarivanjaZaAkciju (Long id) throws Exception {
        Integer brojDarivanja = korisnikAkcijaDarivanjaKrviRepository.getBrojDarivanjaZaAkciju(id);
        return brojDarivanja;
    }
}
