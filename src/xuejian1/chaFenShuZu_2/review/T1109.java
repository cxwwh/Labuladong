package xuejian1.chaFenShuZu_2.review;

/**
 * @author CXWWH
 * @create 2022-06-11-8:37
 * @
 **/
public class T1109 {

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

    public int[] cropFlightBookings(int[][] bookings, int n){

        int[] flights = new int[n];

        Difference diff = new Difference(flights);

        for (int[] booking : bookings) {

            diff.increment( booking[0]-1, booking[1]-1, booking[2]);
        }

        return diff.getRes();
    }
}
