package BitManipulation10.checkIthBit;

public class checkIthBit {
    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        // using left shift
        int bitMaskLeft = (n & (1 << i));
        int bitMaskRight = ((n >> i) & 1);
        if (bitMaskLeft != 0)
            System.out.println("The bit is set");
        else
            System.out.println("The bit is not set");

        if (bitMaskRight == 1)
            System.out.println("The bit is set");
        else
            System.out.println("The bit is not set");
    }
}
