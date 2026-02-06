class Solution {
    public static void printSubStrings(List<String> l, List<List<String>> list, String input, int ind) {
      if(input.isEmpty()) {
        list.add(new ArrayList<>(l));
        return;
      } 
      if(ind >= input.length())
        return;
      String st = input.substring(0,ind+1);
      if(checkPalindrome(st) == true) {
        l.add(st);
        printSubStrings(l,list,input.substring(ind+1),0);
        l.remove(l.size()-1);
      }
      printSubStrings(l,list,input,ind+1);
    }

    public static boolean checkPalindrome(String st) {
        int i = 0;
        String str = "";
        while(i <= st.length()-1) {
            char ch = st.charAt(i);
            str = ch + str;
            i++;
        }
        if(st.equals(str))
            return true;
        else
            return false;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        printSubStrings(new ArrayList<>(), list,s,0);
        return list;
    }
}
