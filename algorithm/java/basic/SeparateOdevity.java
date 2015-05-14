/*
题目描述：
有一个整型数n(2<=n<=10000),你要做的是：先把1到n中的所有奇数从小到大输出，再把所有的偶数从小到大输出。
输入：
第一行有一个整数i，(2=<i<30表示有i组测试数据;
每组有一个整形偶数n;
输出：
第一行输出所有的奇数
第二行输出所有的偶数
输入样例：
2
10
14
输出样例：
1 3 5 7 9
2 4 6 8 10

1 3 5 7 9 11 13
2 4 6 8 10 12 14
*/
package com.mark.algorithm.basic;

import java.io.*;

public class SeparateOdevity {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please input the quantity of test group:");
		int x = Integer.parseInt(buf.readLine());
		
		int[][] arrays = new int[x][];
		for (int i = 0; i < arrays.length; i++) {
			System.out.print("Please input the number of group " + (i + 1) +":");
			x = Integer.parseInt(buf.readLine());
			arrays[i] = new int[x/2];
		}
		
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 1; j < arrays[i].length * 2; j = j+2) {
				System.out.print(j + " ");
			}
			System.out.println();
			for (int j = 2; j <= arrays[i].length * 2; j += 2) {
				System.out.print(j + " ");
			}
			System.out.println("\n");
		}
	}
}
