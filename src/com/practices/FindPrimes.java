package com.practices;

import java.math.BigInteger;

public class FindPrimes {

    private static int[] findPrimes(int n) {
            int[] primes = new int[n];
            for (int i = 2; i< n; i++) primes[i] = i;
            for (int i = 2; i< n; i++) {
                for (int j = i * i; j < n; j+=i) {
                    primes[j] = 0;
                }
            }

            return primes;
        }

    private static int countPrimes (int[] primes) {
            int cnt = 0;
            for (int i : primes) {
                if (primes[i] != 0) cnt++;
            }

            return cnt;
        }

    private static int MOD = 1000000007;

    private static int numPrimeArrangements(int n) {
        int noOfPrime = countPrimes(findPrimes(n + 1));
        BigInteger x = factorial(noOfPrime);
        BigInteger y = factorial(n - noOfPrime);
        return x.multiply(y).mod(BigInteger.valueOf(MOD)).intValue();
    }

    private static BigInteger factorial(int n) {
            BigInteger fac = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                fac = fac.multiply(BigInteger.valueOf(i));
            }
            return fac.mod(BigInteger.valueOf(MOD));
        }

        public static void main(String[] args) {
            //System.out.println(Arrays.toString(findPrimes(50)));
            //System.out.println(countPrimes(findPrimes(50)));
            System.out.println(numPrimeArrangements(11));
        }

}
