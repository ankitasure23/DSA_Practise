class Solution {
    public static void generate(String st , List<String> list, int i , int j, int n) {
        if(st.length() == 2*n) {
            list.add(st);
            return ;
        }
        if(i < n) generate(st+"(",list,i+1,j,n);
        if(j < i) generate(st+")",list,i,j+1,n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("",list,0,0,n);
        return list;
    }
}

