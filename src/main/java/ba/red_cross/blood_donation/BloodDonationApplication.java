package ba.red_cross.blood_donation;

import ba.red_cross.blood_donation.model.*;
import ba.red_cross.blood_donation.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@SpringBootApplication
public class BloodDonationApplication {

    private static final Logger log =
            LoggerFactory.getLogger(BloodDonationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

    @Bean
    public CommandLineRunner addDataToDatabase(KorisnikRepository korisnikRepository, TransfuzijskiCentarRepository transCentarRepo, RolaRepository rolaRepo, AkcijeDarivanjaKrviRepository akcijaDarivanjaRepo, NotifikacijaRepository notifikacijaRepo, TransfuzijskiCentarRepository transfuzijskiCentarRepository) {
        return (args) -> {
          /*  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Rola admin = rolaRepo.save(new Rola("administrator"));
            Rola korisnik = rolaRepo.save(new Rola("korisnik"));
            LocalDate datumKreiranjaRacuna = LocalDate.now();
            LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user = new Korisnik("Alma", "Ibrašimović", "alma_96", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, admin);
          //  user.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1958, 6, 25);
            Korisnik user1 = (new Korisnik("Jasmina", "Ibrašimović", "jasmina_58", "Z", datumRodenja, "Bosanski Petrovac","Novi Travnik", "Stjepana Radića 18/15", "SBK", "063836791", "Profesor", "A+", 5, "jasmina@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
           // user1.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user1);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user2 = (new Korisnik("Belma", "Ibrašimović", "belma_93", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
           // user2.getAkcijeDarivanja().add(akcijaDarivanja1);
            korisnikRepository.save(user2);

            datumKreiranjaRacuna = LocalDate.of(2021, 12, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user3 = (new Korisnik("Šefik", "Ibrašimović", "sefik", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
         //   user3.getAkcijeDarivanja().add(akcijaDarivanja2);
            korisnikRepository.save(user3);
         /*   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // Kreiranje rola
            Rola admin = rolaRepo.save(new Rola("administrator"));
            Rola korisnik = rolaRepo.save(new Rola("korisnik"));

            // Kreiranje akcija darivanja krvi
            AkcijaDarivanjaKrvi akcijaDarivanja = new AkcijaDarivanjaKrvi("Paromlinska 3", "Sarajevo", LocalDate.of(2021, 9, 23), LocalTime.of(9, 0, 0), LocalTime.of(11, 30, 0), "Akcija darivanja krvi u Sarajevu");
            akcijaDarivanjaRepo.save(akcijaDarivanja);
            AkcijaDarivanjaKrvi akcijaDarivanja1 = new AkcijaDarivanjaKrvi("Hujići 4", "Zenica", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Akcija darivanja krvi u Zenici");
            akcijaDarivanjaRepo.save(akcijaDarivanja1);
            AkcijaDarivanjaKrvi akcijaDarivanja2 = new AkcijaDarivanjaKrvi("Stjepana Radića 18/15", "Novi Travnik", LocalDate.of(2021, 7, 23), LocalTime.of(15, 0, 0), LocalTime.of(17, 30, 0), "Akcija darivanja krvi u Novom Travniku");
            akcijaDarivanjaRepo.save(akcijaDarivanja2);
            AkcijaDarivanjaKrvi akcijaDarivanja3 = new AkcijaDarivanjaKrvi("Nerkeza Smailagića 15", "Bihać", LocalDate.of(2021, 8, 10), LocalTime.of(10, 0, 0), LocalTime.of(15, 0, 0), "Akcija darivanja krvi u Bihaću");
            akcijaDarivanjaRepo.save(akcijaDarivanja3);
            AkcijaDarivanjaKrvi akcijaDarivanja4 = new AkcijaDarivanjaKrvi("Titova", "Banja Luka", LocalDate.of(2021, 8, 17), LocalTime.of(16, 0, 0), LocalTime.of(20, 0, 0), "Akcija darivanja krvi u Banja Luci");
            akcijaDarivanjaRepo.save(akcijaDarivanja4);
            // Kreiranje korisnika
            LocalDate datumKreiranjaRacuna = LocalDate.now();
            LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user = new Korisnik("Alma", "Ibrašimović", "alma_96", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, admin);
            user.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1958, 6, 25);
            Korisnik user1 = (new Korisnik("Jasmina", "Ibrašimović", "jasmina_58", "Z", datumRodenja, "Bosanski Petrovac","Novi Travnik", "Stjepana Radića 18/15", "SBK", "063836791", "Profesor", "A+", 5, "jasmina@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user1.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user1);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user2 = (new Korisnik("Belma", "Ibrašimović", "belma_93", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user2.getAkcijeDarivanja().add(akcijaDarivanja1);
            korisnikRepository.save(user2);

            datumKreiranjaRacuna = LocalDate.of(2021, 12, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user3 = (new Korisnik("Šefik", "Ibrašimović", "sefik", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user3.getAkcijeDarivanja().add(akcijaDarivanja2);
            korisnikRepository.save(user3);

            // Kreiranje transfuzijskih centara
            transCentarRepo.save (new TransfuzijskiCentar("Novi Travnik", "Stjepana Radića 18/15", "061718733"));

            // Kreiranje notifikacija
            notifikacijaRepo.save (new Notifikacija("Hitno potrebna krvna grupa 0+", "Hitno potrebna krvna grupa 0+", "HITNO", "0+"));

            log.info("Podaci uspjesno upisani u db!");*/
            int numberOfCenters = transfuzijskiCentarRepository.findAll().size();
            log.info("Ukupan broj transfuzioloskih centara u bazi " + numberOfCenters);
            if(numberOfCenters == 0) {
                addCenters(transfuzijskiCentarRepository);
            }
        };

    }

    private void addCenters(TransfuzijskiCentarRepository transfuzijskiCentarRepository) {
        List<TransfuzijskiCentar> transfuzijskiCentri = new ArrayList<>(
                Arrays.asList(
                        new TransfuzijskiCentar("Kralja Tvrtka bb", "Mostar", "+387 (0)36 336-500", "Sveučilišna klinička bolnica"),
                        new TransfuzijskiCentar("Maršala Tita 294", "Mostar", "+387 (0)36 503 160", "KB \"Dr Safet Mujić\""),
                        new TransfuzijskiCentar("Trnovac bb", "Tuzla", "00387 35 303 300", "Univerzitetski klinički centar "),
                        new TransfuzijskiCentar("Crkvice 67", "Zenica", "+387 (0)32 209 852", "JU Kantonalna bolnica "),
                        new TransfuzijskiCentar("Kranjčevićeva 12", "Sarajevo", " 00387 33 285-186", "JU Opća bolnica \"Prim. dr. Abdulah Nakaš\""),
                        new TransfuzijskiCentar("Ul. Darivalaca krvi 67", "Bihać", "037 / 318 - 800", "Kantonalna bolnica \"Dr. Irfan Ljubijankić\""),
                        new TransfuzijskiCentar("Crkvice 67", "Zenica", "+ 387 32 405-133", "JU Kantonalna bolnica"),
                        new TransfuzijskiCentar("Zdravstvenih radnika 6", "Goražde", "00387 38 241 210", "JZU Kantonalna bolnica"),
                        new TransfuzijskiCentar("Treća ulica bb", "Orašje", "+387 31 712 703", "Županijska bolnica "),
                        new TransfuzijskiCentar("Kalibunar bb", "Travnik", "+387 30 519 100", "JU bolnica"),
                        new TransfuzijskiCentar("Sv. Ive 2", "Livno", "+387-34-200-423", "Županijska bolnica \"Dr. fra Mihovil Sučić\""),
                        new TransfuzijskiCentar("Dubrave bb Nova Bila", "Travnik", "+387 30 70 85 00", "Hrvatska bolnica \"Dr. fra Mato Nikolić\""),
                        new TransfuzijskiCentar("Ulica Braće Pobrića 17", "Tešanj", " 00387 32 650-187", "JU Opća bolnica "),
                        new TransfuzijskiCentar("M. Ahmedbegovića 50", "Gračanica", "+387 35 702032", "JZU Opća bolnica \"Dr Mustafa Beganović\""),
                        new TransfuzijskiCentar("Ambasadora Wagnerova 15", "Bugojno", "+387 30 252090", "JU Opća bolnica"),
                        new TransfuzijskiCentar("Kraljice Jelene bb", "Jajce", " +387 30 658106", "JU Opća bolnica"),
                        new TransfuzijskiCentar("Bolnička bb", "Konjic", "+387 36 726292", "JU Opća bolnica"),
                        new TransfuzijskiCentar("Prijedorska 111", "Sanski Most", "037689268", "JZU Opća bolnica"),
                        new TransfuzijskiCentar("Valtera Perića br. 10", "Sarajevo", " + 387 33 220 168", "CK Općine Centar"),
                        new TransfuzijskiCentar("6. mart 14a", "Hadžići", "+ 387 61 188 596", "CK Općine Hadžići"),
                        new TransfuzijskiCentar("Jahijela Fincija br. 14", "Ilidža", " + 387 33 638 022", "CK Općine Ilidža"),
                        new TransfuzijskiCentar("126. ilijaške brigade br. 62", "Sarajevo", "+ 387 33 400 518", "CK Općine Ilijaš"),
                        new TransfuzijskiCentar("Trg solidarnosti br. 23", "Sarajevo", "+ 387 33 451 895", "CK Općine Novi Grad"),
                        new TransfuzijskiCentar("Envera Šehovića br. 11", "Sarajevo", "+387 33 610 807", "CK Općine Novo Sarajevo"),
                        new TransfuzijskiCentar("Edhema Mulabdića br. 2", "Sarajevo", "+ 387 33 532 137", "CK Općine Stari Grad"),
                        new TransfuzijskiCentar("Trnovo bb", "Delijaš - Trnovo", " + 387 33 439 045", "CK Općine Trnovo"),
                        new TransfuzijskiCentar("Igmanska br. 50", "Vogošća", "+ 387 33 430 209", "CK Općine Vogošća"),
                        new TransfuzijskiCentar("Dubrave bb", "Nova Bila", "030 708-500", "Hrvatska bolnica Dr. Fra Mato Nikolić"),
                        new TransfuzijskiCentar("Branislava Đurđeva bb", "Bihać", "037 226 087", "CK Unsko-Sanskog kantona"),
                        new TransfuzijskiCentar("Branislava Đurđeva bb", "Bihać", "037 226 092", "CK grada Bihaća"),
                        new TransfuzijskiCentar("Cazinskih brigada 12", "Cazin", "037 514 454", "CK Općine Cazin"),
                        new TransfuzijskiCentar("Pazačik bb", "Bosanska Krupa", "037 417 011", "CK Općine Bosanska Krupa"),
                        new TransfuzijskiCentar("Branilaca BIH 78", "Ključ", "037 661 066", "CK Općine Ključ"),
                        new TransfuzijskiCentar("Bosanska 13", "Bosanski Petrovac", "037 881 710", "CK Općine Bosanski Petrovac"),
                        new TransfuzijskiCentar("Muse Ćazima Ćatića 12", "Sanski Most", "037 686 200", "CK Općine Sanski Most"),
                        new TransfuzijskiCentar("505 viteške brigade bb", "Bužim", "037 410 099", "CK Općine Bužim"),
                        new TransfuzijskiCentar("Maršala Tita bb", "Velika Kladuša", "037 770 393", "CK Općine Velika Kladuša"),
                        new TransfuzijskiCentar("Četvrta ulica bb", "Orašje", "031 714 508", "CK Posavskog kantona"),
                        new TransfuzijskiCentar("Svete Ane 45", "Domaljevac", "031 791 046", "CK Općine Domaljevac-Šamac"),
                        new TransfuzijskiCentar("Titova bb", "Odžak", "031 762 064", "CK Općine Odžak"),
                        new TransfuzijskiCentar("Treća ulica 54", "Orašje", "031 712 349", "CK Općine Orašje"),
                        new TransfuzijskiCentar("Borić 3", "Tuzla", "035 318 630", "CK Tuzlanskog kantona"),
                        new TransfuzijskiCentar("Branilaca 27", "Banovići", "035 875 065", "CK Općine Banovići"),
                        new TransfuzijskiCentar("Hasana Kikića bb", "Gradačac", "035 817 406", "CK Općine Gradačac"),
                        new TransfuzijskiCentar("Patriotske lige 75", "Čelić", "035 662 189", "CK Općine Čelić"),
                        new TransfuzijskiCentar("Kalesijskih brigada bb", "Kalesija", "035 631 540", "CK Općine Kalesija"),
                        new TransfuzijskiCentar("Brijesnica velika bb", "Doboj-Istok", "035 723 220", "CK Općine Doboj-Istok"),
                        new TransfuzijskiCentar("Kej bb", "Gračanica", "035 703 434", "CK Općine Gračanica"),
                        new TransfuzijskiCentar("Kladanjskih brigada bb", "Kladanj", "035 621 150", "CK Općine Kladanj"),
                        new TransfuzijskiCentar("Vase Pelagića bb", "Lukavac", "035 554 390", "CK Općine Lukavac"),
                        new TransfuzijskiCentar("Bulevar Kulina bana 28E", "Zenica", "032 246 090", "CK Zeničko-Dobojskog kantona"),
                        new TransfuzijskiCentar("Šehidska 24", "Breza", "032 783 495", "CK Općine Breza"),
                        new TransfuzijskiCentar("Školska bb", "Olovo", "032 826 150", "CK Općine Olovo"),
                        new TransfuzijskiCentar("Matuzići bb", "Doboj-Jug", "032 691 564", "CK Općine Doboj-Jug"),
                        new TransfuzijskiCentar("Braće Pobrića 13", "Tešanj", "032 650 463", "CK Općine Tešanj"),
                        new TransfuzijskiCentar("Rudarska 1", "Kakanj", "032 554 968", "CK Općine Kakanj"),
                        new TransfuzijskiCentar("Žabljak bb", "Usora", "032 891 026", "CK Općine Usora"),
                        new TransfuzijskiCentar("Ilijasa Smajlagića 18", "Maglaj", "032 603 302", "CK Općine Maglaj"),
                        new TransfuzijskiCentar("Zvjezda 34", "Vareš", "032 843 343", "CK Općine Vareš"),
                        new TransfuzijskiCentar("Zaima Imamovića 27", "Goražde", "038 221 128", "CK Bosansko Podrinjskog kantona")
                )
        );
        transfuzijskiCentarRepository.saveAll(transfuzijskiCentri);
    }
}
