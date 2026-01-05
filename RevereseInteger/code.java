class Solution {
    public int reverse(int x) {
        long num = 0;
        int sign = 1;
        while(x != 0) {
            int rev = x % 10;
            num = num*10 + rev;
            x = x/10;
            if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) 
                return 0; 
        }
        return (int)num;
    }
}
