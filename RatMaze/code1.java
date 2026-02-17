Time complexity : O(4^n^2)
Space Complexity : O(n^2)

  
import java.util.*;

public class RatMaze {
    public static void traverseMaze(int[][] input, StringBuilder ans, List<String> list, boolean[][] check, int row,
            int col) {
        if (row == input.length - 1 && col == input.length - 1) {
            String str = ans.toString();
            list.add(str);
            return;
        }
        if (row < 0 || row >= input.length || col < 0 || col >= input.length || check[row][col] == true
                || input[row][col] == 0)
            return;
        check[row][col] = true;
        traverseMaze(input, ans.append("D"), list, check, row + 1, col);
        ans.deleteCharAt(ans.length() - 1);
        traverseMaze(input, ans.append("R"), list, check, row, col + 1);
        ans.deleteCharAt(ans.length() - 1);
        traverseMaze(input, ans.append("U"), list, check, row - 1, col);
        ans.deleteCharAt(ans.length() - 1);
        traverseMaze(input, ans.append("L"), list, check, row, col - 1);
        ans.deleteCharAt(ans.length() - 1);
        check[row][col] = false;
    }

    public static void main(String[] args) {
        int[][] input = {
                { 1, 1, 1, 0, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 1 }
        };

        List<String> list = new ArrayList<>();
        boolean[][] check = new boolean[input.length][input[0].length];
        traverseMaze(input, new StringBuilder(), list, check, 0, 0);
        System.out.println(list);
    }
}
