package xuejian1.chaFenShuZu_2;

/**
 * @author CXWWH
 * @create 2022-04-29-17:53
 * @
 **/
public class T1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] nums = new int[1001];

        DiffArray diffArray = new DiffArray(nums);
        for(int i = 0; i < trips.length; i++){

            diffArray.increment(trips[i][1], trips[i][2], trips[i][0]-1);
        }

        int[] nums1 = diffArray.getNums();
        for(int i = 0; i < nums1.length; i++){

            if( nums1[i] > capacity){

                return false;
            }
        }

        return true;
    }

    class DiffArray{

        int[] diff;

        public DiffArray(int[] nums){

            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++){

                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val){

            diff[i] += val;
            if( j+1 < diff.length){

                diff[j+1] -= val;
            }

        }

        public int[] getNums(){

            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for(int i = 1; i < diff.length; i++){

                nums[i] = nums[i-1] + diff[i];
            }

            return nums;
        }
    }
}
