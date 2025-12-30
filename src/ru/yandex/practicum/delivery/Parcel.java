package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;

    Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.printf("Посылка %s упакована", getDescription());
    }

    public void deliver() {
        System.out.printf("Посылка %s доставлена по адресу %s", getDescription(), getDeliveryAddress());
    }

    public final int calculateDeliveryCost() {
        return getWeight()*getCostPerUnit();
    }

    public abstract int getCostPerUnit();

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

}
