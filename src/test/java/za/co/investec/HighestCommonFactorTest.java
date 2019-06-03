package za.co.investec;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HighestCommonFactorTest {
    @Test
    void whenCallingGreatestCommonFactor_thenReturn4_HappyDays() {
        String numberList = "8 20 36";
        assertEquals((int) Integer.valueOf("4"), HighestCommonFactor.greatestCommonFactor(Arrays.asList(numberList.split(" "))));
    }

    @Test
    void whenCallingGreatestCommonFactor_thenReturn_MixingUpOrder() {
        String numberList = "20 8 36";
        assertEquals((int) Integer.valueOf("4"), HighestCommonFactor.greatestCommonFactor(Arrays.asList(numberList.split(" "))));
    }

    @Test
    void whenCallingGreatestCommonFactor_thenReturn_IncreaseArgs() {
        String numberList = "20 8 36 40";
        assertEquals((int) Integer.valueOf("4"), HighestCommonFactor.greatestCommonFactor(Arrays.asList(numberList.split(" "))));
    }

    @Test
    void whenCallingGreatestCommonFactorWithInvalidArgs_thenThrowException() {
        String numberList = "20 8 36 x";
        assertThrows(NumberFormatException.class, () -> HighestCommonFactor.greatestCommonFactor(Arrays.asList(numberList.split(" "))));
    }
}
