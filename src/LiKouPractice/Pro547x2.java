package LiKouPractice;

class UF {
	// ��ͨ��������
	private int count;
	// �洢һ����
	private int[] parent;
	// ��¼���ġ�������
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
		//parent[rootP] = rootQ;����size����ƽ�����Ż���Ĵ�������
		// С���ӵ��������棬��ƽ��,
		if (size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;
	}
//����δ�õ�connected�ж���ͨ��
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
	//���������룬�����������·���Ż�
	private int find(int x) {
		while (parent[x] != x) {
			// ����·��ѹ��
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
