package snakelu.leetcode.algorithm;

/**
 * 数字类型题目
 * 
 * @author snakelu
 *
 */
public class NumCategory {

	/**
	 * 寻找多个数组合并后的中位数
	 * 
	 * 这个问题可以化解为将两个数组按顺序放到一个数组中 在一个数组中找中位数只需要知道数组长度即可
	 * 在一个数组中，数组长度为奇数取中间一个数，为偶数取中间两个数平均值
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
			return 0;
		}

		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] result = new int[len1 + len2];

		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < result.length; i++) {
			if (index1 >= len1) {
				result[i] = nums2[index2++];
				continue;
			}
			if (index2 >= len2) {
				result[i] = nums1[index1++];
				continue;
			}
			if (nums1[index1] < nums2[index2]) {
				result[i] = nums1[index1++];
			} else {
				result[i] = nums2[index2++];
			}
		}

		if (result.length % 2 == 0) {
			return (double) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
		} else {
			return result[result.length / 2];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = {};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
