package xuejian1.qianZhuiHe_1.review;

/**
 * @author CXWWH
 * @create 2022-06-10-9:00
 * @
 **/
public class T303 {

    class NumArray{

        private int[] perfixSum;
        public NumArray(int[] nums){

            perfixSum = new int[nums.length+1];
            for(int i = 1; i < perfixSum.length; i++){

                perfixSum[i] = perfixSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right){

            return perfixSum[right + 1] - perfixSum[left];
        }
    }

    //计算每个分数段内有多少同学
    public int getCount(int[] scores, int start, int end){

        int[] count = new int[ 100 + 1];

        for (int score : scores) {

            count[ score]++;//count的索引为0~100
        }

        for(int i = 1; i < count.length; i++){

            count[i] = count[i] + count[i-1];//count[i]中存放的是分数为0~i之间的人数
        }

        if( end < start || end > 100 || start < 0){

            return 0;
        }

        if( start == 0){

            return count[end];
        }

        return count[end] - count[start - 1];
    }
}
