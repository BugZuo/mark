/*
Fabonacci数列
*/
package com.mark.algorithm.basic;

import java.io.*;

public class Fabonacci {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("请输入需要得到的Fabonacci数列号:");
		int n = Integer.parseInt(buf.readLine());
		Fabonacci fab = new Fabonacci();
		
		System.out.println("递归方式: " + fab.recurison(n));

		System.out.println("尾递归方式：");
		fab.endRecurison(n, 0, 1);

		System.out.println("迭代方式：");
		fab.iteration(n);
	}

	private int recurison(int n) { //简单递归
		if (n <= 2)
			return 1;
		return recurison(n-1) + recurison(n-2);
	}

	private int endRecurison(int n, int fab1, int fab2) {// 尾递归优化
		if (n < 2)
			return 1;
		System.out.println(fab1 + " " + fab2);
		return endRecurison(n-1, fab2, fab1 + fab2);
	}

	private void iteration(int n) { //迭代
		int fab = 0, fab1 = 0, fab2 = 1;
		for (int i = 0; i < n; i ++) {
			fab = fab1 + fab2;
			fab1 = fab2;
			fab2 = fab;
			System.out.println(fab);
		}
	}
}
