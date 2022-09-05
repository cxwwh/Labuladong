package bajian3.BFS40;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-07-13-8:15
 * @
 **/
public class T111 {

    public int minDepth(TreeNode root) {

        if(root == null){

            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int step = 1;

        while( !q.isEmpty()){

            int size = q.size();

            //向四周扩散
            for(int i = 0; i < size; i++){

                TreeNode cur = q.poll();

                if( cur.left == null && cur.right == null){

                    return step;
                }

                if( cur.left != null){

                    q.offer(cur.left);
                }

                if( cur.right != null){

                    q.offer(cur.right);
                }
            }
            step++;
        }

        return step;
    }
}
