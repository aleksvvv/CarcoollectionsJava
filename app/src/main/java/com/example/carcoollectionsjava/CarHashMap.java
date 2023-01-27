package com.example.carcoollectionsjava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {
    private static final int INITIAL_CAPACITY = 16;
    private static final double RR_CAPACITY = 0.77;

    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= array.length *RR_CAPACITY ) {
            increaseSize();
        }
        boolean added = put(key, value, array);
        if (added) {
            size++;
        }
    }

    private boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        Entry existingElement = dst[position];
        if (existingElement == null) {
            Entry entry = new Entry(key, value, null);
            dst[position] = entry;

            return true;
        } else {
            while (true) {
                if (existingElement.key.equals(key)) {
//                    existingElement.value = value;
                    dst[position].value = value;
                    return false;
                }
                if (existingElement.next == null) {
                    existingElement.next = new Entry(key, value, null);

                    return true;
                } else {
                    existingElement = existingElement.next;
                }
            }
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry entry = array[position];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> carOwners = new HashSet<>();
        for (Entry entry : array) {
            Entry existentElement = entry;
            while (existentElement != null) {
                carOwners.add(existentElement.key);
                existentElement = existentElement.next;
            }
        }
        return carOwners;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<>();
        for (Entry entry : array) {
            Entry existentElement2 = entry;
            while (existentElement2 != null) {
                result.add(existentElement2.value);
                existentElement2 = existentElement2.next;
            }
        }

        return result;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existingElement = array[position];
        if (existingElement != null && existingElement.key.equals(key)) {
            array[position] = existingElement.next;
            size--;
            return true;
        } else {
            while (existingElement != null) {
                Entry next = existingElement.next;
                if (next == null) {
                    return false;
                }
                if (next.key.equals(key)) {
                    existingElement.next = next.next;
                    size--;
                    return true;
                }
                existingElement = next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;

    }

    private void increaseSize() {
        Entry[] newArray = new Entry[INITIAL_CAPACITY * 2];
        for (Entry entry : array) {
            Entry existentElement = entry;
            while (existentElement != null) {
                put(existentElement.key, existentElement.value, newArray);
                existentElement = existentElement.next;
            }

        }
        array = newArray;
    }

    private int getElementPosition(CarOwner key, int size) {
        return Math.abs(key.hashCode() % size);
    }

    static class Entry {
        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
