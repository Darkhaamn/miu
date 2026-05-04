import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q4_FractionalKnapsack {

    static String[] names   = { "a", "b", "c", "d", "e" };
    static int[]    values  = { 25, 12, 24, 16, 28 };
    static int[]    weights = {  5,  6,  8,  2,  7 };
    static int      Wmax    = 20;

    public static void main(String[] args) {
        int n = names.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Double.compare(
                (double) values[b] / weights[b],
                (double) values[a] / weights[a]));

        double remaining = Wmax;
        double totalValue = 0.0;
        Map<String, Double> taken = new LinkedHashMap<>();

        for (int idx : order) {
            if (remaining == 0) break;
            String name = names[idx];
            int w = weights[idx];
            int v = values[idx];

            if (w <= remaining) {
                taken.put(name, 1.0);
                totalValue += v;
                remaining -= w;
                System.out.printf("Take all of %s   (w = %d, v = %d)   used = %.0f / %d, value = %.2f%n",
                        name, w, v, Wmax - remaining, Wmax, totalValue);
            } else {
                double frac = remaining / w;
                taken.put(name, frac);
                totalValue += frac * v;
                System.out.printf("Take %.2f of %s    (w = %d, v = %d)   used = %d / %d, value = %.2f%n",
                        frac, name, w, v, Wmax, Wmax, totalValue);
                remaining = 0;
            }
        }

        System.out.println();
        System.out.println("Selection: " + taken);
        System.out.println("Optimal fractional value = " + totalValue);
    }
}