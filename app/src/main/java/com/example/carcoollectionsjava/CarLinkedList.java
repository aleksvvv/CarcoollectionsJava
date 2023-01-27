package com.example.carcoollectionsjava;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class CarLinkedList implements CarList,CarQueue {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @NonNull
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    @Override
    public boolean add(Car car) {
        if (size == 0) {
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public Car poll() {
        Car car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public Car peek() {
        if (size>0) {
            return get(0);
        }
        return null;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return  add(car);

        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        Node nodeDel = getNode(index);
        Node previousNode = nodeDel.previous;
        Node nextNode = nodeDel.next;
        if (previousNode != null) {
            previousNode.next = nextNode;
        } else {
            first = nextNode;
        }

        if (nextNode != null) {
            nextNode.previous = previousNode;
        } else {
            last = previousNode;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)){
                return true;
            }
            node = node.next;
                    }
        return false;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if ( index<0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car car, Node next) {
            this.previous = previous;
            this.value = car;
            this.next = next;
        }
    }
}
