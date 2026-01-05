package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    private final int timeToLive;
    private static final int PERISHABLE_COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getCostPerUnit() {
        return PERISHABLE_COST;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public final boolean isExpired(int currentDay) {
        int sendDay = getSendDay();
        return (sendDay + timeToLive) < currentDay;
    }


}
