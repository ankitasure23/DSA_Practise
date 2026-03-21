package BitManipulation10.DivideWithoutOperators;

public class Solution {
    public int divide(int dividend, int divisor) {
        long quotient = 0;
        if (dividend == divisor)
            return 1;
        if (divisor == 0)
            return -1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = true;
        if (dividend >= 0 && divisor <= 0)
            sign = false;
        if (dividend <= 0 && divisor >= 0)
            sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        divisor = Math.abs(divisor);

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1)))
                count++;
            quotient += (1 << count);
            n -= (d << count);
        }

        if (quotient == (1 << 31) && sign)
            return Integer.MAX_VALUE;
        if (quotient == (1 << 31) && !sign)
            return Integer.MIN_VALUE;
        return (sign == true) ? (int) quotient : (int) -quotient;
    }
}
