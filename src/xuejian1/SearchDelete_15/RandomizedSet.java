package xuejian1.SearchDelete_15;

import java.util.*;

/**
 * @author CXWWH
 * @create 2022-05-20-19:44
 * @
 **/
//T380
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer,Integer> map;
    Random random;

    public RandomizedSet() {

        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        //如果容器中有了这个val
        if( map.containsKey(val)){

            return false;
        }

        //容器中没有这个val
        //把这个val放到nums的末尾
        nums.add( val );
        //记录当前value的索引
        map.put(val,nums.size()-1);
        return true;
    }

    public boolean remove(int val) {

        if( !map.containsKey(val)){

            return false;
        }

        //得到当前val在nums的索引
        int index = map.get(val);
        //得到nums尾的元素
        int num = nums.get(nums.size()-1);
        //将该元素的索引设为index
        map.put(num,index);

        //在nums中将index位置设为num
        nums.set(index,num);

        //删除nums的最后一个元素，也就把val删除了
        nums.remove(nums.size()-1);

        //在map中删除val
        map.remove(val);

        return true;

    }

    public int getRandom() {

        return nums.get( random.nextInt(nums.size()));
    }
}
