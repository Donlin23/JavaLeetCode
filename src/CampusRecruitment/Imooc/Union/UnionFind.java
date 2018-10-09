package CampusRecruitment.Imooc.Union;

/**
 * @Author: Donlin
 * @Date: Created in 10:15 2018/10/8
 * @Version: 1.0
 * @Description:
 */
public interface UnionFind {
    int find(int p);
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
