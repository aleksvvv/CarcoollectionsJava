package com.example.carcoollectionsjava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarMapTest {
    CarMap map;

    @Before
    public void setUp() throws Exception {
        map = new CarHashMap();
//        init

    }
    @Test
    public void whenPut100ElementsThenSize100(){
        for (int i = 0; i<100; i++ ){
            map.put(new CarOwner(i,"Name"+i,"LastName"+i),
                    new Car("Brand"+i,i));
        }
        assertEquals(100,map.size());
    }
    @Test
    public void when100ElementWith10DifferentThenSize10(){
        for (int i=0; i<100; i++){
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index,"Name"+index,"LastName"+index);
            Car car = new Car("Brand"+index,index);
            map.put(carOwner,car);
        }
        assertEquals(10,map.size());
    }
    @Test
    public void whenRemoveElementThenSizeIncrease(){
        for (int i = 0; i<100; i++ ){
            map.put(new CarOwner(i,"Name"+i,"LastName"+i),
                    new Car("Brand"+i,i));
        }
        assertEquals(100,map.size());
        assertTrue(map.remove(new CarOwner(1,"Name"+1,"LastName"+1)));
      assertEquals(99,map.size());
      assertFalse(map.remove(new CarOwner(1,"Name"+1,"LastName"+1)));
    }
    @Test
    public void countSizeElementThenRightValue(){
        for (int i = 0; i<100; i++ ){
            map.put(new CarOwner(i,"Name"+i,"LastName"+i),
                    new Car("Brand"+i,i));
        }
        assertEquals(100,map.size());
        assertEquals(100,map.values().size());
        assertEquals(100,map.keySet().size());
    }
    @Test
    public void getElementThenRightValue(){
        for (int i = 0; i<100; i++ ){
            map.put(new CarOwner(i,"Name"+i,"LastName"+i),
                    new Car("Brand"+i,i));
        }
        CarOwner key = new CarOwner(1,"Name"+1,"LastName"+1);
        Car value = map.get(key);
        assertEquals("Brand1",value.getBrand());
    }
    @Test
    public void testClear(){
        for (int i = 0; i<100; i++ ){
            map.put(new CarOwner(i,"Name"+i,"LastName"+i),
                    new Car("Brand"+i,i));
        }
        map.clear();
        assertEquals(0,map.size());
    }
}