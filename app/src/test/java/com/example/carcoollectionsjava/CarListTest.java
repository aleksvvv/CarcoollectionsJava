package com.example.carcoollectionsjava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;

public class CarListTest {
    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdding100ElementsThenSize100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemoteElementByIdThenSizeDecrease() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenRemoteElementThenSizeDecrease() {
        Car car = new Car("Ford", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemoteNotExistentThenFalse() {
        Car car = new Car("Ford", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetElementNotBoundsThenExpected() {
        carList.get(100);
    }

    @Test
    public void whenClearedThenSize0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenGetReturnedThenRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void whenAddingElementInMiddleThenSizeIncrease() {
        Car car = new Car("Ford", 1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("Ford", carFromList.getBrand());
        assertEquals(101, carList.size());
    }
    @Test
    public void whenAddingElementInStartThenSizeIncrease() {
        Car car = new Car("Ford", 1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("Ford", carFromList.getBrand());
        assertEquals(101, carList.size());
    }
    @Test
    public void whenAddingElementInEndThenSizeIncrease() {
        Car car = new Car("Ford", 1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("Ford", carFromList.getBrand());
        assertEquals(101, carList.size());
    }
    @Test
    public void whenContainsElementTheBoolean(){
       assertTrue(carList.contains(new Car("Brand1",1)));
       assertFalse(carList.contains(new Car("Brand200",200)));

    }

    }
