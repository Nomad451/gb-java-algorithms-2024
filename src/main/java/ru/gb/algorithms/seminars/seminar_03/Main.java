package ru.gb.algorithms.seminars.seminar_03;

class List {
    Node head; // ссылка на начало(головной элемент списка)
    Node tail;

    class Node {
        int value; // хранит значение элемента
        Node next; // следующий элемент по порядку
        Node previous; // предыдущий элемент
    }

    // Добавление элемента в начало
    public void pushFront(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
        }
        head = node;
    }

    // Удаление элемента из начала
    public void popFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        }
    }

    // Выводит все элементы списка
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    // Поиск элемента
    public boolean consist(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Добавление элемента в конец списка
    public void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }

    // Удаление элемента из конца списка
    public void popBack() {
        if (tail != null) {
            if (tail.previous == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
            }
        }
    }

    // Пузырьковая сортировка
    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.previous;
                    Node current = node;
                    Node next = node.next;
                    Node after = node.next.next;

                    current.previous = next;
                    current.next = after;
                    next.previous = before;
                    next.next = current;

                    if (before != null) {
                        before.next = next;
                    } else {
                        head = next;
                    }

                    if (after != null) {
                        after.previous = current;
                    } else {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }
}

public class Main {
    public static void main(String[] args) {
        // Список работает по принципу LIFO - last in first out(первым пришел, последним ушел)
        // Это принцип работы стека
//        List list = new List();
//        for (int i = 1; i <= 5; i++) {
//            list.pushFront(i);
//        }
//        list.print();

//        list.popFront();
//        list.popFront();

//        list.print();

//        System.out.println(list.consist(2));
//        System.out.println(list.consist(4));
//
//        list.pushBack(7);
//        list.print();
//        list.popBack();
//        list.print();

        List list = new List();
        for (int i = 10; i >= 1; i--) {
            list.pushBack(i);
        }

        list.sort();
        list.print();
    }
}
