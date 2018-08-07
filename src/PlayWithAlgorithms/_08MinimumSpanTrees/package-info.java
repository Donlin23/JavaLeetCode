/**
 * @Author: Donlin
 * @Date: Created in 14:05 2018/8/7
 * @Version: 1.0
 * @Description:
 */
package PlayWithAlgorithms._08MinimumSpanTrees;

// 最小生成树问题：针对带权无向图、连通图，找出一个可以连接所有点但是总权重最小的这样一个树，称为最小生成树（V个点找V-1条边）
    // 最小生成树应用：电缆布线设计、网络设计、电路设计
    // 切分定理（Cut Property）：给定任意切分，横切边中权值最小的边必然属于最小生成树。
    // Lazy Prim 算法：
        //