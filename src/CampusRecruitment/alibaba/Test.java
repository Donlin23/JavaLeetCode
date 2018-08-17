package CampusRecruitment.alibaba;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Donlin
 * @Date: Created in 15:19 2018/8/17
 * @Version: 1.0
 * @Description:
 */
public class Test {

    private static int N = 100000000;            // 总访问次数

    public static void main(String[] args) throws Exception {

        DataMap dataMap = new DataMap();

        // 生成一个监控器
        Monitor monitor = new Monitor(dataMap);

        // 创建一个定时器
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //监控hashmap的线程，每间隔一秒钟打印一次normalMap和blackMap
                if (dataMap.isNormalMapEmpty()){
                    return;
                }
                if (dataMap.isBlackMapEmpty()){
                    return;
                }
                Iterator norIterator = dataMap.normalIterator();        // * 这个迭代器没有处理并发的问题，会抛出异常
                System.out.print("Print the normalmap:\n");
                while (norIterator.hasNext()){
                    Map.Entry entry = (Map.Entry) norIterator.next();
                    System.out.print(String.valueOf(entry.getKey()) + "->");
                    System.out.println(String.valueOf(entry.getValue()));
                }
            }
        }, 2000 ,2000);

        // todo: 先设计一个可以不断产生（ip-time）的程序
        // 假设只有192.168.0.0 - 192.168.1.198这个范围的IP随机访问
        for (int i = 0; i < N; i++) {
            StringBuffer ip_time = new StringBuffer();
            ip_time.append("192.168.1." + ((int)(Math.random() * 100)+(int)(Math.random() * 100)));
            ip_time.append("-" + System.currentTimeMillis());
            // 这里已经生成一条ip-time，可以在这里对运维系统传入数据
            monitor.processRecord(ip_time.toString());
        }
        System.out.println("Over.");
    }

}
