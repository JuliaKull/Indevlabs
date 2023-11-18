package com.kull.indevlabs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kull.indevlabs.IndevlabsApplication.findMissingNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class IndevlabsApplicationTests {


    @Test
    public void testFindMissingNumber_ContainsZero() {
        int[] arr = {0, 1, 2, 3, 5};
        assertEquals(4, findMissingNumber(arr));
    }

    @Test
    public void testFindMissingNumber_NotContainsZero() {
        int[] arr = {1, 2, 3, 5};
        assertEquals(4, findMissingNumber(arr));
    }

    @Test
    public void testFindMissingNumber_OnlyNaturalValues() {
        int[] arr = {1, 2, 3, 5};
        assertEquals(4, findMissingNumber(arr));
    }

    @Test
    public void testFindMissingNumber_NoAllowNegativeValues() {
        int[] arr = {-1, 2, 3, 5};
        assertThrows(IllegalArgumentException.class, () -> findMissingNumber(arr));
    }

}
