package binarysearchtree;

public class BSTDemo {

    public static void main(String[] args) throws Exception {
        BST<Integer> b = new BST<>();
//        b.insert(8);
//        b.insert(3);
//        b.insert(10);
//        b.insert(1);
//        b.insert(6);
//        b.insert(14);
//        b.insert(4);
//        b.insert(7);
//        b.insert(13);
        b.inserts2(8, 3, 10, 1, 6, 14, 4, 7, 13);
        b.delete(8);
        b.show();
    }
}
