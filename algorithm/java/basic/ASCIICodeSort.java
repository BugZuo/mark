/*
题目描述：
输入三个字符（可以重复）后，按各字符到ASCII码从小到大的顺序输出这三个字符。

输入：
第一行输入一个数N，表示有N组测试数据。后面的N行输入多组数据，每组输入数据都是占一行，有三个字符组成，之间无空格。

输出：
对于每组输入数据，输出一行，字符中间用一个空格分开。

输入样例：
2
qwe
asd

输出样例：
e q w
a d s
*/
package com.mark.algorithm.basic;

import java.io.*;

public class ASCIICodeSort {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = null;
		String readLine = null;
		int n;

		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input the number of line:");
		
		n = Integer.parseInt(buf.readLine());
		String[] arrays = new String[n];		
		
		for(int i = 0; i < n; i++) {
			System.out.println("Please input a string(just three character):");
			arrays[i] = buf.readLine();
		}

		for (int i = 0; i < n; i++) {
			char[] chs = bubbleAscii(arrays[i].toCharArray());
			//chs[0] = (int)chs[0] > (int)chs[1] ? chs[1] : chs[0];
			//chs[0] = (int)chs[0] > (int)chs[2] ? chs[2] : chs[0];
			//chs[1] = (int)chs[1] > (int)chs[2] ? chs[2] : chs[1];
			for (int j = 0; j < 3; j++) {
				System.out.print(chs[j] + " ");
			}
			System.out.println();
		}
	}

	private static char[] bubbleAscii(char[] chs) {
		for (int i = 0; i < chs.length - 1; i++) {
			for (int j = 0; j < chs.length - i - 1; j++) {
				char temp;
				if (chs[j] > chs[j+1]) {
					temp = chs[j+1];
					chs[j+1] = chs[j];
					chs[j] = temp;
				}
			}
		}
		return chs;
	}
}
