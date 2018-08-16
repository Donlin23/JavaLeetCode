package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 15:08 2018/8/14
 * @Version: 1.0
 * @Description: 面试题5: 替换空格
 */
public class replaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy.");
        System.out.println(replaceSpace(str));
        System.out.println();
    }

    public static String replaceSpace(StringBuffer str){
        if (str == null || str.length() <= 0) return "";
        int strLength = str.length();
        int blackCount = 0;
        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) == ' '){
                blackCount++;
            }
        }
        int strLengthNew = 2 * blackCount + strLength;
        int strPointer = strLength - 1;
        StringBuffer strNew = new StringBuffer(strLengthNew);
        while (strPointer >= 0){
            if (str.charAt(strPointer) == ' '){
                strNew.insert(0,'0');
                strNew.insert(0, '2');
                strNew.insert(0, '%');
            }else {
                strNew.insert(0, str.charAt(strPointer));
            }
            strPointer --;
        }
        return strNew.toString();
    }
}
