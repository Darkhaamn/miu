package prob3;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrimeStream {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int nextPrime(int current) {
        int next = current + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    private final Stream<Integer> primes =
            Stream.iterate(2, PrimeStream::nextPrime);

    private final Supplier<Stream<Integer>> primeSupplier =
            () -> Stream.iterate(2, PrimeStream::nextPrime);

    public void printFirstNPrimes(long n) {
        primeSupplier.get()
                .limit(n)
                .forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();

        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}