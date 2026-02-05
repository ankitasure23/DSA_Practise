class Solution {
    public static void combinations(HashMap<Character,String> map, List<String> ans, String     digits, StringBuilder str,int ind, int i) {
        if(str.length() == digits.length()) {
            ans.add(str.toString());
            return;
        }
        String st = map.get(digits.charAt(ind));
        if(i >= st.length()) 
            return;
        str.append(st.charAt(i));
        combinations(map,ans,digits,str,ind+1,0);
        str.deleteCharAt(str.length()-1);
        combinations(map,ans,digits,str,ind,i+1);
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) {
            ans.add("");
            return ans;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        combinations(map,ans,digits,new StringBuilder(),0,0);
        return ans;
    }
}
