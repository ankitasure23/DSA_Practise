package DSA_Practise.BitManipulation10.power;

public class powerOf2 {
    public static void main(String[] args) {
        int n = 18;
        if ((n & (n - 1)) == 0)
            System.out.println("Power Of two");
        else
            System.out.println("Not a power of two");
    }
}
