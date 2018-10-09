package CampusRecruitment.Imooc.Union;

/**
 * @Author: Donlin
 * @Date: Created in 9:36 2018/10/8
 * @Version: 1.0
 * @Description:
 */
public class UnionFindTest {

    UnionFind unionFind;
    int n;

    UnionFindTest(int n,boolean signal){
        this.n = n;
        if (signal)
            test1();
        else
            test2();
    }

    void test1(){
        unionFind = new UnionFind1(n);
        long startTime = System.currentTimeMillis();
        System.out.println("test1: "+ startTime);
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            unionFind.unionElements(a, b);
        }
        long midTime = System.currentTimeMillis();
        System.out.println("middle: "+ (midTime-startTime));
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            unionFind.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("over: "+ endTime);
        System.out.println("process: "+ (endTime-startTime));
    }

    void test2(){
        unionFind = new UnionFind2(n);
        long startTime = System.currentTimeMillis();
        System.out.println("test2: "+ startTime);
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n );
            int b = (int)(Math.random() * n );
            unionFind.unionElements(a, b);
        }
        long midTime = System.currentTimeMillis();
        System.out.println("middle: "+ (midTime-startTime));
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            unionFind.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("over: "+ endTime);
        System.out.println("process: "+ (endTime-startTime));
    }

    public static void main(String[] args) {
        int n = 100000;
        UnionFindTest test1 = new UnionFindTest(n, false);
        UnionFindTest test2 = new UnionFindTest(n, true);
    }
}
