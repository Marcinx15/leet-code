package top_interview_150.array

fun main() {
    merge(nums1 = intArrayOf(1, 2, 3, 0, 0, 0), m = 3, nums2 = intArrayOf(2, 5, 6), n = 3)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var nums1Index = m - 1
    var nums2Index = n - 1
    var resultIndex = m + n - 1

    while (nums1Index >= 0 && nums2Index >= 0) {
        if (nums2[nums2Index] >= nums1[nums1Index]) {
            nums1[resultIndex] = nums2[nums2Index]
            nums2Index--
        } else {
            nums1[resultIndex] = nums1[nums1Index]
            nums1Index--
        }
        resultIndex--
    }

    while (nums2Index >= 0) {
        nums1[resultIndex] = nums2[nums2Index]
        nums2Index--
        resultIndex--
    }
}