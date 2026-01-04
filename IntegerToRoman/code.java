import java.util.*;
class Solution {
    public static boolean powerof10(int num) {
        while(num %10 == 0) {
            num /= 10;
        }
        return num == 1;
    }
    public static String intToRoman(int num) {
        TreeMap<Integer,Character> roman = new TreeMap<>();
        roman.put(1,'I');
        roman.put(5,'V');
        roman.put(10,'X');
        roman.put(50,'L');
        roman.put(100,'C');
        roman.put(500,'D');
        roman.put(1000,'M');
        int len = Integer.toString(num).length() - 1;
        StringBuilder ans = new StringBuilder();

        while(len >= 0 && num != 0) {
            int ten = (int)(Math.pow(10,len));
            if(num < ten) ten = (int)Math.pow(10,Integer.toString(num).length()-1);
            int b = (num / ten)*ten;
            num = num - b;
            String str = Integer.toString(b);
            int k = roman.floorKey(b);
            if(str.startsWith("4") || str.startsWith("9")) {
                int key = roman.ceilingKey(b);
                int less = key - b;
                ans = ans.append(roman.get(less));
                ans = ans.append(roman.get(key));
            }
            else if(powerof10(k) == true) {
                int d = b / k;
                for(int i=1;i<=d;i++) {
                    ans = ans.append(roman.get(k));
                }
            }
            else if(!(str.startsWith("4") || str.startsWith("9")) && powerof10(k) == false) {
                while(b != 0) {
                    k = roman.floorKey(b);
                    ans = ans.append(roman.get(k));
                    b -= k;
                }
            }
            len--;
        }
        
        return ans.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String ans = intToRoman(num);
        System.out.println(ans);
    }
}
