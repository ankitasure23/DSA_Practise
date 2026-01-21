class Solution {
    static final long MOD = 1000000007;
    public static long choice(long ch,long pos) {
        if(pos == 0) 
            return 1;
        else if(pos%2 == 0) 
            return choice((ch*ch)%MOD,pos/2);
        else if(pos%2 == 1)
            return (ch * choice(ch,pos-1))%MOD;
        else return 1;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        return ((int)((choice(5,even)*choice(4,odd))%MOD));
    }
}
