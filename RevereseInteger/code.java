class Solution {
    public int reverse(int x) {
        int num = 0;
        int sign = 1;
        while(x != 0) {
            int rev = x % 10;
            if(num > Integer.MAX_VALUE/10 || ((num == Integer.MAX_VALUE) && rev > 7))
                return 0;
            else if(num < Integer.MIN_VALUE/10 || ((num == Integer.MIN_VALUE) && rev < -8))
                return 0;
            num = num*10 + rev;
            x = x/10;
        }
        return num;
    }
}
