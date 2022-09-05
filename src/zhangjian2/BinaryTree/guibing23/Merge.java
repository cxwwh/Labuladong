package zhangjian2.BinaryTree.guibing23;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-06-30-9:58
 * @
 **/
public class Merge {

    public static int count = 0;
    int[] temp;
    public void sort(int[] nums){

        temp = new int[ nums.length];
        sort(nums, 0, nums.length-1);
    }

    //定义：对nums中索引为lo-hi的元素进行升序排序
    public void sort(int[] nums, int lo, int hi){

        //单个元素无需排序
        if( lo == hi){

            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort( nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi){

        count++;
        int i = lo;
        int j = mid+1;
        int index = lo;

        for(int m = lo; m <= hi; m++){

            temp[m] = nums[m];
        }
        while( (i <= mid) && (j <= hi)){

            if( temp[i] <= temp[j]){

                nums[index] = temp[i];
                index++;
                i++;
            }else{

                nums[index] = temp[j];
                index++;
                j++;
            }
        }

        while( i <= mid){

            nums[index] = temp[i];
            index++;
            i++;
        }

        while( j <= hi){

            nums[index] = temp[j];
            index++;
            j++;
        }
    }

    @Test
    public void test(){

        int[] nums = {1,4,2,6,9,4,5,6,3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println( Merge.count);
    }
}
