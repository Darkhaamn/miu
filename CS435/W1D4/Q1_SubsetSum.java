import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1_SubsetSum {

    // (a)	T or F.
    public static boolean exists(int[] S, int k) {
        int n = S.length;
        boolean[][] dp = new boolean[n + 1][k + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j]
                        || (j >= S[i - 1] && dp[i - 1][j - S[i - 1]]);
            }
        }
        return dp[n][k];
    }

    // (b)	One solution.
    public static List<Integer> oneSolution(int[] S, int k) {
        int n = S.length;
        boolean[][] dp = new boolean[n + 1][k + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j]
                        || (j >= S[i - 1] && dp[i - 1][j - S[i - 1]]);
            }
        }
        if (!dp[n][k]) return null;

        List<Integer> result = new ArrayList<>();
        int j = k;
        for (int i = n; i >= 1; i--) {
            if (!dp[i - 1][j] && j >= S[i - 1] && dp[i - 1][j - S[i - 1]]) {
                result.add(S[i - 1]);
                j -= S[i - 1];
            }
        }
        Collections.reverse(result);
        return result;
    }

    // (c)	All solutions.
    public static List<List<Integer>> allSolutions(int[] S, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(S, 0, k, new ArrayList<>(), results);
        return results;
    }

    private static void backtrack(int[] S, int i, int remaining,
                                  List<Integer> current,
                                  List<List<Integer>> results) {
        if (remaining == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        if (i == S.length || remaining < 0) return;

        current.add(S[i]);
        backtrack(S, i + 1, remaining - S[i], current, results);
        current.remove(current.size() - 1);

        backtrack(S, i + 1, remaining, current, results);
    }

    public static void main(String[] args) {
        int[] S = {2, 3, 5};
        int k = 8;

        System.out.println("S = " + Arrays.toString(S) + ", k = " + k);
        System.out.println("(a) T or F     : " + exists(S, k));
        System.out.println("(b) One subset : " + oneSolution(S, k));
        System.out.println("(c) All subsets: " + allSolutions(S, k));
    }
}