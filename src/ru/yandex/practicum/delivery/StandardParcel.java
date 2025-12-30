package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    private static final int STANDART_COST = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCostPerUnit() {
        return STANDART_COST;
    }

}
