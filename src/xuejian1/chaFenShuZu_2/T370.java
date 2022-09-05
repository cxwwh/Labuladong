package xuejian1.chaFenShuZu_2;

/**
 * @author CXWWH
 * @create 2022-04-29-15:01
 * @
 **/
public class T370 {

    public int[] getModifiedArray(int length, int[][] updates) {

        int[] arr = new int[length];
        DiffArray diffArray = new DiffArray( arr);
        for(int i = 0; i < updates.length; i++){

            diffArray.increment(updates[i][0],updates[i][1],updates[i][2]);
        }

        int[] nums = diffArray.getNums();
        return nums;
    }

    class DiffArray{

        int[] diff;

        public DiffArray(int[] arr) {

            diff = new int[arr.length];
            diff[0] = arr[0];
            for(int i = 1; i < arr.length; i++){

                diff[i] = arr[i] - arr[i-1];
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
