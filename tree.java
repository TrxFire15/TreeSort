import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.List;


public class tree {

node root;

public tree() {
        root = null;
}

public void insert(int key) {
        root = insertRec(root, key);
}

public node insertRec(node root, int key) {
        if (root == null) {
                root = new node(key);
                return root;
        }
        if (key <= root.key) {
                root.left = insertRec(root.left, key);// >= equals values
        } else if (key >= root.key) {
                root.right = insertRec(root.right, key);
        }
        return root;
}

public void inOrdRec(node root) {
        if (root != null) {
                inOrdRec(root.left);
                list.add(root.key);
                inOrdRec(root.right);
        }
}

public void treeInsert(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
                insert(arr[i]);
        }

}
public static int[] fill(){
        System.out.println("Enter the number of numbers to enter: ");
        int [] array = new int [sc.nextInt()];
        System.out.println("Enter the numbers: ");
        array = IntStream.range(0, array.length).map(i -> sc.nextInt()).toArray();
        return array;
}


public int [] arrayListToArray(){
        int [] arr = new int[list.size()];
        for (int i =0; i < list.size(); i++) {
                arr[i] = list.get(i);
        }

        for (int j =0; j < arr.length; j++ ) {
                System.out.print(arr[j] + " ");
        }
        return arr;
}

public int binarySearch(int[] matrix, int value) {
        if (matrix.length == 0) {
                return -1;
        }
        int half = 0;
        int lower = 0;
        int higher = matrix.length -1;
        do {
                half = (lower + higher) / 2;
                if (value > matrix[half]) {
                        lower = half + 1;
                } else {
                        higher = half -1;
                }
        } while (matrix[half] != value && lower <= higher);

        if (matrix[half] == value) {
                return half;
        } else {
                return -1;
        }

}

public static void main(String[] args) {
        tree tree = new tree();
        int arr[] = fill();
        tree.treeInsert(arr);

        System.out.println("Ordered by TreeSort");
        tree.inOrdRec(tree.root);
        arr = tree.arrayListToArray();

        System.out.println("\n¿Which value do you want to find?");
        int n = tree.binarySearch(arr,sc.nextInt());

        System.out.println(n>=0?"Exists in # "+ (n+1):"Doesn't Exists");

}
public static Scanner sc  = new Scanner(System.in);
public static ArrayList<Integer> list = new ArrayList<Integer>();
}
