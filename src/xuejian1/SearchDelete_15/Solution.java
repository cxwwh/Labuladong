package xuejian1.SearchDelete_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author CXWWH
 * @create 2022-05-20-22:12
 * @
 **/
//710
public class Solution {

    int realN;
    Map<Integer, Integer> mapping;
    Random random;
    public Solution(int n, int[] blacklist) {

        //[0,n)有n个数字
        //但是有blacklist.length是不可选的
        //真正可以取到的数字有realN个
        //当我们把黑名单中的数字映射到末尾后
        //我们只需要在[0,realN)中选取随机数
        realN = n - blacklist.length;

        //将黑名单中的数字和[reslN,n)之间的数字建立映射关系
        //key为黑名单中的数字
        //value为黑名单中的数字对应的不在黑名单中的数字
        //也就是[reslN,n)之间的数字
        mapping = new HashMap<>();

        //将黑名单中的数字作为key
        for(int b : blacklist){

            //这里value放什么值都可以
            mapping.put(b,b);
        }

        //last是要与黑名单中的数字建立映射的合法数字
        int last = n-1;
        for(int b : blacklist){

            //如果黑名单中的数字本来就在[realN,n)中
            //那么不用映射
            //因为pick()函数中随机生成的随机索引是[0,reslN)
            //永远不会拿到b
            if( b >= realN){

                continue;
            }

            //如果last是黑名单中的数
            //而b也是黑名单中的数
            //不能让黑名单中的数之间映射
            //那就让last--
            while( mapping.containsKey( last )){

                last--;
            }

            //将黑名单中的数字b和不在黑名单中的数字建立映射关系
            mapping.put(b,last);
            last--;
        }

        random = new Random();

    }

    public int pick(){

        int num = random.nextInt(realN);

        //如果当前数字在黑名单中
        //那么返回这个黑名单中的数所映射的合法数字
        if( mapping.containsKey(num)){

            return mapping.get(num);
        }

        //如果该数字不在黑名单中，直接返回即可
        return num;
    }
}
