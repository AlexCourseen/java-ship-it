package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Parcel> parcelsWithReport = new ArrayList<>();
    private static ParcelBox<Parcel> standardBox = new ParcelBox<>(10);
    private static ParcelBox<Parcel> fragileBox = new ParcelBox<>(20);
    private static ParcelBox<Parcel> perishableBox = new ParcelBox<>(30);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatusService();
                    break;
                case 5:
                    boxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Вызвать трекинг сервис");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        int choice = chooseParcelType();
        System.out.println("Укажите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Укажите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите адрес получения:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Укажите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        Parcel parcel = null;
        switch (choice) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardBox.addParcel(parcel);
                break;
            case 2:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                fragileBox.addParcel(parcel);
                parcelsWithReport.add(parcel);
                break;
            case 3:
                System.out.println("Укажите через сколько дней посылка испортится:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableBox.addParcel(parcel);
                break;
        }
        allParcels.add(parcel);
    }

    private static void sendParcels() {
        if (!allParcels.isEmpty()) {
            for (Parcel parcel : allParcels) {
                parcel.packageItem();
                parcel.deliver();
            }
        } else {
            System.out.println("Нет посылок для отправления");
        }
    }

    private static void calculateCosts() {
        int allCosts = 0;
        for (Parcel parcel : allParcels) {
            allCosts += parcel.calculateDeliveryCost();
        }
        System.out.printf("Общая стоимость доставки всех посылок: %s%n", allCosts);
    }

    private static int chooseParcelType() {
        int choice;
        while (true) {
            System.out.println("Укажите тип посылки:");
            System.out.println("1 — Стандартная");
            System.out.println("2 — Хрупкая");
            System.out.println("3 — Скоропортящаяся");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 3) {
                System.out.println("Нет такого типа посылки.");
            } else {
                break;
            }
        }
        return choice;
    }

    private static void reportStatusService() {
        if (!parcelsWithReport.isEmpty()) {
            /*Оставил коллекцию, т.к. по условию ее создаем и добавляем в неё хрупкие,
            я забыл добавлять в эту коллекцию хрупкие посылки(строка 78 - добавил)*/
            for (Parcel p : parcelsWithReport) {
                if (p instanceof Trackable) {
                    System.out.println("Укажите новое местоположение посылки:");
                    String newLocation = scanner.nextLine();
                    ((Trackable) p).reportStatus(newLocation);
                }
            }
        } else {
            System.out.println("Нет посылок с трекинг сервисом");
        }
    }

    private static void boxContent() {
        int choice = chooseParcelType();
        switch (choice) {
            case 1:
                standardBox.getAllParcels();
                break;
            case 2:
                fragileBox.getAllParcels();
                break;
            case 3:
                perishableBox.getAllParcels();
                break;
        }
    }
}

