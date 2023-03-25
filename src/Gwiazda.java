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

    private static List<Gwiazda> gwiazdaList = new ArrayList<>();
    private static HashMap<String, Integer> das = new HashMap<>();




    public Gwiazda(String nazwa,  double deklinacja, double rektascensja,
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
        }
        else {
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
        if(gwiazdozbior.matches("[A-Z][a-z]*")){
            this.gwiazdozbior = gwiazdozbior;
        }
        else {
            throw new IllegalArgumentException("Gwiazdozbiór musi zaczynać od dużej litery");
        }

    }

    public String getPolkula(){
        return polkula;
    }
    public void setPolkula(String polkula){
        if(polkula.equals("PD") || polkula.equals("PN")){
            this.polkula = polkula;
        }
        else {
            throw new IllegalArgumentException("Połkula składa się z nazw: (PD / PN)");
        }
    }

    public double getTemperatura(){
        return temperatura;
    }

    public void setTemperatura(double temperatura){
        if(temperatura >= 2000.0){
            this.temperatura = temperatura;
        }
        else {
            throw new IllegalArgumentException("Temperatura musi być równa przynajmniej 2000 stopni");
        }
    }


    public double getMasa(){
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


    public static void  dodajGwiazde(Gwiazda gwiazda){
        gwiazdaList.add(gwiazda);
    }

    public static void usunGwiazde(String nazwa) {
        List<Gwiazda> gwiazdyDoUsuniecia = new ArrayList<>();
        List<Gwiazda> nowaLista = new ArrayList<>();

        for (Gwiazda gwiazda : gwiazdaList) {
            if (gwiazda.nazwa.equals(nazwa)) {
                gwiazdyDoUsuniecia.add(gwiazda);
                int index = das.get(gwiazda.gwiazdozbior);
                if(index > 0){
                    das.put(gwiazda.gwiazdozbior, index - 1);
                    ArrayList<Gwiazda> filtered = new ArrayList();
                    for(Gwiazda g : gwiazdaList) {
                        if(g.gwiazdozbior.equals(gwiazda.gwiazdozbior)){
                            filtered.add(g);
                        }
                    }
                    filtered.remove(gwiazda);
                    for(int i =0 ; i< filtered.size();i++){
                        gwiazdyDoUsuniecia.add(filtered.get(i));
                        filtered.get(i).nazwaKatalogowa = greckiAlfabet.get(i) + " " + filtered.get(i).gwiazdozbior;
                        nowaLista.add(filtered.get(i));
                    }
                }else{
                    das.remove(gwiazda.gwiazdozbior);
                }

            }
        }
        gwiazdaList.removeAll(gwiazdyDoUsuniecia);
        if(!nowaLista.isEmpty()){
            gwiazdaList.addAll(nowaLista);
        }
    }

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

    private static List<Gwiazda> wypiszGwiazdyWGwiazdozbiorze(String gwiazdozbior){
        List<Gwiazda> znalezioneWGwiazdozbiorze = new ArrayList<>();
        for (Gwiazda gwiazda: gwiazdaList) {
            if(gwiazda.gwiazdozbior.equals(gwiazdozbior)){
                System.out.println("Nazwa: " + gwiazda.nazwa + "Nazwa katalogowa: " + gwiazda.nazwaKatalogowa);
                znalezioneWGwiazdozbiorze.add(gwiazda);
            }
        }
        return znalezioneWGwiazdozbiorze;
    }

    private static List<Gwiazda> wypiszGwiazdyOPodanejTemperaturze(double temperatura1, double temperatura2) {
        List<Gwiazda> gwiazdyOTemperaturze =new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.temperatura >= temperatura1 && g.temperatura <= temperatura2) {
                gwiazdyOTemperaturze.add(g);
            }
        }
        return  gwiazdyOTemperaturze;
    }

    private static List<Gwiazda> wypiszGwiazdyOWIelkosciGwiazdowej(double wielkosc1, double wielkosc2) {
        List<Gwiazda> gwiazdyOWielkosci = new ArrayList<>();
        for (Gwiazda g : gwiazdaList) {
            if (g.obserwowanaWielkoscGwiazdowa >= wielkosc1 && g.obserwowanaWielkoscGwiazdowa <= wielkosc2) {
                gwiazdyOWielkosci.add(g);
            }
        }
        return  gwiazdyOWielkosci;
    }


    private static List<Gwiazda> wypiszGwiazdyZPolkuli(String polkula){
        List<Gwiazda> gwiazdaPolkula = new ArrayList<>() ;
        for(Gwiazda g : gwiazdaList){
            if(g.polkula == polkula){
                gwiazdaPolkula.add(g);
            }
        }
        return gwiazdaPolkula;
    }

    private static List<Gwiazda> potencjalneSupernowe(){
        List<Gwiazda> gwiazdySupernowe = new ArrayList<>();
        for(Gwiazda g : gwiazdaList){
            if(g.masa > 1.44){
                gwiazdySupernowe.add(g);
            }
        }
        return gwiazdySupernowe;
    }

    private static List<Gwiazda> wyszukajGwiazdyWOdleglosciOdZiemi(double odlegloscSzukana){
        List<Gwiazda> gwiazdyWOdleglosci = new ArrayList<>();
        for(Gwiazda g : gwiazdaList){
            if(g.odleglosc <= odlegloscSzukana*3.26){
                gwiazdyWOdleglosci.add(g);
            }
        }
        return  gwiazdyWOdleglosci;
    }


    public  static void menu() {

        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);

        while(shouldContinue){
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj gwiazdę");
            System.out.println("2. Usuń gwiazdę");
            System.out.println("3. Wypisz gwiazdy");
            System.out.println("4. Wypisz gwiazdy o podanej temperaturze");
            System.out.println("5. Wypisz gwiazdy w gwiazdozbiorze");
            System.out.println("6. Wypisz gwiazdy o podanej wielkości gwiazdowej");
            System.out.println("7. Wypisz gwiazdy z podanej polkuli");
            System.out.println("8. Wypisz potencjalne supernowe");
            System.out.println("9. Wypisz gwiazdy o podanej odleglosci od Ziemi");
            System.out.println("0. Zakończ");

            int wybor = scanner.nextInt();



            switch (wybor) {
                case 1:
                    System.out.println("Podaj nazwę (3 duże litery i 4 liczby): ");
                    String nazwa = scanner.next();
                    System.out.println("Podaj deklinacje (-90 , 90): ");
                    double deklinacja = Double.parseDouble(scanner.next());
                    System.out.println("Podaj rektascensje (0 , 24): ");
                    double rektascensja = Double.parseDouble(scanner.next());
                    System.out.println("Podaj obserwowana wielkosc gwiazdowa(-26.74 , 15.0): ");
                    double obserwowanaWielkoscGwiazdowa = Double.parseDouble(scanner.next());
                    System.out.println("Podaj odleglosc od Ziemi");
                    double odleglosc = Double.parseDouble(scanner.next());
                    System.out.println("Podaj gwiazdozbiór (Od dużej litery): ");
                    String gwiazdozbiór = scanner.next();
                    System.out.println("Podaj polkule z ktorej widac gwiazde (PD / PN):  ");
                    String polkula = scanner.next();
                    System.out.println("Podaj temperaturę (Od 2000): ");
                    double temperatura = scanner.nextDouble();
                    System.out.println("Podaj mase w stosunku do slonca (Od 0.1 do 50.0: ");
                    double masa = scanner.nextDouble();

                    if(das.containsKey(gwiazdozbiór)){
                        das.put(gwiazdozbiór, das.get(gwiazdozbiór)+Integer.valueOf(1));
                    }else{
                        das.put(gwiazdozbiór, Integer.valueOf(0));
                    }
                    Gwiazda gwiazda = new Gwiazda(nazwa, deklinacja,rektascensja,obserwowanaWielkoscGwiazdowa,odleglosc,gwiazdozbiór, polkula, temperatura,  masa, greckiAlfabet.get(das.get(gwiazdozbiór)) + " " + gwiazdozbiór);
                    dodajGwiazde(gwiazda);
                    break;
                case 2:
                    System.out.print("Podaj nazwę gwiazdy do usunięcia: ");
                    String nazwaUsuwanejGwiazdy = scanner.next();
                    usunGwiazde(nazwaUsuwanejGwiazdy);
                case 3:
                    wypiszParametry();
                    break;
                case 4:
                    System.out.println("Podaj temperatury: ");
                    temperatura = scanner.nextDouble();
                    double temperaturaa = scanner.nextDouble();

                    List<Gwiazda> znalezioneGwiazdy = wypiszGwiazdyOPodanejTemperaturze(temperatura, temperaturaa);
                    if (znalezioneGwiazdy.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdy) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa katalogowa: " + g.getNazwaKatalogowa());
                            System.out.print("  Temperatura: " + g.getTemperatura());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono gwiazd o temperaturze pomiedzy " + temperatura + " " + temperaturaa + ". ");
                    }
                    break;
                case 5:
                    System.out.println("Podaj gwiazdozbiór: ");
                    gwiazdozbiór = scanner.next();;

                    List<Gwiazda> znalezioneGwiazdyW = wypiszGwiazdyWGwiazdozbiorze(gwiazdozbiór);
                    if (znalezioneGwiazdyW.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdyW) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa katalogowa: " + g.getNazwaKatalogowa());
                            System.out.print("  Gwiazdozbiór: " + g.getGwiazdozbior());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono gwiazd w gwiazdozbiorze: " + gwiazdozbiór);
                    }
                    break;
                case 6:
                    System.out.println("Podaj wielkosc gwiazdowa: ");
                    obserwowanaWielkoscGwiazdowa = Double.parseDouble(scanner.next());
                    double obserwowana = Double.parseDouble(scanner.next());

                    List<Gwiazda> znalezioneGwiazdyO = wypiszGwiazdyOWIelkosciGwiazdowej(obserwowanaWielkoscGwiazdowa, obserwowana);
                    if (znalezioneGwiazdyO.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdyO) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa katalogowa: " + g.getNazwaKatalogowa());
                            System.out.print("  Gwiazdozbiór: " + g.getObserwowanaWielkoscGwiazdowa());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono gwiazd pomiędzy wielkościami: " + obserwowanaWielkoscGwiazdowa + " " + obserwowana);
                    }
                    break;

                case 7:
                    System.out.println("Podaj polkule: ");
                    polkula = scanner.next();

                    List<Gwiazda> znalezioneGwiazdyP = wypiszGwiazdyZPolkuli(polkula);
                    if (znalezioneGwiazdyP.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdyP) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa: " + g.getNazwaKatalogowa());
                            System.out.print("  Gwiazdozbiór: " + g.getPolkula());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono gwiazd na polkuli: " + polkula);
                    }
                    break;

                case 8:

                    List<Gwiazda> znalezioneGwiazdyS = potencjalneSupernowe();
                    if (znalezioneGwiazdyS.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdyS) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa: " + g.getNazwaKatalogowa());
                            System.out.print("  Masa: " + g.getMasa());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono supernowych");
                    }
                    break;

                case 9:
                    System.out.println("Podaj odleglosc od Ziemi ");
                    odleglosc = Double.parseDouble(scanner.next());

                    List<Gwiazda> znalezioneGwiazdyOD = wyszukajGwiazdyWOdleglosciOdZiemi(odleglosc);
                    if (znalezioneGwiazdyOD.size() > 0) {
                        System.out.println("Znalezione gwiazdy:");
                        for (Gwiazda g : znalezioneGwiazdyOD) {
                            System.out.print("Nazwa: " + g.getNazwa());
                            System.out.print("  Nazwa: " + g.getNazwaKatalogowa());
                            System.out.print("  Odleglosc: " + g.getOdleglosc());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nie znaleziono gwiazd w odleglosci: " + odleglosc);
                    }
                    break;
                case 0:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Nieznana opcja");
                    break;
        }

        }
    }
}




