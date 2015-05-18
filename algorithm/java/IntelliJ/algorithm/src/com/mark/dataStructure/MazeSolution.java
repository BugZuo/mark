package com.mark.dataStructure;

/**
 * Created by markzuo on 15-5-18.
 */
public class MazeSolution {
        public static void main(String[] args) {

            MazeSolution ms = new MazeSolution();
            int[][] map = ms.initMap(); //迷宫地图

            ms.print(map);
            ms.resolve(map, new Node(1, 1), new Node(8, 8));

        }

        public void resolve(int[][] map, Node start, Node end) {
            //计数器
            int step = 0;

            Stack s = new Stack();
            do {
                    if (map[start.x][start.y] == 0) {//如果可以通过

                        if (start.x == end.x && start.y == end.y) {//到出口，打印迷宫，结束程序
                            map[end.x][end.y] = ++step;
                            print(map);
                            return;
                        }

                        Node record = new Node(start.x, start.y, start.di);
                        s.push(record);//压栈

                        map[start.x][start.y] = ++step;//留下足迹

                        start = nextNode(start, 1); //当前点转移到东面的相邻点
                    } else { //如果不能通过
                        start = s.peek(); //退栈，当前点置为上一点
                        s.pop();
                        map[start.x][start.y] = --step;

                        while (start.di == 4 && !s.isEmpty()) { //该点不可通过，设标志-2
                            map[start.x][start.y] = -2;
                            start = s.peek();//当前点继续回退到上一点

                            s.pop();
                            --step;
                        }

                        if (start.di < 4) { //尝试其他方向
                            start.di += 1; //将方向变向下一个

                            Node record = new Node(start.x, start.y, start.di);
                            s.push(record); //记录该点

                            map[start.x][start.y] = ++step;
                            start = nextNode(start, start.di);  //尝试该方向上相邻的一点
                        }
                    }
            } while (!s.isEmpty());

        }

        //初始化迷宫
        public int[][] initMap() {
            int n = 10;

            int[][] map = new int[n][n]; //迷宫地图

            //初始化外墙
            for (int i = 0; i < 10; i++) {
                map[0][i] = -1;
                map[i][0] = -1;
                map[n-1][i] = -1;
                map[i][n-1] = -1;
            }

            //初始化内部墙
            map[1][3] = map[2][3] = map[1][7] = map[2][7] = map[3][5] = map[3][6] =
                        map[4][2] = map[4][3] = map[4][4] = map[5][4] = map[6][2] =
                        map[6][6] = map[7][2] = map[7][3] = map[7][4] = map[7][6] =
                        map[7][7] = map[8][1] = -1;

            return map;
        }

        //画出迷宫
        public void print(int[][] map) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    switch (map[i][j]) {
                        case -1:
                            System.out.print("# ");
                            break;
                        case 0:
                            System.out.print("0 ");
                            break;
                        case -2:
                            System.out.print("@ ");
                            break;
                        default:
                            System.out.print(map[i][j] + " ");
                            break;
                    }
                }
                System.out.println();
            }
        }

        public Node nextNode(Node n, int di) {
            switch (di) {
                case 1:
                    n.y = n.y + 1;
                    break;
                case 2:
                    n.x += 1;
                    break;
                case 3:
                    n.y -= 1;
                    break;
                case 4:
                    n.x -= 1;
                    break;
            }

            return new Node(n.x, n.y);
        }
}

class Node {
    int x, y;
    int di = 1;
    Node next;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        next = null;
    }

    public Node(int x, int y, int di) {
        this(x, y);
        this.di = di;
    }
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public Node peek() {
        if (this.top != null) {
            return this.top;
        } else {
            return null;
        }
    }

    public void push(Node n) {
        n.next = this.top;
        this.top = n;
    }

    public Node pop() {
        if (this.top != null) {
            Node temp = new Node(top.x, top.y, top.di);
            this.top = this.top.next;
            return temp;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
