package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int boxWeight;
    private final List<T> box = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getBoxWeight() {
        return boxWeight;
    }

    public void addParcel(T parcel) {
        int remainingWeight = maxWeight - boxWeight;
        if (parcel.getWeight() <= remainingWeight) {
            box.add(parcel);
            boxWeight += parcel.getWeight();
        } else {
            System.out.printf("Превышен вес коробки = %s, посылка не будет добавлена в коробку%n", maxWeight);
        }
    }

    public void getAllParcels() {
        if (!box.isEmpty()) {
            System.out.println("Содержимое коробки:");
            for (T parcel : box) {
                System.out.println(parcel.getDescription());
            }
        } else {
            System.out.println("Коробка пустая");
        }
    }
}
