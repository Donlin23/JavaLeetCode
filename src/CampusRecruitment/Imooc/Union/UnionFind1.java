package CampusRecruitment.Imooc.Union;

/**
 * @Author: Donlin
 * @Date: Created in 9:27 2018/10/8
 * @Version: 1.0
 * @Description:
 */
public class UnionFind1 implements UnionFind{

    private int[] ids;
    private int count;

    public UnionFind1(int n){
        count = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public int find(int p){
        assert (p>=0 && p<count);
        return ids[p];
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);      // 类自身的非静态方法是可以被自身的非静态方法调用的
    }

    public void unionElements(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return ;
        for (int i = 0; i < count; i++) {
            if (ids[i] == qID)
                ids[i]=pID;
        }
    }

}
