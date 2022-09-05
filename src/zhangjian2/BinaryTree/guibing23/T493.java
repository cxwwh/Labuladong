package zhangjian2.BinaryTree.guibing23;

/**
 * @author CXWWH
 * @create 2022-07-01-9:52
 * @
 **/
public class T493 {

    int count = 0;
    int[] temp;

    public int reversePairs(int[] nums){

        temp = new int[ nums.length];
        sort(nums, 0, nums.length-1);
        return count;
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


        int i = lo;
        int j = mid+1;

        for(int m = lo; m <= hi; m++){

            temp[m] = nums[m];
        }

        int end = mid + 1;
        for(int m = lo; m <= mid; m++){

            while( end <= hi && ( (long)temp[m] > (long)temp[end]*2)){

                //temp[i] <= temp[i+1],所以适合temp[i]的end，一定适合temp[i+1]
                end++;
            }
            count += end - (mid+1);
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
