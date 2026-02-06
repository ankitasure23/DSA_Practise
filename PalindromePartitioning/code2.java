class Solution {
    public static void printSubStrings(List<String> l, List<List<String>> list, String input, int ind) {
      if(input.isEmpty()) {
        list.add(new ArrayList<>(l));
        return;
      } 
      if(ind >= input.length())
        return;
      String st = input.substring(0,ind+1);
      if(checkPalindrome(st, 0, ind) == true) {
        l.add(st);
        printSubStrings(l,list,input.substring(ind+1),0);
        l.remove(l.size()-1);
      }
      printSubStrings(l,list,input,ind+1);
    }

    public static boolean checkPalindrome(String st, int i, int j) {
        while(i<j) {
            if(st.charAt(i) != st.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        printSubStrings(new ArrayList<>(), list,s,0);
        return list;
    }
}
