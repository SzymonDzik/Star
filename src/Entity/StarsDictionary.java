package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StarsDictionary {




    public static final List<String> greckiAlfabet = Arrays.asList("Alfa", "Beta", "Gamma", "Delta", "Epsilon", "Dzeta",
            "Eta", "Teta", "Jota", "Kappa", "Lambda", "Mi", "Ni", "Ksi", "Omikron", "Pi", "Ro", "Sigma", "Tau",
            "Ypsilon", "Fi", "Chi", "Psi", "Omega");

    public static List<Gwiazda> gwiazdaList = new ArrayList<>();
    public static HashMap<String, Integer> das = new HashMap<>();



    public static void wypiszParametry() {

        for (int i = 0; i < gwiazdaList.size(); i++) {
            Gwiazda g = gwiazdaList.get(i);
            System.out.print("  Nazwa: " + g.getNazwa());
            System.out.print("  Nazwa katalogowa : " + g.getNazwaKatalogowa());
            System.out.print("  Deklinacja: " + g.getDeklinacja());
            System.out.print("  Rektascensja: " + g.getRektascensja());
            System.out.print("  Obserwowana wielkość gwiazdowa: " + g.getObserwowanaWielkoscGwiazdowa());
            System.out.print("  Absolutna wielkość gwiazdowa: " + g.getAbsolutnaWielkoscGwiazdowa());
            System.out.print("  Odległość w latach świetlnych: " + g.getOdleglosc());
            System.out.print("  Gwiazdozbiór: " + g.getGwiazdozbior());
            System.out.print("  Półkula: " + g.getPolkula());
            System.out.print("  Temperatura: " + g.getTemperatura());
            System.out.print("  Masa: " + g.getMasa());
            System.out.println();
        }

    }

    public   List<Gwiazda> wypiszGwiazdyWGwiazdozbiorze(String gwiazdozbior) {
        List<Gwiazda> znalezioneWGwiazdozbiorze = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdaList) {
            if (gwiazda.getGwiazdozbior().equals(gwiazdozbior)) {
                System.out.println("Nazwa: " + gwiazda.getNazwa() + "Nazwa katalogowa: " + gwiazda.getNazwaKatalogowa());
                znalezioneWGwiazdozbiorze.add(gwiazda);
            }
        }
        return znalezioneWGwiazdozbiorze;
    }

    public   List<Gwiazda> wypiszGwiazdyOPodanejTemperaturze(double temperatura1, double temperatura2) {
        List<Gwiazda> gwiazdyOTemperaturze = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.getTemperatura() >= temperatura1 && g.getTemperatura() <= temperatura2) {
                gwiazdyOTemperaturze.add(g);
            }
        }
        return gwiazdyOTemperaturze;
    }

    public List<Gwiazda> wypiszGwiazdyOWIelkosciGwiazdowej(double wielkosc1, double wielkosc2) {
        List<Gwiazda> gwiazdyOWielkosci = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.getObserwowanaWielkoscGwiazdowa() >= wielkosc1 && g.getObserwowanaWielkoscGwiazdowa() <= wielkosc2) {
                gwiazdyOWielkosci.add(g);
            }
        }
        return gwiazdyOWielkosci;
    }


    public  List<Gwiazda> wypiszGwiazdyZPolkuli(String polkula) {
        List<Gwiazda> gwiazdaPolkula = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.getPolkula() == polkula) {
                gwiazdaPolkula.add(g);
            }
        }
        return gwiazdaPolkula;
    }

    public List<Gwiazda> potencjalneSupernowe() {
        List<Gwiazda> gwiazdySupernowe = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.getMasa() > 1.44) {
                gwiazdySupernowe.add(g);
            }
        }
        return gwiazdySupernowe;
    }

    public   List<Gwiazda> wyszukajGwiazdyWOdleglosciOdZiemi(double odlegloscSzukana) {
        List<Gwiazda> gwiazdyWOdleglosci = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.getOdleglosc() <= odlegloscSzukana * 3.26) {
                gwiazdyWOdleglosci.add(g);
            }
        }
        return gwiazdyWOdleglosci;
    }

    public void usunGwiazde(String nazwa) {
        List<Gwiazda> gwiazdyDoUsuniecia = new ArrayList<>();
        List<Gwiazda> nowaLista = new ArrayList<>();

        for (Gwiazda gwiazda : gwiazdaList) {
            if (gwiazda.getNazwa().equals(nazwa)) {
                gwiazdyDoUsuniecia.add(gwiazda);
                int index = das.get(gwiazda.getGwiazdozbior());
                if (index > 0) {
                    das.put(gwiazda.getGwiazdozbior(), index - 1);
                    ArrayList<Gwiazda> filtered = new ArrayList();
                    for (Gwiazda g : gwiazdaList) {
                        if (g.getGwiazdozbior().equals(gwiazda.getGwiazdozbior())) {
                            filtered.add(g);
                        }
                    }
                    filtered.remove(gwiazda);
                    for (int i = 0; i < filtered.size(); i++) {
                        gwiazdyDoUsuniecia.add(filtered.get(i));
                        filtered.get(i).setNazwaKatalogowa(greckiAlfabet.get(i) + " " + filtered.get(i).getGwiazdozbior());
                        nowaLista.add(filtered.get(i));
                    }
                } else {
                    das.remove(gwiazda.getGwiazdozbior());
                }

            }
        }
        gwiazdaList.removeAll(gwiazdyDoUsuniecia);
        if (!nowaLista.isEmpty()) {
            gwiazdaList.addAll(nowaLista);
        }
    }

    public  void dodajGwiazde(Gwiazda gwiazda) {
        gwiazdaList.add(gwiazda);
    }
}
