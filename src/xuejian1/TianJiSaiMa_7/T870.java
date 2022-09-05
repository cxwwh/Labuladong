package xuejian1.TianJiSaiMa_7;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-05-11-15:30
 * @
 **/
public class T870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {

        int n = nums1.length;
        if( n == 1){

            return nums1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] p1, int[] p2) -> {
                    return p2[1]-p1[1];
                });

        for(int i = 0; i < n; i++){

            pq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        int[] res = new int[n];
        int left = 0;
        int right = n-1;

        while( !pq.isEmpty()){

            int[] num2 = pq.poll();
            int index = num2[0];
            int val = num2[1];

            if( nums1[right] > val){

                res[index] = nums1[right];
                right--;
            }else{

                res[index] = nums1[left];
                left++;
            }
        }

        return res;
    }

    public int[] advantageCount2(int[] nums1, int[] nums2) {

        int n = nums1.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] a1, int[] a2) ->{
                    return a2[1]-a1[1];
                });

        for(int i = 0; i < n; i++){

            pq.offer(new int[]{i, nums2[i]});
        }

        int[] res = new int[n];
        Arrays.sort(nums1);
        int left = 0;
        int right = n - 1;

        while( ! pq.isEmpty()){

            int[] poll = pq.poll();
            int index = poll[0];
            int val = poll[1];

            if( nums1[right] > val){

                res[index] = nums1[right];
                right--;
            }else{

                res[index] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
