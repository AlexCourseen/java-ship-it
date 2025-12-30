package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

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
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Укажите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 3) {
            System.out.println("Нет такого типа посылки.");
            return;
        }
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
                parcel = new StandardParcel(description,weight,deliveryAddress,sendDay);
                break;
            case 2:
                parcel = new FragileParcel(description,weight,deliveryAddress,sendDay);
                break;
            case 3:
                System.out.println("Укажите через сколько дней посылка испортится:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description,weight,deliveryAddress,sendDay,timeToLive);
                break;
        }
        allParcels.add(parcel);
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

}

