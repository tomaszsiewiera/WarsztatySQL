package pl.coderslab.entity;

import warsztaty.DbUtilS;
import pl.coderslab.entity.UserDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbUtilS dbUtils = new DbUtilS();
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("Wybierz opcje: ");

            for (UserDao loop : UserDao.values()) {
                System.out.println(loop);
            }
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {

                case 1:
                    dbUtils.DBConnection();
                    System.out.println(" Wpisz imię: ");
                    String username = scanner.nextLine();
                    System.out.println(" Wpisz email: ");
                    String email = scanner.nextLine();
                    System.out.println(" Wpisz hasło: ");
                    String haslo = scanner.nextLine();
                    dbUtils.dodajUzytkownika(username, email, haslo);
                    dbUtils.closeConnection();
                    break;
                case 2:
                    dbUtils.DBConnection();
                    System.out.println("Podaj id do usunięcia: ");
                    String iduser = scanner.nextLine();
                    System.out.println(" Wpisz imię: ");
                    String username1 = scanner.nextLine();
                    System.out.println(" Wpisz email: ");
                    String email1 = scanner.nextLine();
                    System.out.println(" Wpisz hasło: ");
                    String haslo1 = scanner.nextLine();
                    dbUtils.aktualizacja(iduser, username1, email1, haslo1);
                    dbUtils.closeConnection();
                    break;

                case 3:
                    System.out.println("Podaj id użyownika: ");
                    String id = scanner.nextLine();
                    dbUtils.DBConnection();
                    dbUtils.znajdzUzytkownika(id);
                    dbUtils.closeConnection();
                    break;
                case 4:
                    System.out.println("Podaj id użyownika: ");
                    String ids = scanner.nextLine();
                    dbUtils.DBConnection();
                    dbUtils.usunUzytkownika(ids);
                    dbUtils.closeConnection();
                    break;
                case 5:
                    dbUtils.DBConnection();
                    dbUtils.listaUzytkowników();
                    dbUtils.closeConnection();
                    break;
                case 6:
                    System.out.println("Dowidzenia");
                    dbUtils.closeConnection();
                    exit = false;
                    break;
            }
        }
    }
}