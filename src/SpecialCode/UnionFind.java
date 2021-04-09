package SpecialCode;

//并查集
public class UnionFind {
	// 连通分量个数
	private int count;
	// 存储一棵树
	private int[] parent;
	// 记录树的“重量”
	private int[] size;

//有参构造
	public UnionFind(int n) {
		// 最先开始假设每个节点单独存在，因此连通块数=节点数，每连接完两个节点，count--;
		this.count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/* 将 p 和 q 连接 */
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		// parent[rootP] = rootQ;利用size做了平衡性优化后的代码如下
		// 小树接到大树下面，较平衡,
		if (size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;
	}

	/* 判断 p 和 q 是否连通 */
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return (rootQ == rootP);
	}

	/* 返回图中有多少个连通分量 */
	public int count() {
		return count;
	}

	/* 查找x节点的根节点 */
	private int find(int x) {
		while (parent[x] != x) {
			// 进行路径压缩
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
	// Union-Find 算法的关键就在于union和connected函数的效率。
}
