package BitManipulation10.clearIthBit;

public class clearIthBit {
    public static void main(String[] args) {
        int n = 9;
        int i = 2;
        int result = (n & (~(1 << i)));
        System.out.println(result);
    }
}
