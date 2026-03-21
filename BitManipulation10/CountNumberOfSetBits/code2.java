package DSA_Practise.BitManipulation10.CountNumberOfSetBits;

class code2 {

    public static void main(String[] args) {
        int n = 16;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
    }
}