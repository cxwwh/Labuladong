package zhangjian2.BinaryTree.guibing23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-06-30-10:25
 * @
 **/
public class T315 {

    //暴力解法，超出时间限制
    public List<Integer> countSmaller2(int[] nums) {

        int[] count = new int[ nums.length];

        for(int i = 0; i < nums.length; i++){

            for(int j = i+1;j < nums.length; j++){

                if( nums[j] < nums[i]){

                    count[i]++;
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < count.length; i++){

            res.add( count[i]);
        }

        return res;
    }

    //第二种解法：利用归并排序的思想
    class Pair{

        public int val;
        public int index;

        public Pair(){

        }

        public Pair(int val, int index){

            this.val = val;
            this.index = index;
        }
    }

    int[] count;
    Pair[] temp;
    public List<Integer> countSmaller(int[] nums) {

        if( nums == null){

            return null;
        }

        int n = nums.length;
        count = new int[ n];
        temp = new Pair[ n];
        Pair[] arr = new Pair[ n];

        for(int i = 0; i < n; i++){

            arr[i] = new Pair( nums[i], i);
        }

        sort(arr, 0,n-1);

        List<Integer> res = new ArrayList<>();

        for (int i : count) {

            res.add(i);
        }

        return res;
    }

    public void sort(Pair[] arr, int lo, int hi){

        if( lo == hi){

            return;
        }

        int mid = lo + (hi - lo)/2;
        sort( arr, lo, mid);
        sort( arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }

    public void merge(Pair[] arr, int lo, int mid, int hi){

        int i = lo;
        int j = mid+1;

        for(int m = lo; m <= hi; m++){

            temp[m] = arr[m];
        }

        for(int index = lo; index <= hi; index++){

            if( i == (mid+1)){

                //说明[lo...hi]的左半部分都合并完了，说明左半部分较小，所以先合并了
                //下面只需要合并右半部分就好了
                arr[ index] = temp[j];
                j++;
            }else if( j == (hi+1)){

                //说明右半部分合并完了，说明右半部分更小
                //即 右半部分的元素的val 都比 temp[i]的val小
                arr[ index] = temp[i];
                i++;
                //注意：arr[index]这个Pair对象的索引才是最初在nums中的索引
                //至于在左右半部分的内部计数的问题，在递归过程中就已经解决
                count[ arr[index].index] += j - (mid+1);
            }else if( temp[ i].val > temp[j].val){

                arr[ index] = temp[j];
                j++;
            }else if( temp[ i].val <= temp[j].val){

                //这时候找到了temp[ i].val <= temp[j].val的边界，可以更新count了
                arr[index] = temp[i];
                i++;
                count[ arr[index].index] += j - (mid+1);
            }
        }
    }

    @Test
    public void test(){

        int[] nums = {5,2,6,1};
        List<Integer> list = countSmaller(nums);

        System.out.println(list);
    }
}
