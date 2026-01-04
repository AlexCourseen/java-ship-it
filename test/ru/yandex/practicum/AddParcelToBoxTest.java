package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;


public class AddParcelToBoxTest {
    private ParcelBox parcelBox;

    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>(10);
    }

    @Test
    public void boxWeightEqualsMaxBoxWeightIfParcelAddedToBoxAndMaxWeightEqualsParcelWeight() {
        Parcel parcel = new StandardParcel("testDescription", 10, "a", 8);
        parcelBox.addParcel(parcel);
        assertEquals(parcelBox.getMaxWeight(), parcelBox.getBoxWeight());
    }

    @Test
    public void boxWeightEquals0IfParcelCantAddToBoxBecauseMaxWeightLessThanParcelWeight() {
        Parcel parcel = new StandardParcel("testDescription", 11, "a", 8);
        parcelBox.addParcel(parcel);
        assertEquals(0,parcelBox.getBoxWeight());
    }

    @Test
    public void boxWeightEqualsMaxBoxWeighAfterAdded2ParcelsIfSumOfParcelWeightLessThanMaxWeight() {
        Parcel parcel1 = new StandardParcel("testDescription", 9, "a", 8);
        Parcel parcel2 = new StandardParcel("testDescription2", 1, "a", 8);
        parcelBox.addParcel(parcel1);
        parcelBox.addParcel(parcel2);
        assertEquals(parcelBox.getBoxWeight(), parcelBox.getMaxWeight());
    }

    @Test
    public void boxWeightEqualsMaxWeightMinus1AfterParcelAddedToBoxBecauseWithWeightLessThanMaxBoxWeightBy1() {
        Parcel parcel = new StandardParcel("testDescription", 9, "a", 8);
        parcelBox.addParcel(parcel);
        assertEquals(parcelBox.getBoxWeight(), (parcelBox.getMaxWeight() - 1));
    }
}
