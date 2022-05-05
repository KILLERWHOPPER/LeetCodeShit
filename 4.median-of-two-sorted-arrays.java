/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0; // nums1 index
        int j = 0; // nums2 index
        int k = 0;
        int midPosition = (nums1.length + nums2.length) / 2;
        int[] merged = new int[midPosition + 1];
        boolean needMean = (nums1.length + nums2.length) % 2 == 1 ? false : true;
        while (k<merged.length && i < nums1.length && j < nums2.length) {
            merged[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        if(i==nums1.length&&nums1.length<=merged.length){
            while (k<merged.length&&j<nums2.length){
                merged[k++]=nums2[j++];
            }
        }else if(j==nums2.length&&nums2.length<=merged.length){
            while (k<merged.length&&i<nums1.length){
                merged[k++]=nums1[i++];
            }
        }
        if (needMean) {
            return (merged[midPosition] + merged[midPosition - 1]) / 2.0;
        }
        return merged[midPosition] + 0.0;
    }
}
// @lc code=end
