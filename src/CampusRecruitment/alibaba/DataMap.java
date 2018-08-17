package CampusRecruitment.alibaba;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Donlin
 * @Date: Created in 16:17 2018/8/17
 * @Version: 1.0
 * @Description:
 */
public class DataMap {
    private volatile  Map<String, String> normalMap = new HashMap<>();      // 正常访问列表
    private volatile  Map<String, String> blackMap = new HashMap<>();       // 黑名单列表
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void putNormalValue(String key, String value){
        try{
            lock.writeLock().lock();
            normalMap.put(key, value);
        }finally{
            lock.writeLock().unlock();
        }
    }

    public String getNormalValue(String key){
        try{
            lock.readLock().lock();
            return normalMap.get(key);
        }finally{
            lock.readLock().unlock();
        }
    }

    public void putBlackValue(String key, String value){
        try{
            lock.writeLock().lock();
            blackMap.put(key, value);
        }finally{
            lock.writeLock().unlock();
        }
    }

    public String getBlackValue(String key){
        try{
            lock.readLock().lock();
            return blackMap.get(key);
        }finally{
            lock.readLock().unlock();
        }
    }

    public boolean isNormalMapEmpty(){
        return normalMap.isEmpty();
    }

    public boolean isBlackMapEmpty(){
        return blackMap.isEmpty();
    }

    public Iterator normalIterator(){
            return normalMap.entrySet().iterator();
    }

    public Iterator blackIterator(){
        return blackMap.entrySet().iterator();
    }

    public boolean blackmapContainsKey(String key){
        return blackMap.containsKey(key);
    }

    public boolean normalmapContainsKey(String key){
        return normalMap.containsKey(key);
    }

    public String blackmapRemove(String key){
        return blackMap.remove(key);
    }

    public String normalmapRemove(String key){
        return normalMap.remove(key);
    }
}
