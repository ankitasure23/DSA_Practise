package BitManipulation10.SetIthBit;

public class setIthBit {

    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        System.out.println(n | 0);
        int result = (n | (1 << i));
        System.out.println(result);
    }
}