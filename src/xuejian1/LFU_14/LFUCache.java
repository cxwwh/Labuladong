package xuejian1.LFU_14;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-05-19-21:32
 * @
 **/
//T460
public class LFUCache {

    Map<Integer, Integer> kv;
    Map<Integer, Integer> kf;
    Map<Integer, LinkedHashSet<Integer>> fk;
    int cap;
    int minFreq;
    public LFUCache(int capacity) {

        kv = new HashMap<>();
        kf = new HashMap<>();
        fk = new HashMap<>();

        cap = capacity;
        minFreq = 0;
    }

    public int get(int key) {

        if( !kv.containsKey(key)){

            return -1;
        }

        //取出这个key对应的value
        int val = kv.get(key);

        //增加key对应的freq
        increaseFreqOfKey(key);

        return val;
    }

    public void put(int key, int value) {

        if( cap <= 0){

            return;
        }

        if( kv.containsKey(key)){

            //修改kv中的value
            kv.put(key,value);

            //修改kf和fk
            increaseFreqOfKey(key);
            return;
        }

        if( kv.size() == cap){

            //删除出现频率最小的且最早插入的key
            delete();
        }

        //插入到kv表
        kv.put(key,value);

        //插入到kf表，注意频率为1
        kf.put(key,1);

        //更新fk表
        fk.putIfAbsent(1,new LinkedHashSet<Integer>());
        fk.get(1).add(key);

        //插入了一个新的key,minFreq肯定是1
        minFreq = 1;

    }

    //增加key对应的freq
    public void increaseFreqOfKey(int key){

        //改变频率
        int freq = kf.getOrDefault(key,0);
        kf.put(key, freq + 1);

        //将fk表中，对应freq中的key移出
        fk.get(freq).remove(key);

        //将key添加到freq+1中
        fk.putIfAbsent(freq+1, new LinkedHashSet<Integer>());
        fk.get( freq+1 ).add(key);

        //如果fk表中对应的freq中没有key了，那么就移除这个freq
        if( fk.get(freq).isEmpty()){

            fk.remove(freq);

            //如果移除的freq恰好是minFreq
            //那么就要更新容器中的minFreq
            if( freq == minFreq){

                minFreq = freq+1;
            }
        }
    }

    //删除freq最小的且最早插入的key
    public void delete(){

        LinkedHashSet<Integer> keySet = fk.get(minFreq);

        //找到最先被插入的那个key
        Integer key = keySet.iterator().next();

        keySet.remove(key);
        if( keySet.isEmpty()){

            fk.remove(minFreq);

            //这里minFreq对应的key全部都没了
            //按理说应该更新minFreq，通过遍历kf表
            //不能保证时间复杂度为o()
            //但是实际上，这里并不需要更新minFreq
            //因为当前的delete()方法只有在插入新的key时才可能调用
            //而插入新的key后，一定会更新minFreq为1
        }

        kv.remove(key);

        kf.remove(key);
    }
}
