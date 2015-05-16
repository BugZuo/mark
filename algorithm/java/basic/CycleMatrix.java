/*
题目描述：
实现螺旋矩阵
输入样例：
3
输出样例
7 8 1
6 9 2
5 4 3
*/
package com.mark.algorithm.basic;

import java.util.*;

public class CycleMatrix {
	private int dimension; //维数
	
	public CycleMatrix(int dimension) {
		this.dimension = dimension;
	}

	public void print() {
		int[][] data = new int[dimension][dimension];
		int base = 0;

		//begin
		for (int cycle = 0; cycle < dimension / 2; cycle++) {
			//right
			for (int row = cycle; row < dimension - cycle - 1; row++) {
				data[row][dimension - cycle - 1] = ++base;
//				System.out.println(data[row][dimension - cycle - 1]);
//				System.out.println("right:"+row+ ":"+ (dimension - cycle - 1)+" " + base);
			}			
	
			//down
			for (int col = dimension - 1 - cycle; col > cycle; col--) {
				data[dimension - cycle - 1][col] = ++base;
//				System.out.println("down:"+(dimension - 1 - cycle)+":" + col+ " " +base);
			}

			//left
			for (int row = dimension - 1 - cycle; row > cycle; row--) {
				data[row][cycle] = ++base; 
//				System.out.println("left:"+row + ":" + (dimension -1 -cycle) +  " " + base);
			}

			//top
			for (int col = cycle; col < dimension - 1 - cycle; col++) {
				data[cycle][col] = ++base;
//				System.out.println("top:" +(dimension - 1 -cycle) + ":" + col + " " +base);
			}
		}

		if (dimension % 2 == 1) {
			data[(dimension - 1) / 2][(dimension - 1) / 2] = dimension * dimension;
		}

//		System.out.println(data[0][0] + "------------------------------");		

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (data[i][j] < 10) {
					System.out.print(data[i][j] + "    ");
				} else if (data[i][j] < 100) {
					System.out.print(data[i][j] + "   ");
				} else if (data[i][j] < 1000) {
					System.out.print(data[i][i] + "  ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入矩阵的阶数：");
		int scale = scan.nextInt();

		System.out.println();
		CycleMatrix cm = new CycleMatrix(scale);
		cm.print();
	}
}
