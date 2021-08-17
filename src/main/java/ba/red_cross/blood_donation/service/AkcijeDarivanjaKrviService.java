package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.repository.AkcijeDarivanjaKrviRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class AkcijeDarivanjaKrviService {

    @Autowired
    private AkcijeDarivanjaKrviRepository akcijeDarivanjaKrviRepository;

    public AkcijeDarivanjaKrviService (AkcijeDarivanjaKrviRepository akcijeDarivanjaKrviRepository) {
        this.akcijeDarivanjaKrviRepository = akcijeDarivanjaKrviRepository;
    }

    // Metoda za vraćanje mjeseca održavanja akcije
    private Integer getMjesecAkcije (Long id)  {
        AkcijaDarivanjaKrvi akcija = akcijeDarivanjaKrviRepository.findById(id).orElseThrow(() -> new AkcijeDarivanjaKrviException("Akcija darivanja krvi sa ID " + id + " ne postoji!"));
        return akcija.getDatum().getMonth().getValue();
    }

    public List<AkcijaDarivanjaKrvi> getAkcijeDarivanjaKrvi () throws  Exception{
        if (akcijeDarivanjaKrviRepository.count() == 0) {
            throw new Exception("Nema kreiranih akcija darivanja krvi!");
        }
        return akcijeDarivanjaKrviRepository.findAll();
    }

    public AkcijaDarivanjaKrvi getAkcijeDarivanjaKrviById (Long id) throws AkcijeDarivanjaKrviException {
        System.out.print(getMjesecAkcije(id));
        return akcijeDarivanjaKrviRepository.findById(id).orElseThrow(() -> new AkcijeDarivanjaKrviException("Akcija darivanja krvi sa ID " + id + " ne postoji!"));
    }

    public List<AkcijaDarivanjaKrvi> getAkcijeDarivanjaKrviByGrad (String grad) throws AkcijeDarivanjaKrviException {
        List<AkcijaDarivanjaKrvi> listaAkcijaDarivanja = akcijeDarivanjaKrviRepository.findAllByGrad(grad);
        System.out.print(listaAkcijaDarivanja.size());
        if (listaAkcijaDarivanja.size() == 0) {
            throw new AkcijeDarivanjaKrviException("Akcije darivanja krvi za grad " + grad + " ne postoje!");
        }

        return listaAkcijaDarivanja;
    }

    public HashMap<String,String> deleteAll () throws Exception {
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih akcija darivanja krvi!").getHashMap();
        akcijeDarivanjaKrviRepository.deleteAll();
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Uspjesno obrisane sve akcije darivanja krvi!").getHashMap();
        return new ResponseMessageDTO("Greska pri brisanju akcija darivanja krvi!").getHashMap();
    }

    public HashMap<String,String> deleteById (Long id) throws Exception {
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih akcija darivanja krvi!").getHashMap();
        boolean exists = akcijeDarivanjaKrviRepository.existsById(id);
        if (exists) {
            akcijeDarivanjaKrviRepository.deleteById(id);
            return new ResponseMessageDTO("Uspjesno obrisana akcija darivanja krvi sa id " + id).getHashMap();
        }
        return new ResponseMessageDTO("Ne postoji akcija darivanja krvi sa id " + id).getHashMap();
    }

    public AkcijaDarivanjaKrvi addAkcijaDarivanja (AkcijaDarivanjaKrvi akcijaDarivanjaKrvi) {
        return akcijeDarivanjaKrviRepository.save(akcijaDarivanjaKrvi);
    }

    public AkcijaDarivanjaKrvi editAkcija (AkcijaDarivanjaKrvi novaAkcijaDarivanja,Long id) throws AkcijeDarivanjaKrviException {
        akcijeDarivanjaKrviRepository.findById(id).orElseThrow(() -> new AkcijeDarivanjaKrviException("Akcija darivanja krvi sa ID " + novaAkcijaDarivanja.getID() + " ne postoji!"));
        akcijeDarivanjaKrviRepository.findById(novaAkcijaDarivanja.getID()).map(
                akcijaDarivanjaKrvi -> {
                    akcijaDarivanjaKrvi.setGrad(novaAkcijaDarivanja.getGrad());
                    akcijaDarivanjaKrvi.setAdresa(novaAkcijaDarivanja.getAdresa());
                    akcijaDarivanjaKrvi.setDatum(novaAkcijaDarivanja.getDatum());
                    akcijaDarivanjaKrvi.setKraj(novaAkcijaDarivanja.getKraj());
                    akcijaDarivanjaKrvi.setPocetak(novaAkcijaDarivanja.getPocetak());
                    return akcijeDarivanjaKrviRepository.save(akcijaDarivanjaKrvi);
                }
        );

        return akcijeDarivanjaKrviRepository.findById(novaAkcijaDarivanja.getID()).get();
    }

    public List<Integer> getBrojDarivanjaPoMjesecu () {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        List<Map<Integer,Integer>> brojDarivanjaPoMjesecu = akcijeDarivanjaKrviRepository.getBrojDarivanjaPoMjesecu(year);
        List<Map<Integer, Integer>> lista = new ArrayList<>();
        List<Integer> brojDarivanja = new ArrayList<>();
        for (int i = 0; i<12; i++) brojDarivanja.add(0);
        for (Map<Integer, Integer> a : brojDarivanjaPoMjesecu) {
            brojDarivanja.set(a.get("mjesec"), a.get("broj_darivanja"));
        }

        return brojDarivanja;
    }

    public AkcijaDarivanjaKrvi partialUpdateAkcija (AkcijaDarivanjaKrvi novaAkcija, Long id) throws Exception {
        AkcijaDarivanjaKrvi akcija = akcijeDarivanjaKrviRepository.findById(id).orElseThrow(() -> new Exception("Akcija darivanja krvi sa ID " + id + " ne postoji!"));
        if (novaAkcija.getNaslov() != "")  akcija.setNaslov(novaAkcija.getNaslov());
        if (novaAkcija.getAdresa() != "") akcija.setAdresa(novaAkcija.getAdresa());
        if (novaAkcija.getGrad() != "") akcija.setGrad(novaAkcija.getGrad());
        if (novaAkcija.getDatum() != null) akcija.setDatum(novaAkcija.getDatum());
        if (novaAkcija.getPocetak() != null) akcija.setPocetak(novaAkcija.getPocetak());
        if (novaAkcija.getKraj() != null) akcija.setKraj(novaAkcija.getKraj());
        akcijeDarivanjaKrviRepository.save(akcija);
        return akcija;
    }

    public List<AkcijaDarivanjaKrvi> zavrseneAkcije () throws Exception {
        LocalDate datumSada = LocalDate.now();
        LocalTime vrijemeSada = LocalTime.now();
        if (akcijeDarivanjaKrviRepository.count() == 0) throw new Exception("Nema akcija darivanja krvi u bazi!");
        List<AkcijaDarivanjaKrvi> akcijeTemp = akcijeDarivanjaKrviRepository.findAll();
        List<AkcijaDarivanjaKrvi> akcije = new ArrayList<>();

        for (int i = 0; i<akcijeTemp.size(); i++) {
            if (akcijeTemp.get(i).getDatum().isBefore(datumSada)) {
                akcije.add(akcijeTemp.get(i));
            }
        }

        return akcije;
    }
}
