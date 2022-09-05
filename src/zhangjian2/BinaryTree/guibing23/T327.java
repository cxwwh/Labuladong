package zhangjian2.BinaryTree.guibing23;

/**
 * @author CXWWH
 * @create 2022-07-01-11:05
 * @
 **/
public class T327 {

    int lower;
    int upper;
    int count = 0;
    long[] temp;

    public int countRangeSum(int[] nums, int lower, int upper) {

        this.lower = lower;
        this.upper = upper;
        temp = new long[ nums.length + 1];

        //构造前缀和数组
        //presum[i]为nums[0...i-1]的元素和
        //presum[j] - presum[i] 为nums[i...j-1]的元素和
        long[] presum = new long[ nums.length+1];
        for(int i = 0; i < nums.length; i++){

            presum[i+1] = presum[i] + (long)nums[i];
        }

        sort( presum, 0, presum.length-1);
        return count;
    }

    //定义：对nums中索引为lo-hi的元素进行升序排序
    public void sort(long[] nums, int lo, int hi){

        //单个元素无需排序
        if( lo == hi){

            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort( nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    public void merge(long[] nums, int lo, int mid, int hi){


        int i = lo;
        int j = mid+1;

        for(int m = lo; m <= hi; m++){

            temp[m] = nums[m];
        }

        int start = mid+1;
        int end = mid+1;
        //维护presum中索引为左闭右开区间[start,end)的元素 与 presum[m]的差在闭区间[lower,upper] 内
        for(int m = lo; m <= mid; m++){

            while( start <= hi && nums[start]-nums[m] < lower){

                start++;
            }

            while( end <= hi && nums[end] - nums[m] <= upper){

                end++;
            }

            count += end - start;
        }

        for(int k = lo; k <= hi; k++){

            if( i == (mid+1)){

                nums[k] = temp[j];
                j++;
            }else if( j == (hi+1)){

                nums[k] = temp[i];
                i++;
            }else if( temp[i] > temp[j]){

                nums[k] = temp[j];
                j++;
            }else if( temp[i] <= temp[j]){

                nums[k] = temp[i];
                i++;
            }
        }
    }
}
