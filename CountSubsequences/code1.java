public class CountSubsequences {
    public static int count(int[] arr, int sum, int target, int n, int i) {
        if (sum == target) {
            return 1;
        }
        if (sum > target || i == n) {
            return 0;
        }
        int l = count(arr, sum + arr[i], target, n, i + 1);
        int r = count(arr, sum, target, n, i + 1);
        return l + r;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 10, 5, 1, 3 };
        int n = arr.length;
        int target = 5;
        System.out.println(count(arr, 0, target, n, 0));
    }
}
