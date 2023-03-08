package lianXi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://leetcode.cn/circle/article/kiHnKs/
 */
public class QuickSortBetterVersion {
    public static void main(String[] args) {
        // 调用
        int[] nums = { 4, 1, 3, 2, 5 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    /**
     * 优化版本
     */
    static int partition(int[] nums, int l, int r) {
        // 在闭区间 [l, r] 随机选取任意索引，并与 nums[l] 交换
        int ra = (int)(l + Math.random() * (r - l + 1));
        swap(nums, l, ra);
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            //从右向左 查找首个小于基准数的值
            while (i < j && nums[j] >= nums[l]) j--;
            //从左向右 查找首个大于基准数的值
            while (i < j && nums[i] <= nums[l]) i++;
            //交换arr[i]和arr[j]
            swap(nums, i, j);
        }
        //交换基准数 和 两个哨兵相遇位置的值
        swap(nums, i, l);
        //执行完毕后左数组所有数字<=基准数  右数组所有数字>=基准数
        return i;
    }



    /*static int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }*/

    static void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
