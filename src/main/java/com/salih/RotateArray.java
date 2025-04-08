package com.salih;


public class RotateArray {
    /*
    Problem: Rotate an array of n elements to the right by k steps.
    For example, with n= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
    How many different ways do you know to solve this problem?
     */

    public static void main(String[] args) {

        int n = 7;

        int k = 3;

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

        // Measure time for rotateUsingBubbleSort
        int[] nums3 = nums.clone();
        startTime = System.nanoTime();
        rotateUsingBubbleSort(nums3, k);
        endTime = System.nanoTime();
        System.out.println("Rotated using bubble sort: " + java.util.Arrays.toString(nums3));
        System.out.println("Time taken (bubble sort): " + (endTime - startTime) + " ns");
    }

    public static void rotateUsingExtraArray(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        //result: [5, 6, 7, 0, 0, 0, 0]
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

    public static void rotateUsingBubbleSort(int[] nums, int k) {
        k=k%nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

}