package xuejian1.qianZhuiHe_1;

/**
 * @author CXWWH
 * @create 2022-04-27-23:38
 * @
 **/
public class T304 {

    class NumMatrix {

        int[][] preSums;
        public NumMatrix(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;
            preSums = new int[m+1][n+1];

            for(int i = 1; i < m+1; i++){

                for(int j = 1; j < n+1; j++){

                    preSums[i][j] = preSums[i-1][j] + preSums[i][j-1] + matrix[i-1][j-1]
                            - preSums[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            return preSums[row2+1][col2+1] - preSums[row1][col2+1]
                    - preSums[row2+1][col1] + preSums[row1][col1];
        }
    }
}
