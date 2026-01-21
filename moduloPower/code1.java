class Solution {
    public static long power(long a , long n) {
        //System.out.println(a + " " + n);
        a %= 1337;
        if(n == 0) 
            return 1;
        else if(n%2 == 0)
            return power(a*a,n/2)%1337;
        else if(n%2 == 1)
            return (a*power(a,n-1))%1337;
        else 
            return 1;
    }
    public int superPow(int a, int[] b) {
        int result = 1;
        for(int i=0;i<b.length;i++) {
            result =((int)(power(result,10)) * ((int)(power(a,b[i])))) % 1337;
        }
        return result;
    }
}
