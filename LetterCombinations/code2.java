class Solution {
    static Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi",
        '5', "jkl", '6', "mno", '7', "pqrs",
        '8', "tuv", '9', "wxyz"
    );

    void backtrack(int ind, String digits, StringBuilder sb, List<String> ans) {
        if (ind == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(ind));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(ind + 1, digits, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        backtrack(0, digits, new StringBuilder(), ans);
        return ans;
    }
}
