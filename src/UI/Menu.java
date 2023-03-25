package UI;

import Entity.Gwiazda;
import Entity.StarsDictionary;

import java.util.List;
import java.util.Scanner;




public class Menu{
    StarsDictionary star;

    public Menu(StarsDictionary star) {
        this.star = star;
    }

    public void menu() {




        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);

        while (shouldContinue) {
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

                    if (star.das.containsKey(gwiazdozbiór)) {
                        star.das.put(gwiazdozbiór, star.das.get(gwiazdozbiór) + Integer.valueOf(1));
                    } else {
                        star.das.put(gwiazdozbiór, Integer.valueOf(0));
                    }
                    Gwiazda gwiazda = new Gwiazda(nazwa, deklinacja, rektascensja, obserwowanaWielkoscGwiazdowa, odleglosc, gwiazdozbiór, polkula, temperatura, masa, star.greckiAlfabet.get(star.das.get(gwiazdozbiór)) + " " + gwiazdozbiór);
                    star.dodajGwiazde(gwiazda);
                    break;
                case 2:
                    System.out.print("Podaj nazwę gwiazdy do usunięcia: ");
                    String nazwaUsuwanejGwiazdy = scanner.next();
                    star.usunGwiazde(nazwaUsuwanejGwiazdy);
                case 3:
                    star.wypiszParametry();
                    break;
                case 4:
                    System.out.println("Podaj temperatury: ");
                    temperatura = scanner.nextDouble();
                    double temperaturaa = scanner.nextDouble();

                    List<Gwiazda> znalezioneGwiazdy = star.wypiszGwiazdyOPodanejTemperaturze(temperatura, temperaturaa);
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
                    gwiazdozbiór = scanner.next();
                    ;

                    List<Gwiazda> znalezioneGwiazdyW = star.wypiszGwiazdyWGwiazdozbiorze(gwiazdozbiór);
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

                    List<Gwiazda> znalezioneGwiazdyO = star.wypiszGwiazdyOWIelkosciGwiazdowej(obserwowanaWielkoscGwiazdowa, obserwowana);
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

                    List<Gwiazda> znalezioneGwiazdyP = star.wypiszGwiazdyZPolkuli(polkula);
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

                    List<Gwiazda> znalezioneGwiazdyS = star.potencjalneSupernowe();
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

                    List<Gwiazda> znalezioneGwiazdyOD = star.wyszukajGwiazdyWOdleglosciOdZiemi(odleglosc);
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
