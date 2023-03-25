package Entity;

import java.util.*;

public class Gwiazda {
    private String nazwa;


    private String nazwaKatalogowa;
    private double deklinacja;
    private double rektascensja;
    private double obserwowanaWielkoscGwiazdowa;
    private double absolutnaWielkoscGwiazdowa;
    private double odleglosc;
    private String gwiazdozbior;
    private String polkula;
    private double temperatura;
    private double masa;

    private static final List<String> greckiAlfabet = Arrays.asList("Alfa", "Beta", "Gamma", "Delta", "Epsilon", "Dzeta",
            "Eta", "Teta", "Jota", "Kappa", "Lambda", "Mi", "Ni", "Ksi", "Omikron", "Pi", "Ro", "Sigma", "Tau",
            "Ypsilon", "Fi", "Chi", "Psi", "Omega");


    private static HashMap<String, Integer> das = new HashMap<>();


    public Gwiazda(String nazwa, double deklinacja, double rektascensja,
                   double obserwowanaWielkoscGwiazdowa, double odleglosc,
                   String gwiazdozbior, String polkula, double temperatura, double masa, String nazwaKatalogowa) {
        this.setNazwa(nazwa);
        this.setDeklinacja(deklinacja);
        this.setRektascensja(rektascensja);
        this.setObserwowanaWielkoscGwiazdowa(obserwowanaWielkoscGwiazdowa);
        this.setOdleglosc(odleglosc);
        this.setGwiazdozbior(gwiazdozbior);
        this.setPolkula(polkula);
        this.setTemperatura(temperatura);
        this.setMasa(masa);
        this.setNazwaKatalogowa(nazwaKatalogowa);
    }

    public String getNazwa() {

        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if (nazwa.matches("[A-Z]{3}[0-9]{4}")) {
            this.nazwa = nazwa;
        } else {
            throw new IllegalArgumentException("Nazwa gwiazdy musi składać się z 3 dużych liter i 4 cyfr");
        }

    }

    public double getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(double deklinacja) {
        if (deklinacja >= 0.0 && deklinacja <= 90.0 || deklinacja >= -90.0 && deklinacja <= 0.0) {
            this.deklinacja = deklinacja;
        } else {
            throw new IllegalArgumentException("Deklinacja musi być pomiędzy 0.0 a 90.0 lub pomiędzy -90.0 a 0.0");
        }
    }


    public double getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(double rektascensja) {
        if (rektascensja >= 0.0 && rektascensja <= 24.0) {
            this.rektascensja = rektascensja;
        } else {
            throw new IllegalArgumentException("Rektascensja musi być pomiędzy 0.0 a 24.0");
        }
    }


    public double getObserwowanaWielkoscGwiazdowa() {

        return obserwowanaWielkoscGwiazdowa;
    }

    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) {
        if (obserwowanaWielkoscGwiazdowa >= -26.74 && obserwowanaWielkoscGwiazdowa <= 15.00) {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        } else {
            throw new IllegalArgumentException("Obserwowana wielkość gwiazdowa musi być pomiędzy -26.74 a 15.00");
        }
    }


    public double getAbsolutnaWielkoscGwiazdowa() {

        return absolutnaWielkoscGwiazdowa;
    }


    public double getOdleglosc() {

        return odleglosc;
    }

    public void setOdleglosc(double odleglosc) {
        this.odleglosc = odleglosc;

        // oblicz absolutną wielkość gwiazdową
        double r = odleglosc / 3.26;
        this.absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - 5 * Math.log10(r) + 5;
    }


    public String getGwiazdozbior() {
        return gwiazdozbior;
    }

    public void setGwiazdozbior(String gwiazdozbior) {
        if (gwiazdozbior.matches("[A-Z][a-z]*")) {
            this.gwiazdozbior = gwiazdozbior;
        } else {
            throw new IllegalArgumentException("Gwiazdozbiór musi zaczynać od dużej litery");
        }

    }

    public String getPolkula() {
        return polkula;
    }

    public void setPolkula(String polkula) {
        if (polkula.equals("PD") || polkula.equals("PN")) {
            this.polkula = polkula;
        } else {
            throw new IllegalArgumentException("Połkula składa się z nazw: (PD / PN)");
        }
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= 2000.0) {
            this.temperatura = temperatura;
        } else {
            throw new IllegalArgumentException("Temperatura musi być równa przynajmniej 2000 stopni");
        }
    }


    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        if (masa >= 0.1 && masa <= 50.0) {
            this.masa = masa;
        } else {
            throw new IllegalArgumentException("Masa gwiazdy musi być z przedziału od 0.1 masy słońca do 50 mas Słońca");
        }
    }

    public String getNazwaKatalogowa() {
        return this.nazwaKatalogowa;

    }

    public void setNazwaKatalogowa(String nazwaKatalogowa) {
        this.nazwaKatalogowa = nazwaKatalogowa;
    }


}




