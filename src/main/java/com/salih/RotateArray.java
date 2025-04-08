package com.salih;

import java.util.Scanner;

import static java.util.Collections.reverse;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of steps to rotate: ");
        int k = scanner.nextInt();

        //generate array
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }

        System.out.println("Original array: " + java.util.Arrays.toString(nums));

        // Measure time for rotateUsingExtraArray
        int[] nums1 = nums.clone();
        long startTime = System.nanoTime();
        rotateUsingExtraArray(nums1, k);
        long endTime = System.nanoTime();
        System.out.println("Rotated using extra array: " + java.util.Arrays.toString(nums1));
        System.out.println("Time taken (extra array): " + (endTime - startTime) + " ns");

        // Measure time for rotateUsingReversal
        int[] nums2 = nums.clone();
        startTime = System.nanoTime();
        rotateUsingReversal(nums2, k);
        endTime = System.nanoTime();
        System.out.println("Rotated using reversal algorithm: " + java.util.Arrays.toString(nums2));
        System.out.println("Time taken (reversal algorithm): " + (endTime - startTime) + " ns");
    }

    public static void rotateUsingExtraArray(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        System.out.println("result: " + java.util.Arrays.toString(result));
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }

    public static void rotateUsingReversal(int[] nums, int k) {

        k=k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }




}