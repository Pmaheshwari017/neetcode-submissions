class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] A = nums1;
        int[] B = nums2;
        int n = A.length;
        int m = B.length;

        int total = n + m;
        int half = total / 2;

        int left = 0;
        int right = n;

        while (true) {
            int i = left + (right - left) / 2;
            int j = half - i;

            int Aleft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < n) ? A[i] : Integer.MAX_VALUE;
            int Bleft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < m) ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }
}
