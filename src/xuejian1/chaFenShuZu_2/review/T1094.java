package xuejian1.chaFenShuZu_2.review;

/**
 * @author CXWWH
 * @create 2022-06-11-8:58
 * @
 **/
public class T1094 {

    class Difference{

        int[] diff;

        public Difference(int[] nums){

            diff = new int[nums.length];
            diff[0] = nums[0];

            for(int i = 1; i < nums.length; i++){

                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val){

            diff[i] += val;

            if( diff[j+1] < diff.length){

                diff[j+1] -= val;
            }
        }

        public int[] getRes(){

            int[] res = new int[ diff.length];
            res[0] = diff[0];

            for(int i = 0; i < diff.length; i++){

                res[i] = res[i-1] + diff[i];
            }

            return res;
        }
    }

    public boolean carPooling(int[][] trips, int capacity){

        int[] nums = new int[1001];
        Difference diff = new Difference(nums);

        for (int[] trip : trips) {

            diff.increment(trip[1], trip[2]-1, trip[0]);
        }

        int[] res = diff.getRes();

        for(int i = 0; i < res.length; i++){

            if( res[i] > capacity){

                return false;
            }
        }

        return true;
    }
}
