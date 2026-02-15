class Solution {
    public boolean isSafe(int row, int col, int n, char[][] board) {
        for(int i=0;i<n;i++) {
            if(board[row][i] == 'Q')
                return false;
        }
        int j = col;
        for(int i=row-1;i>=0;i--) {
            j--;
            if(j>=0 && board[i][j] == 'Q') 
                return false;
        }
        j = col;
        for(int i=row+1;i<n;i++) {
            j++;
            if(j<n && board[i][j] == 'Q')
                return false;
        }
        j = col;
        for(int i=row-1;i>=0;i--) {
            j++;
            if(j<n && board[i][j] == 'Q') 
                return false;
        }
        j = col;
        for(int i=row+1;i<n;i++) {
            j--;
            if(j>=0 && board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    public void solve(int col, int n, char[][] board, List<List<String>> list) {
        if(col == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                temp.add(new String(board[i]));
            }
            list.add(temp);
            return;
        }
        for(int row=0;row<n;row++) {
            if(isSafe(row,col,n,board)) {
                board[row][col] = 'Q';
                solve(col+1,n,board,list);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++) {
            Arrays.fill(board[i],'.');
        }
        solve(0,n,board,list);
        return list;
    }
}
