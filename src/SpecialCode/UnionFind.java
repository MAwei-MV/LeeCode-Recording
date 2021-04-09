package SpecialCode;

//���鼯
public class UnionFind {
	// ��ͨ��������
	private int count;
	// �洢һ����
	private int[] parent;
	// ��¼���ġ�������
	private int[] size;

//�вι���
	public UnionFind(int n) {
		// ���ȿ�ʼ����ÿ���ڵ㵥�����ڣ������ͨ����=�ڵ�����ÿ�����������ڵ㣬count--;
		this.count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/* �� p �� q ���� */
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		// parent[rootP] = rootQ;����size����ƽ�����Ż���Ĵ�������
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

	/* �ж� p �� q �Ƿ���ͨ */
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return (rootQ == rootP);
	}

	/* ����ͼ���ж��ٸ���ͨ���� */
	public int count() {
		return count;
	}

	/* ����x�ڵ�ĸ��ڵ� */
	private int find(int x) {
		while (parent[x] != x) {
			// ����·��ѹ��
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
	// Union-Find �㷨�Ĺؼ�������union��connected������Ч�ʡ�
}
