package SpecialCode;

public class BacktrackTemping {
	private void backtrack(String s) { //s��ʾԭʼ�������ܲ�ֹһ��
	    //��ֹ����(�ݹ����Ҫ����ֹ����)
	    if (s.length()==1) {//����д��ֹ����
	        //һЩ�߼����������п��ޣ������������
	        return;
	    }

	    for (int i = 0; i < 8; i++) {//ѭ����
	        //һЩ�߼����������п��ޣ������������

	        //����ѡ��

	        //�ݹ�
	        backtrack("�µĲ���");
	        //һЩ�߼����������п��ޣ������������

	        //����ѡ��
	    }
}
}
