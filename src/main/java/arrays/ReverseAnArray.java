package arrays;

//GFG
//https://practice.geeksforgeeks.org/problems/reverse-an-array/0
//        Given an array A of size N, print the reverse of it.
//
//        Example:
//
//        Input:
//        1
//        4
//        1 2 3 4
//        Output:
//        4 3 2 1

import java.util.Scanner;

public class ReverseAnArray {

    public int[] reverseArray(int size, int[] arr) {
        int[] reversedArray = new int[size];
        int lastIndex = size - 1;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            reversedArray[currentIndex] = arr[lastIndex--];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
            int[] reversedArray = new ReverseAnArray().reverseArray(size, arr);
            for (int i = 0; i < size; i++) {
                System.out.print(reversedArray[i] + " ");
            }
            System.out.println();
        }
    }
}
