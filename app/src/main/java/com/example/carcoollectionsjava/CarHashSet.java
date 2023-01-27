package com.example.carcoollectionsjava;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CarHashSet implements CarSet {

    private Map<Car,Object> map = new HashMap<>();
    private Object object = new Object();

    @Override
    public boolean add(Car car) {
        if (map.containsKey(car)){
            return false;
        }
        map.put(car, object);
        return true;
            }
    public Iterator<Car> iterator(){
        return map.keySet().iterator();
    }


    @Override
    public boolean remove(Car car) {
   Object removed = map.remove(car);
   return removed!=null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Car car) {
        return map.containsKey(car);
    }


}
