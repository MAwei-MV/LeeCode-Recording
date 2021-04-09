package LiKouPractice;

class UF {
	// 连通分量个数
	private int count;
	// 存储一棵树
	private int[] parent;
	// 记录树的“重量”
	private int[] size;

	public UF(int n) {
		this.count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		//parent[rootP] = rootQ;利用size做了平衡性优化后的代码如下
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
//此题未用到connected判断连通性
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}

	/*private int find(int x) {
	    while (parent[x] != x)
	        x = parent[x];
	    return x;
	} */
	//相比上面代码，下面代码做了路径优化
	private int find(int x) {
		while (parent[x] != x) {
			// 进行路径压缩
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}

	public int count() {
		return count;
	}
}

public class Pro547x2 {
	 public int findCircleNum(int[][] M) {
	 int n = M.length;
     UF uf = new UF(n);
     for (int i = 0; i < n; i++) {
         for (int j = 0; j < i; j++) {
             if (M[i][j] == 1)
                 uf.union(i, j);
         }
     }
     return uf.count();
 }
}
