package BitManipulation10.RemoveLastSetBit;

public class removeLastSetBit {
    public static void main(String[] args) {
        int n = 15;
        System.out.println("Original number : " + n);
        int result = (n & (n - 1));
        System.out.println(result);
    }
}
