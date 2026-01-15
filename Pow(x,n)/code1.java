class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE)
            return 1 / (x * myPow(x, Integer.MAX_VALUE));
        if(n == 0) 
            return 1.0;
        else if(Math.abs(n) % 2 == 0) {
            if(n < 0)  {
                return (1/myPow(x*x,Math.abs(n)/2));
            }
            return (myPow(x*x,Math.abs(n)/2));
        }
        else {
            if(n < 0)
                return (1/(x * myPow(x,Math.abs(n)-1)));
            return (x * myPow(x,Math.abs(n)-1));
        }
    }
}
