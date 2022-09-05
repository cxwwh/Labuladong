package zhangjian2.BinarySearchTree.QuickSort;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author CXWWH
 * @create 2022-07-08-7:57
 * @
 **/
public class T215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{

            return a-b;
        });

        for(int i = 0; i < nums.length; i++){

            queue.offer(nums[i]);

            if( queue.size() > k){

                queue.poll();
            }
        }

        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length-1;
        while( lo <= hi){

            int p = partition(nums,lo,hi);

            if( k < p){

                hi = p - 1;
            }else if( k > p){

                lo = p + 1;
            }else{

                return nums[p];
            }
        }

        return -1;
    }

    public int partition(int[] nums, int lo, int hi){

        int pivot = nums[lo];

        int i = lo + 1;
        int j = hi;

        while( i <= j){

            while( i < hi && nums[i] <= pivot){

                i++;
            }

            while(j > lo && nums[j] > pivot){

                j--;
            }

            if( i >= j){

                break;
            }

            swap(nums, i, j);
        }

        swap(nums, lo, j);
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
            swap(nums,i,j);
        }
    }
}
