class Solution {
    public static int getNum(String s , int i , int sign , long num) {
        if(i >= s.length() || !Character.isDigit(s.charAt(i))) return (sign * (int) num);
        num = (num*10) + (s.charAt(i)-'0');
        if(sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return getNum(s,++i,sign,num); 
    }
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())
            return 0;
        int i = 0;
        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-')? -1 : 1;
            i++;
        }
        while(i<s.length() && s.charAt(i) == '0') i++;
        return getNum(s,i,sign,0L);
    }
}
