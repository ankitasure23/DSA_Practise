package Recursion;

import java.util.*;

public class BinaryStrings {
    public static void generateBinaryStrings(int n, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        generateBinaryStrings(n - 1, str + "0");
        if (str.isEmpty() || str.charAt(str.length() - 1) != '1') {
            generateBinaryStrings(n - 1, str + "1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateBinaryStrings(n, "");
    }
}
