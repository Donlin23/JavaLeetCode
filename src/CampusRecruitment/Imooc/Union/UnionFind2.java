package CampusRecruitment.Imooc.Union;

/**
 * @Author: Donlin
 * @Date: Created in 10:09 2018/10/8
 * @Version: 1.0
 * @Description:
 */
public class UnionFind2 implements UnionFind{

    private int[] parents;
    private int[] sz;           // 基于size优化: sz[i]表示第i个节点具有sz[i]个节点
    private int[] rank;         // 基于rank优化: rank[i]表示第i个节点作为根节点的树的层数
    private int count;

    public UnionFind2(int n){
        count = n;
        parents = new int[n];
        sz = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sz[i] = 1;
            rank[i] = 1;
        }
    }

    public int find(int p){
        assert (p>=0 && p<count);
        while (p!=parents[p]){
            parents[p] = parents[parents[p]];       // 路径压缩 Path Compression
            p=parents[p];
        }
        return p;

        // 也可以进行更好的路径压缩，直接让所有的节点都指向根节点，但是这种方法需要递归进行，所以时间消耗上也是有比较大的。
    }

    public boolean isConnected(int p, int q){
        return find(p)==find(q);
    }

    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot==qRoot)
            return;
        // 未优化
        //parents[pRoot] = qRoot;

        // 基于size的优化
//        if (sz[pRoot] > sz[qRoot]){
//            parents[pRoot] = qRoot;
//            sz[pRoot] += sz[qRoot];
//        }else{
//            parents[qRoot] = pRoot;
//            sz[qRoot] += sz[pRoot];
//        }

        // 基于rank的优化
        if (rank[pRoot] < rank[qRoot]){
            parents[pRoot] = qRoot;
        }else if (rank[pRoot] > rank[qRoot]){
            parents[qRoot] = pRoot;
        }else {
            parents[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
