/*
题目描述：
现在给你N个数(0<N<1000),现在要求你写出一个程序，找出这N个数中的所有素数，并求和
输入：
第一行给出整数M(0<M<10)代表多少组测试数据，每组测试数据第一行给你N，代表该组测试数据的数量，接下来的N个数为要测试的数据，每个数小于1000
输出：
每组测试数据结果占一行，输出给出到测试数据的所有素数和
输入样例：
3
5
1 2 3 4 5
8
11 12 13 14 15 16 17 18
10
21 22 23 24 25 26 27 28 29 30
输出样例：
10
41
52
*/
package com.mark.algorithm.basic;

import java.util.*;

public class PrimeSum {
	public static void main(String[] args) {
		PrimeSum ps = new PrimeSum();
		ps.sum(ps.acceptInput());
	}

	private int[][] acceptInput() {
		int m,n;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input the quantity of testing groups:");
		m = scan.nextInt();
		
		int[][] data = new int[m][];
		for (int i = 0; i < m; i++) {
			System.out.println("Please input the quantity of group" + (i + 1) + ":");
			n = scan.nextInt();
			data[i] = new int[n];
			System.out.println("Please input the data of group" + (i + 1) + ":");
			for (int j = 0; j < n; j++) {
				data[i][j] = scan.nextInt();	
				//System.out.println("next:");
			}
		}
		return data;
	}

	private void sum(int[][] data) {
		int sum;
		for (int i = 0; i < data.length; i++) {
			sum = 0;
			for (int j = 0; j < data[i].length; j++) {
				if (isPrime(data[i][j])) {
					sum += data[i][j];	
				//	System.out.println(data[i][j]);
				}
			}
			System.out.println(sum);
		}
	
	}

	private boolean isPrime(int num) {
		if (num < 3) {
			return true;
		}

		if (num % 2 == 0) {
			return false;
		}

		for (int i = 2; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
