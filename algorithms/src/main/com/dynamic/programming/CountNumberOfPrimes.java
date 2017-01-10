package com.dynamic.programming;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * @author nisheedh
 *
 */
public class CountNumberOfPrimes {

    /**
     * Sieve of erastenenus. Maintain a table of size n and
     * mark numbers which are non prime. Use square root trick
     * and multiple trick while marking.
     * @param n
     * @return
     */
    public int countPrimes(int n) {

        boolean pa[] = new boolean[n];
        for (int i = 2; i < n; ++i) {
            pa[i] = true;
        }

        for (int i = 2; i * i < n; ++i) {
            if (!pa[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                pa[j] = false;
            }

        }
        int count = 0;
        
        for (int i = 2; i < n ; ++i)  {
            if (pa[i]) {
                count++;
            }
        }
            
        return count;
    }
}
