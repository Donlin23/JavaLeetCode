package CampusRecruitment.Tencent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Donlin
 * @Date: Created in 17:43 2018/9/24
 * @Version: 1.0
 * @Description:
 */
public class RE {
    public static void main(String[] args) {
        //newAndy();


    }

    private static void newAndy(){
        String content = "max(m1)+min(m2)-(first(m3)/last(m4))*sum(m5)";

        String pattern = "(max\\()(\\D*\\d+)(\\()([\\+\\-\\/\\*]))";

        boolean isMacth = Pattern.matches(pattern, content);
        System.out.println(isMacth);
    }

    public static void cainiao1(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
