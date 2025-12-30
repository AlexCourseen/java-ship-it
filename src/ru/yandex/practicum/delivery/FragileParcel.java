package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {

    private static final int FRAGILE_COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCostPerUnit() {
        return FRAGILE_COST;
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка %s обёрнута в защитную плёнку", getDescription());
        super.packageItem();
    }

}
