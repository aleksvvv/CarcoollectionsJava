package com.example.carcoollectionsjava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CarSetTest {
    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdding3ElementsThenSizeNotChange() {
        assertEquals(100, carSet.size());
        Car car = new Car("Ford", 1);
        assertTrue(carSet.add(car));
        assertFalse(carSet.add(car));
        assertFalse(carSet.add(car));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenClearedThenSize0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenRemoveElementThenSizeDecreased() {
        Car car = new Car("Brand1", 1);
        assertTrue(carSet.remove(car));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(car));
        assertEquals(99, carSet.size());
    }
    @Test
    public void whenContainsElementTheBoolean(){
        Car car = new Car("Brand1", 1);
        assertTrue(carSet.contains(car));
       assertFalse(carSet.contains(new Car("Brand200",200)));

    }
}