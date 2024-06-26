package ru.gb.algorithms.seminars.seminar_04.red_black_tree;

/**
 * Красно-чёрное дерево.
 * Каждая нода имеет свой цвет(красный или черный).
 * Корень дерева всегда чёрный.
 * Новая нода всегда красная.
 * Красные ноды могут быть только левым ребёнком.
 * У красной ноды все дети чёрного цвета.
 */
public class Tree {
    Node root;

    /**
     * Узел, который хранит элемент.
     */
    class Node {
        int value;
        Node left;
        Node right;
        Color color;
    }

    /**
     * Цвета узлов дерева
     */
    enum Color {
        BLACK,
        RED
    }

    // Метод вставки элемента в дерево.
    public void insert(int value) {
        if (root != null) {
            insert(root, value);
            root = balance(root);
        } else {
            root = new Node();
            root.value = value;
        }
        root.color = Color.BLACK;
    }

    // Метод вставки элемента в дерево
    // node - узел в который мы пришли.
    // value - элемент, который собираемся вставить.
    private void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                } else {
                    insert(node.right, value);
                    node.right = balance(node.right);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                } else {
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    // Метод поиска элемента
    public Node find(int value) {
        return find(root, value);
    }

    // Метод поиска элемента
    private Node find(Node node , int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }

    // Метод осуществляет левосторонний поворот.
    private Node leftRotate(Node node) {
        Node cur = node.right;
        node.right = cur.left;
        cur.left = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    // Метод осуществляет правосторонний поворот.
    private Node rightRotate(Node node) {
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    // Меняет цвет узла
    private void swapColors(Node node) {
        node.color = (node.color == Color.RED ? Color.BLACK : Color.RED);
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    // Метод выполняющий балансировку дерева
    private Node balance(Node node) {
        boolean flag;
        Node cur = node;
        do {
            flag = false;

            if (cur.right != null && cur.right.color == Color.RED &&
                    (cur.left == null || cur.left.color == Color.BLACK)) {
                cur = leftRotate(cur);
                flag = true;
            }

            if (cur.left != null && cur.left.color == Color.RED &&
                    cur.left.left != null && cur.left.left.color == Color.RED) {
                cur = rightRotate(cur);
                flag = true;
            }

            if (cur.left != null && cur.left.color == Color.RED &&
                    cur.right != null && cur.right.color == Color.RED) {
                swapColors(cur);
                flag = true;
            }
        } while (flag);
        return cur;
    }
}
