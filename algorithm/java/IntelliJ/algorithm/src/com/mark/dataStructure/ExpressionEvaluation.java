package com.mark.dataStructure;

import java.util.Stack;

/**
 * Created by markzuo on 15-5-18.
 */
public class ExpressionEvaluation {
    //声明运算符优先级关系
    private char[][] priority = {{'>','>','<','<','<','>','>'},
            {'>','>','<','<','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'<','<','<','<','<','=',' '},
            {'>','>','>','>',' ','>','>'},
            {'<','<','<','<','<',' ','='}};

    char calPriority(char first, char second) {  //获取对应优先级，fisrt为前操作符，second为后操作符
        int x=-1,y=-1;  //根据first和second记录优先级对应坐标

        switch (first) {
            case '+':
                x = 0;
                break;
            case '-':
                x = 1;
                break;
            case '*':
                x = 2;
                break;
            case '/':
                x = 3;
                break;
            case '(':
                x = 4;
                break;
            case ')':
                x = 5;
                break;
            case '#':
                x = 6;
                break;
        }

        switch (second) {
            case '+':
                y = 0;
                break;
            case '-':
                y = 1;
                break;
            case '*':
                y = 2;
                break;
            case '/':
                y = 3;
                break;
            case '(':
                y = 4;
                break;
            case ')':
                y = 5;
                break;
            case '#':
                y = 6;
                break;
        }

        return this.priority[x][y];
    }

   public void operation(String str) {
       //opt栈，用来存放操作符
       Stack<Character> opt = new Stack();
       opt.push('#'); //初始化，将'#'设为栈底元素

       //arr栈，存放操作数
       Stack<Integer> arr = new Stack();

       str += '#';
       char[] s = str.toCharArray();

       for (int i = 0; i < s.length; i++) {
           if (s[i] >=48 && s[i] <= 57) {
                arr.push((int)s[i] - 48);
           } else {
               switch (calPriority(opt.peek(), s[i])) {
                   case '<':
                       opt.push(s[i]);
                       break;
                   case '=':
                       opt.pop();
                       break;
                   case '>':
                       int second = arr.pop();
                       arr.push(calculate(opt.pop(), arr.pop(), second));
                       i--;
                       break;
                   case '#':
                       if (!(i == s.length - 1)) {
                           System.out.println("表达式错误！#");
                       }
                       return;
                   default:
                       System.out.println("表达式错误！*");
                       return;
               }
           }
       }

       System.out.println(str + "=" + arr.pop());
   }

    public int calculate(char op, int first, int second) {
        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
        }
        return 0;
    }

    public static void main(String[] args) {
        String testStr = "(5+2)*3-6/(2+4)"; //结果应为20
        ExpressionEvaluation ee = new ExpressionEvaluation();
        ee.operation(testStr);
    }
}
