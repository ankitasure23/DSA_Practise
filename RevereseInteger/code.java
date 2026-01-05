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



Approach:
Initialize an integer num = 0 to store the reversed number.
Iterate through the digits of x using a loop:
Extract the last digit: digit = x % 10.
Remove the last digit from x: x /= 10.
Check for overflow before updating num:
If num > Integer.MAX_VALUE / 10 or (num == Integer.MAX_VALUE / 10 && digit > 7), return 0.
If num < Integer.MIN_VALUE / 10 or (num == Integer.MIN_VALUE / 10 && digit < -8), return 0.
If the num is already greater tha than MAX/10 then no matter whatever digit we add at the end it will result in a value greater than MAX/10 and vice versa 
Update the reversed number: num = num * 10 + digit.
Return the final reversed number.
    
Time Complexity: O(d) — where d is the number of digits in x.
Space Complexity: O(1) — only constant extra space is used.
