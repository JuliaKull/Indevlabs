package com.kull.indevlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


public class IndevlabsApplication {

    public static int findMissingNumber(int[] arr) {
        if (!ifAllValuesPositive(arr)) { //check if the array contain only positive values
            throw new IllegalArgumentException("Array must contain only positive values.");
        }
        int n, expectedSum;
        if (ifContainsZero(arr)) {  //check if the array contain 0 value
            n = arr.length;         //find the length of the array
        } else {
            n = arr.length + 1;     //if the array does not contain 0, need to add 1 to the length of the array for the missing number in the series.
        }
        expectedSum = n * (n + 1) / 2;             // the formula for the sum of consecutive integers
        int actualSum = Arrays.stream(arr).sum(); //find sum of all values in the array
        return expectedSum - actualSum;            //return missing value;
    }


    private static boolean ifContainsZero(int[] arr) {
        return Arrays.stream(arr).boxed().anyMatch(i -> i == 0);
    }

    private static boolean ifAllValuesPositive(int[] arr) {
        return Arrays.stream(arr).boxed().allMatch(i -> i >= 0);
    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 0};
        System.out.println(findMissingNumber(arr));
    }
}
