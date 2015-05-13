package com.mark.algorithm.basic;

import java.io.*;

/*
题目描述：练手用题，请计算A+B到值
输入：输入两个数，a，b
输出：a+b的值
输入样例：2 3
输出样例：5
*/
public class ABProblem{

	public static void main(String[] args){
		System.out.println("Please input two number:");
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new InputStreamReader(System.in));
			int a,b;
			
			String readLine = buf.readLine();
			String[] arrays = readLine.split(" ");
			a = Integer.parseInt(arrays[0]);
			b = Integer.parseInt(arrays[1]);

			System.out.println(a + b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
