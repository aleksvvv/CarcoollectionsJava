package com.example.carcoollectionsjava;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class CarHashSet implements CarSet {



    @Override
    public boolean add(Car car) {
        if (size >= array.length * 0.75){
            increaseArray();
        }
        boolean added = add(car,array);
        if (added){
            size++;
        }
        return added;
            }
    public boolean add(Car car, Entry[] dst){
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            Entry newEntry = new Entry(car, null);
            dst[position] = newEntry;

            return true;
        } else {
            Entry lastEntry = dst[position];
            while (true) {
                if (lastEntry.value.equals(car)) {
                    return false;
                } else if (lastEntry.next == null) {
                    lastEntry.next = new Entry(car, null);
                                        return true;
                }
                lastEntry = lastEntry.next;
            }
        }
    }

    @NonNull
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int arrayIndex;
            Entry entry;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
           while (array[arrayIndex] == null){
               arrayIndex++;
           }
           if (entry == null) {
               entry = array[arrayIndex];
           }
           Car result = entry.value;
           entry = entry.next;
           if (entry == null){
               arrayIndex++;
           }
           index++;
           return result;

            }
        };
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null){
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;

        if (array[position].value.equals(car)){
            array[position] = last;
            size--;
            return true;
        }
while (last!=null) {
    if (last.value.equals(car)) {
        secondLast.next = last.next;
        size--;
        return true;
    } else {
        secondLast = last;
        last = last.next;
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

    @Override
    public boolean contains(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null){
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;

        if (array[position].value.equals(car)){
            return true;
        }
        while (last!=null) {
            if (last.value.equals(car)) {
                return true;
            } else {
                last = last.next;
            }
        }
        return false;
    }

    private int getElementPosition(Car car, int size) {
        return Math.abs(car.hashCode() % size);
    }
    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for(Entry entry: array){
            Entry existedEntry = entry;
            while (existedEntry!=null){
                add(existedEntry.value,newArray);
                existedEntry = existedEntry.next;
            }
        }
        array = newArray;
    }

    private class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
