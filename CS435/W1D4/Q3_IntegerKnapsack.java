import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3_IntegerKnapsack {

    static String[] names   = { "a", "b", "c", "d", "e" };
    static int[]    values  = { 25, 12, 24, 16, 28 };
    static int[]    weights = {  5,  6,  8,  2,  7 };
    static int      Wmax    = 20;

    public static void main(String[] args) {
        int n = names.length;
        int[][] V = new int[n + 1][Wmax + 1];

        for (int i = 1; i <= n; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 0; j <= Wmax; j++) {
                if (j - w < 0) {
                    V[i][j] = V[i - 1][j];
                } else {
                    V[i][j] = Math.max(V[i - 1][j], V[i - 1][j - w] + v);
                }
            }
        }

        System.out.print("    ");
        for (int j = 1; j <= Wmax; j++) System.out.printf("%4d", j);
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(names[i - 1] + "  ");
            for (int j = 1; j <= Wmax; j++) System.out.printf("%4d", V[i][j]);
            System.out.println();
        }

        System.out.println("Maximum Value is " + V[n][Wmax]);

        List<String> taken = new ArrayList<>();
        int j = Wmax;
        int totalWeight = 0;
        for (int i = n; i >= 1; i--) {
            if (V[i][j] != V[i - 1][j]) {
                taken.add(names[i - 1]);
                totalWeight += weights[i - 1];
                j -= weights[i - 1];
            }
        }
        Collections.reverse(taken);
        System.out.println("Selected items: " + taken);
        System.out.println("Total weight  : " + totalWeight);
        System.out.println("Total value   : " + V[n][Wmax]);
    }
}