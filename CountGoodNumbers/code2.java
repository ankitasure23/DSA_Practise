Iterative solution 
class Solution {
    static final long MOD = 1000000007;
    public static long choice(long ch,long pos) {
        long answer = 1;
        while(pos > 0) {
            if(pos%2 == 1) {
                answer = (answer*ch) % MOD;
                pos -= 1;
            }
            else {
                ch = (ch*ch) % MOD;
                pos = pos/2; 
            }
        }
        return answer;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        return ((int)((choice(5,even)*choice(4,odd))%MOD));
    }
}
