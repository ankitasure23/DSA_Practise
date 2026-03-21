package DSA_Practise.BitManipulation10.OddOrEven;

public class checkOddOrEven {
    public static void main(String[] args) {
        int n = 5050;
        if ((n & 1) == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
