package SpecialCode;

public class BacktrackTemping {
	private void backtrack(String s) { //s表示原始参数可能不止一个
	    //终止条件(递归必须要有终止条件)
	    if (s.length()==1) {//这里写终止条件
	        //一些逻辑操作（可有可无，视情况而定）
	        return;
	    }

	    for (int i = 0; i < 8; i++) {//循环体
	        //一些逻辑操作（可有可无，视情况而定）

	        //做出选择

	        //递归
	        backtrack("新的参数");
	        //一些逻辑操作（可有可无，视情况而定）

	        //撤销选择
	    }
}
}
