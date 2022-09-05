package xuejian1.chaFenShuZu_2.review;

/**
 * @author CXWWH
 * @create 2022-06-11-8:29
 * @
 **/
public class T370 {

    class Differrence{

        int[] diff;

        public Differrence(int[] nums){

            diff = new int[ nums.length];
            diff[0] = nums[0];

            for(int i = 0; i < nums.length; i++){

                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val){

            diff[i] += val;

            if( j+1 < diff.length){

                diff[j+1] -= val;
            }
        }

        public int[] getRes(){

            int[] res = new int[diff.length];
            res[0] = diff[0];

            for(int i = 1; i < diff.length; i++){

                res[i] = res[i-1] + diff[i];
            }

            return res;
        }
    }

    public int[] getModifiedArray(int length, int[][] updates){

        int[] nums = new int[length];

        Differrence diff = new Differrence(nums);

        for (int[] update : updates) {

            diff.increment(update[0], update[1], update[2]);
        }

        return diff.getRes();
    }
}
