/*
题目描述：
现在给出你一些数，要求你写出一个程序，输出这些整数相邻最近的素数，并输出其相距长度。如果左右有等距离长度的素数，则输出左侧的值及相应距离，如果输入本身就是一个素数，则输出该素数本身，距离输出0
输入：
第一行给出测试数据组数N(0<N<=10000)接下来到N行每行有一个整数M(0<M<=1000000).
输出：
每行输出两个整数A，B，其中A表示离相应测试数据最近的素数，B表示其间的距离。
输入样例：
3
6
8
10
输出样例：
5 1
7 1
11 1
*/
package com.mark.algorithm.basic;

import java.io.*;

public class PrimeDistance {
	private int[] data;
	public PrimeDistance(int[] data) {
		this.data = data;
	}

	private void print() {
		int left = 0, right = 0, ldistance = 0, rdistance = 0;
		for (int i = 0; i < data.length; i++) {
			boolean flag = true; //设立标记位

			for (int l = data[i]; l > 0; l--) {
				if (isPrime(l)) {
					left = l;
					ldistance = data[i] - l;
					if (ldistance == 0) {
						System.out.println(data[i] + " 0" );
						flag = false; // 当本身为素数时，跳出循环，并设标志位false，停止向右检测
					}
					break;
				}
			}
	
			right = data[i] + 1;
			while (flag) {	
				if (isPrime(right)) {
					rdistance = right - data[i];
					break;
				}
				right += 1;
			}

			if (ldistance <= rdistance) {
				System.out.println(left + " " + ldistance);
			} else {
				System.out.println(right + " " + rdistance);
			}
		}
	}

	//改进遍历算法
	//先左后右同时遍历素数
	private void optimizePrint() {
		System.out.println("-*- Opitimize the algorithm of print -*-");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; data[i] - j > 0; j++) {
				if (isPrime(data[i] - j)) {
					System.out.println((data[i] - j) + " " + j);
					break;
				}
				
				if (isPrime(data[i] + j)) {
					System.out.println((data[i] + j) + " " + j);
					break;
				}
			}
		}
	}

	private boolean isPrime(int num) {
		if (num <= 3) {
			return true;
		}

		if (num % 2 == 0) {
			return false;
		}

		for (int i = 3; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please input the quantity to test:");
		int n = Integer.parseInt(buf.readLine());

		int[] data = new int[n];
		System.out.println("Please input the data one by one:");
		
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(buf.readLine());
			data[i] = temp;
		}

		PrimeDistance pd = new PrimeDistance(data);
		pd.print();
		pd.optimizePrint();

		if (buf == null) {
			buf.close();
		}
	}
}
