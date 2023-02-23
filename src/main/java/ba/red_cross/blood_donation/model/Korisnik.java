package ba.red_cross.blood_donation.model;

import ba.red_cross.blood_donation.DTO.EditKorisnik;
import ba.red_cross.blood_donation.DTO.RegisterRequest;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Korisnik implements Comparable<Korisnik> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

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
    private Boolean slatiNotifikacije;

    private LocalDate datumKreiranjaRacuna;

    // Veze između tabela

    // Rola 1-n
    @ManyToOne ()
    @JoinColumn(name="rola_id", nullable=false)
    private Rola rola;

    // Device 1-n
    @OneToMany(mappedBy = "korisnik")
    private Set<Uredaj> uredaji;

    // Priznanja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_priznanje",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "priznanje_ID", referencedColumnName = "ID", nullable = false, updatable = false)})
    private Set<Priznanje> priznanja = new HashSet<>();

    @OneToMany(
            mappedBy = "korisnik",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<KorisnikAkcijaDarivanjaKrvi> akcijeDarivanja; //= new ArrayList<>();

    @OneToMany(
            mappedBy = "korisnik",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<KorisnikNotifikacija> notifikacije;// = new ArrayList<>();

    public List<KorisnikAkcijaDarivanjaKrvi> getAkcijeDarivanja() {
        return akcijeDarivanja;
    }

    public void setAkcijeDarivanja(List<KorisnikAkcijaDarivanjaKrvi> akcijeDarivanja) {
        this.akcijeDarivanja = akcijeDarivanja;
    }

    public List<KorisnikNotifikacija> getNotifikacije() {
        return notifikacije;
    }

    public void setNotifikacije(List<KorisnikNotifikacija> notifikacije) {
        this.notifikacije = notifikacije;
    }

    // Akcije darivanja n-n
    // bilo lazy i merge
  /*  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonManagedReference
    @JoinTable(name = "korisnik_akcije_darivanja",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = true, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "akcijeDarivanjaKrvi_ID", referencedColumnName = "ID", nullable = true, updatable = false)})
    @OrderBy(value ="datum DESC")
    private Set<AkcijaDarivanjaKrvi> akcijeDarivanja = new HashSet<>();

    // Notifikacije n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_notifikacije",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "notifikacije_ID", referencedColumnName = "ID", nullable = false, updatable = false)})
    @JsonManagedReference
    private Set<Notifikacija> notifikacije = new HashSet<>();

    public Set<AkcijaDarivanjaKrvi> getAkcijeDarivanja() {
        return akcijeDarivanja;
    }

    public void setAkcijeDarivanja(Set<AkcijaDarivanjaKrvi> akcijeDarivanja) {
        this.akcijeDarivanja = akcijeDarivanja;
    }

    public Set<Notifikacija> getNotifikacije() {
        return notifikacije;
    }

    public void setNotifikacije(Set<Notifikacija> notifikacije) {
        this.notifikacije = notifikacije;
    }
*/
    public Korisnik() {}

    public Korisnik(String ime, String prezime, String korisnickoIme, String spol, LocalDate datumRodenja, String mjestoRodenja, String mjestoPrebivalista, String adresaPrebivalista, String kantonPrebivalista, String kontaktTelefon, String zanimanje, String krvnaGrupa, int brojDarivanjaKrvi, String emailAdresa, String lozinka, Boolean slatiNotifikacije, LocalDate datumKreiranjaRacuna, Rola rola) {
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
        this.slatiNotifikacije = slatiNotifikacije;
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
        this.rola = rola;
    }

    public Korisnik(String ime, String prezime, String korisnickoIme, String spol, LocalDate datumRodenja, String mjestoRodenja, String mjestoPrebivalista, String adresaPrebivalista, String kantonPrebivalista, String kontaktTelefon, String zanimanje, String krvnaGrupa, int brojDarivanjaKrvi, String emailAdresa, String lozinka, Boolean slatiNotifikacije, LocalDate datumKreiranjaRacuna) {
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
        this.slatiNotifikacije = slatiNotifikacije;
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
    }

    public Korisnik(RegisterRequest user, Rola role, LocalDate datumKreiranjaRacuna) {
        this.ime = user.getIme();
        this.prezime = user.getPrezime();
        this.korisnickoIme = user.getKorisnickoIme();
        this.spol = user.getSpol();
        this.datumRodenja = user.getDatumRodenja();
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
        this.mjestoRodenja = user.getMjestoRodenja();
        this.mjestoPrebivalista = user.getMjestoPrebivalista();
        this.adresaPrebivalista = user.getAdresaPrebivalista();
        this.kantonPrebivalista = user.getKantonPrebivalista();
        this.kontaktTelefon = user.getKontaktTelefon();
        this.zanimanje = user.getZanimanje();
        this.krvnaGrupa = user.getKrvnaGrupa();
        this.brojDarivanjaKrvi = user.getBrojDarivanjaKrvi();
        this.emailAdresa = user.getEmailAdresa();
        this.rola = role;
        this.slatiNotifikacije = true;
        this.lozinka = user.getLozinka();
    }

    public Korisnik promijeniInfromacije(EditKorisnik editKorisnik) {
        this.ime = editKorisnik.getIme();
        this.prezime = editKorisnik.getPrezime();
        this.datumRodenja = editKorisnik.getDatumRodenja();
        this.mjestoRodenja = editKorisnik.getMjestoRodenja();
        this.mjestoPrebivalista = editKorisnik.getMjestoPrebivalista();
        this.adresaPrebivalista = editKorisnik.getAdresaPrebivalista();
        this.kantonPrebivalista = editKorisnik.getKantonPrebivalista();
        this.kontaktTelefon = editKorisnik.getKontaktTelefon();
        this.zanimanje = editKorisnik.getZanimanje();
        return this;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Boolean getSlatiNotifikacije() {
        return slatiNotifikacije;
    }

    public void setSlatiNotifikacije(Boolean slatiNotifikacije) {
        this.slatiNotifikacije = slatiNotifikacije;
    }

    public LocalDate getDatumKreiranjaRacuna() {
        return datumKreiranjaRacuna;
    }

    public void setDatumKreiranjaRacuna(LocalDate datumKreiranjaRacuna) {
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }

    public Set<Uredaj> getUredaji() {
        return uredaji;
    }

    public void setUredaji(Set<Uredaj> uredaji) {
        this.uredaji = uredaji;
    }

    public Set<Priznanje> getPriznanja() {
        return priznanja;
    }

    public void setPriznanja(Set<Priznanje> priznanja) {
        this.priznanja = priznanja;
    }

//    public Set<AkcijaDarivanjaKrvi> getAkcijeDarivanja() {
//        return akcijeDarivanja;
//    }
//
//    public void setAkcijeDarivanja(Set<AkcijaDarivanjaKrvi> akcijeDarivanja) {
//        this.akcijeDarivanja = akcijeDarivanja;
//    }
//
//    public Set<Notifikacija> getNotifikacije() {
//        return notifikacije;
//    }
//
//    public void setNotifikacije(Set<Notifikacija> notifikacije) {
//        this.notifikacije = notifikacije;
//    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }


    @Override
    public int compareTo(Korisnik o) {
        return (o.getDatumKreiranjaRacuna().compareTo(this.getDatumKreiranjaRacuna()));
       // return 0;
    }
}
