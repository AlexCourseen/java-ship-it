package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableIsExpiredTest {
    private PerishableParcel parcel;

    @BeforeEach
    public void createPerishableParcel() {
        parcel = new PerishableParcel("d", 2, "a", 2, 3);
    }

    @Test
    public void shouldReturnFalseIfCurrentDayIsLessThanTimeToLiveMinus1() {
        boolean isExpired = parcel.isExpired(4);
        assertFalse(isExpired);
    }

    @Test
    public void shouldReturnFalseIfCurrentDayEqualsTimeToLive() {
        boolean isExpired = parcel.isExpired(5);
        assertFalse(isExpired);
    }

    @Test
    public void shouldReturnTrueIfCurrentDayMoreThanTimeToLivePlus1() {
        boolean isExpired = parcel.isExpired(6);
        assertTrue(isExpired);
    }


}
