package xuejian1.qianZhuiHe_1.review;

/**
 * @author CXWWH
 * @create 2022-06-10-9:57
 * @
 **/
public class T304 {

    class NumMatrix{

        private int[][]persum;

        private NumMatrix(int[][]matrix){

            int row = matrix.length;
            int col = matrix[0].length;
            persum = new int[row + 1][col + 1];

            for(int i = 1; i < row+1; i++){

                for(int j = 1; j < col + 1; j++){

                    persum[i][j] = persum[i][j-1] + persum[i-1][j]  - persum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegin(int x1, int y1, int x2, int y2){

            return persum[x2+1][y2+1] - persum[x1][y2+1] - persum[x2+1][y1] + persum[x1][y1];
        }
    }
}
