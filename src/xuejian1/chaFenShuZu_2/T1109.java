package xuejian1.chaFenShuZu_2;

/**
 * @author CXWWH
 * @create 2022-04-29-17:22
 * @
 **/
public class T1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] nums = new int[n];
        DiffArrar diffArrar = new DiffArrar(nums);

        for(int i = 0; i < bookings.length; i++){

            diffArrar.increment(bookings[i][0]-1, bookings[i][1]-1, bookings[i][2]);
        }

        return diffArrar.getnums();
    }

    class DiffArrar{

        int[] diff;

        public DiffArrar(int[] nums){

            diff = new int[ nums.length];
            diff[0] = nums[0];
            for(int i = 1; i <diff.length; i++){

                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val){

            diff[i] += val;
            if( j+1 < diff.length){

                diff[j+1] -= val;
            }
        }

        public int[] getnums(){

            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for(int i = 1; i < nums.length; i++){

                nums[i] = nums[i-1] + diff[i];
            }

            return nums;
        }
    }
}
