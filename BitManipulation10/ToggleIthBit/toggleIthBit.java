package BitManipulation10.ToggleIthBit;

public class toggleIthBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        System.out.println("Original number : " + n);
        int result = (n ^ (1 << i));
        System.out.println("Number after toggling the bit : " + result);
        int r = (result ^ (1 << i));
        System.out.println("Number after toggling the bit again : " + r);
    }
}
