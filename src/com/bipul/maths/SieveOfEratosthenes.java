package com.bipul.maths;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100;
        sievePrimeArray2(n);
    }

    //Bipul's implementation 2:
    //assuming false represents Prime and true represents that it is not prime (no need to set defaults here)
    private static void sievePrimeArray2(int n){
        boolean[] primes = new boolean[n+1];
        for(int i = 2; i*i<=n; i++){ //checking only till square root of the number
            if(!primes[i]){ //if prime is false - i.e., it hasn't been transformed to true yet
                for(int j = i*2; j<=n; j=j+i){
                    primes[j] = true;
                }
            }
        }

        for(int i = 2; i <= n; i++){
            if(!primes[i])
                System.out.print(i + ", ");
        }

    }

    //Bipul's implementation 1 (using isPrime function) - Problem: No need to use isPrime. Directly set the multiples as false
    //here we are also converting the booleans to true for defaults
    private static void sievePrimeArray1(int n){
        boolean[] primes = new boolean[n+1];
        for(int i = 2; i<primes.length; i++){
            primes[i] = true;
        }

        for(int i = 2; i*i<n; i++){
            if(primes[i] && isPrime(i)){
                for(int j = 2; j*i<primes.length; j++){
                  primes[j*i] = false; //setting the non-primes as false
                }
            }
        }

        for(int i=0; i<primes.length; i++) {
            System.out.println(i + ": " + primes[i]);
        }
    }

    private static boolean isPrime(int n){
        boolean isPrime = true;
        int i = 2;
        while(i*i <= n){
            if(n%i==0)
                isPrime = false;
            i++;
        }
        return isPrime;
    }

}
