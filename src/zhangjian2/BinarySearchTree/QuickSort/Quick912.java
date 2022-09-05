package zhangjian2.BinarySearchTree.QuickSort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author CXWWH
 * @create 2022-07-08-7:10
 * @
 **/
public class Quick912 {

    int count = 0;
    public int[] sortArray(int[] nums) {

        shuffle(nums);
        sort(nums,0, nums.length-1);
        return nums;
    }

    public void sort(int[] nums, int lo, int hi){

        //闭区间[lo,hi]中如果没有或者只有一个元素，那么无需排序
        if( lo >= hi){

            return;
        }

        int p = partition(nums, lo, hi);

        sort(nums, lo, p-1);
        sort(nums, p+1, hi);
    }

    public int partition(int[] nums, int lo, int hi){

        count++;
        int pivot = nums[lo];

        // 把i j 定义为开区间
        // [lo, i)中的元素都要小于等于pivot
        // (j, hi]中的元素都要大于pivot
        int i = lo + 1;
        int j = hi;

        //当 i > j 的时候结束循环，保证覆盖整个[lo, hi]闭区间
        //退出循环的时候：nums[i-1] <= pivot  nums[j+1] > pivot
        while( i <= j){

            //极端情况，如果i增加到了hi，那么就会退出
            //下面的while循环会处理nums[hi]这种情况
            while( i < hi && nums[i] <= pivot){

                i++;
            }

            //极端情况，如果j减小到了lo,那么正好不做改变
            // (lo+1, hi]中的元素都大于pivot
            // nums[lo] = pivot
            while( j > lo && nums[j] > pivot){

                j--;
            }

            if( i >= j){//此时覆盖整区个[lo, hi]闭区间

                break;
            }

            //走到这里，说明 i < j
            //并且nums[i] > pivot   nums[j] <= pivot
            //此时就需要交换i j 处的元素
            swap(nums, i, j);
        }

        //此时退出了上面的while大循环
        // i > j
        // [lo+1,i-1) <= pivot
        // (j+1,hi] > pivot
        //现在需要将pivot放到合适的位置,也就是j处
        swap(nums, lo, j);
        System.out.println("i = " + i + "  j = " + j);
        return j;
    }

    public void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void shuffle(int[] nums){

        int n = nums.length;
        Random rand = new Random();
        for(int i = 0; i < n; i++){

            int j = i + rand.nextInt(n-i);
            swap(nums, i,j);
        }
    }

    @Test
    public void test(){

        int[] nums = {4,1,2,3,6,5,8};
        int[] sortArray = sortArray(nums);
        System.out.println(Arrays.toString(sortArray));
        System.out.println(count);
    }
}
