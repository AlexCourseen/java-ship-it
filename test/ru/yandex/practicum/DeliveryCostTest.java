package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    @Test
    public void standardParcelDeliveryCostIs20IfWeight10() {
        Parcel parcel = new StandardParcel("d",10,"a",1);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(20,parcelDeliveryCost);
    }

    @Test
    public void standardParcelDeliveryCostIs0IfWeight0() {
        Parcel parcel = new StandardParcel("d",0,"a",1);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(0,parcelDeliveryCost);
    }

    @Test
    public void fragileParcelDeliveryCostIs40IfWeight10() {
        Parcel parcel = new FragileParcel("d",10,"a",1);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(40,parcelDeliveryCost);
    }

    @Test
    public void fragileParcelDeliveryCostIs0IfWeight0() {
        Parcel parcel = new FragileParcel("d",0,"a",1);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(0,parcelDeliveryCost);
    }

    @Test
    public void perishableParcelDeliveryCostIsIfWeight10() {
        Parcel parcel = new PerishableParcel("d",10,"a",1,6);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(30,parcelDeliveryCost);
    }

    @Test
    public void perishableParcelDeliveryCostIs0IfWeight0() {
        Parcel parcel = new PerishableParcel("d",0,"a",1,6);
        int parcelDeliveryCost = parcel.calculateDeliveryCost();
        assertEquals(0,parcelDeliveryCost);
    }
}
