package bajian3.HuiSuSiLu36;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-26-10:18
 * @
 **/
public class T51 {

    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {

        // 把每行的结果都放在一个字符串里
        LinkedList<String> track = new LinkedList<>();


        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i < n; i++) {

            sb.append('.');
        }
        // 将字符串初始化为空
        for(int i = 0; i < n; i++){

            track.add(sb.toString());
        }

        // 从第一行开始放
        backTrack(track,0);

        return res;
    }

    public void backTrack(LinkedList<String> track, int row){

        //总的行数
        int n = track.size();
        // 终止条件
        if( row == n){//说明最后一行也放完了

            res.add( new LinkedList( track));
            return;
        }

        // 检查第row行的左右列，看那个位置可以防止皇后
        for(int col = 0; col < n; col++){

            // 判断该位置是否可以放置皇后
            if( !isValid(track,row,col)){

                continue;
            }

            // 做选择
            String s = track.get(row);
            char[] chars = s.toCharArray();
            chars[col] = 'Q';
            track.set(row, new String(chars));

            // 进入下一行决策
            backTrack(track,row+1);

            // 撤销选择
            chars[col] = '.';
            track.set(row,new String(chars));
        }
    }

    // 检查在[row,col]位置是否可以放皇后
    // 由于皇后是从上往下一行一行放的，所以不用检查同一行、左下、右下、以及正下方
    // 只需要检查同一列、左上、右上
    public boolean isValid(LinkedList<String> track, int row, int col){

        int n = track.size();
        // 检查同一列是否有冲突
        for(int i = 0; i < row; i++){

            if(track.get(i).charAt(col) == 'Q'){

                return false;
            }
        }

        // 检查 右上方 是否有冲突
        // j = col + 1为右    i = row-1为上
        for(int i = row-1, j = col + 1; i >= 0 && j < n; i--,j++){

            if(track.get(i).charAt(j) == 'Q'){

                return false;
            }
        }

        // 检查 左上方 是否有冲突
        // j = col - 1为左  i = row-1为上
        for(int i = row-1, j = col - 1; i >= 0 && j >= 0; i--,j--){

            if(track.get(i).charAt(j) == 'Q'){

                return false;
            }
        }

        return true;
    }
}
