package CampusRecruitment.alibaba;

/**
 * @Author: Donlin
 * @Date: Created in 8:40 2018/8/17
 * @Version: 1.0
 * @Description:
 */
public class Monitor extends Thread{

    private DataMap dataMap;

    Monitor(DataMap dataMap){
        this.dataMap = dataMap;
    }

    /**
     * 接收一条ip_time的访问记录，并处理、存入相应的hashmap中
     * @param ip_time
     * @throws Exception
     */
    public void processRecord(String ip_time) throws Exception {
        String[] parser = ip_time.trim().split("-");
        if (parser.length < 2){
            throw new Exception("记录数据格式错误");
        }
        String currentIP = parser[0];
        long currentTime = Long.valueOf(parser[1]);
        if (!dataMap.isBlackMapEmpty() && dataMap.blackmapContainsKey(currentIP)){
            // 该ip在黑名单中
            String blackValue = dataMap.getBlackValue(currentIP);
            String[] blackValues = blackValue.split("-");
            if (blackValues.length != 4){
                throw new Exception("blackMap存储数据错误");
            }
            // 读取黑名单并更新该ip的访问状态
            long startTimeForMinute = Long.valueOf(blackValues[0]);
            int countMinute = Integer.parseInt(blackValues[1]) + 1;
            long startTimeForHour = Long.valueOf(blackValues[2]);
            int countHour = Integer.parseInt(blackValues[3]) + 1;
            // 判断是否符合解除黑名单
            // 不符合黑名单，解除并加入normalMap
            if (isNormalForMinute(startTimeForMinute, currentTime, countMinute) || isNormalForHour(startTimeForHour, currentTime, countHour)){
                // 为了方便测试，我的条件设置为一分钟内不超过500次的就可以解除
                dataMap.putNormalValue(currentIP, currentTime+"-"+1+"-"+currentTime+"-"+1);      // 设置回正常列表，并重新计数
                dataMap.blackmapRemove(currentIP);
                return;
            }
            // 符合黑名单，不能解除，看是否需要更新时间
            if ((currentTime-startTimeForMinute)/1000L >= 60){
                startTimeForMinute = currentTime;
                countMinute = 0;
            }
            if ((currentTime-startTimeForHour)/1000L >= 3600){
                startTimeForHour = currentTime;
                countHour = 0;
            }
            dataMap.putBlackValue(currentIP,startTimeForMinute+"-"+countMinute+"-"+startTimeForHour+"-"+countHour);
        }else {
            // 该ip不在黑名单中
            if (dataMap.isNormalMapEmpty()){
                // 正常名单为空，直接加入
                int countMinute = 1;
                int countHour = 1;
                dataMap.putNormalValue(currentIP, currentTime+"-"+countMinute+"-"+currentTime+"-"+countHour);
                return;
            }
            if (!dataMap.normalmapContainsKey(currentIP)){
                // 该ip不在正常名单中，也就是首次访问
                int countMinute = 1;
                int countHour = 1;
                dataMap.putNormalValue(currentIP, currentTime+"-"+countMinute+"-"+currentTime+"-"+countHour);
                return;
            }else {
                // 该ip在正常名单中
                String value = dataMap.getNormalValue(currentIP);
                String[] values = value.split("-");
                if (values.length != 4){
                    throw new Exception("normalMap存储数据错误");
                }
                // 读取正常列表并更新该ip访问状态
                long startTimeForMinute = Long.valueOf(values[0]);
                int countMinute = Integer.parseInt(values[1]) + 1;
                long startTimeForHour = Long.valueOf(values[2]);
                int countHour = Integer.parseInt(values[3]) + 1;
                // 判断状态是否符合黑名单
                // 符合黑名单，则加入blackMap
                if (isBlackForMinute(startTimeForMinute, currentTime, countMinute) || isBlackForHour(startTimeForHour, currentTime, countHour)){
                    dataMap.putBlackValue(currentIP, currentTime+"-"+1+"-"+currentTime+"-"+1);   // 加入黑名单并重新计数
                    dataMap.normalmapRemove(currentIP);
                    return;
                }
                // 不符合黑名单，看是否需要更新时间并重新计数
                if ((currentTime-startTimeForMinute)/1000L >= 60){
                    startTimeForMinute = currentTime;
                    countMinute = 0;
                }
                if ((currentTime-startTimeForHour)/1000L >= 3600){
                    startTimeForHour = currentTime;
                    countHour = 0;
                }
                dataMap.putNormalValue(currentIP,startTimeForMinute+"-"+countMinute+"-"+startTimeForHour+"-"+countHour);
            }
        }
    }

    /**
     * 判断当前ip是否符合一分钟内超过500次访问
     * @param startTimeForMinute
     * @param currentTime
     * @param count
     * @return
     */
    private boolean isBlackForMinute(long startTimeForMinute, long currentTime, int count){
        if ((currentTime-startTimeForMinute)/1000L <= 60 && count >= 500){
            return true;
        }
        return false;
    }

    /**
     * 判断当前ip是否符合一小时内超过15000次访问
     * @param startTimeForHour
     * @param currentTime
     * @param count
     * @return
     */
    private boolean isBlackForHour(long startTimeForHour, long currentTime, int count){
        if ((currentTime-startTimeForHour)/1000L <= 3600 && count >= 15000){
            return true;
        }
        return false;
    }

    /**
     * 判断当前黑名单ip是否符合一分钟内不超过500次访问
     * @param startTimeForMinute
     * @param currentTime
     * @param count
     * @return
     */
    private boolean isNormalForMinute(long startTimeForMinute, long currentTime, int count){
        if ((currentTime-startTimeForMinute)/1000L <= 60 && count < 500){
            return true;
        }
        return false;
    }

    /**
     * 判断当前黑名单ip是否符合一小时内不超过15000次访问
     * @param startTimeForHour
     * @param currentTime
     * @param count
     * @return
     */
    private boolean isNormalForHour(long startTimeForHour, long currentTime, int count){
        if ((currentTime-startTimeForHour)/1000L <= 3600 && count < 15000){
            return true;
        }
        return false;
    }
}