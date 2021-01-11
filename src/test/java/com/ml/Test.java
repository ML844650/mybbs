package com.ml;

import sun.nio.ch.FileKey;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Test.printMarix();
        Test.calPI();

//        Test.dayushaiwang();

    }

    /**
     * 2： 定义两个变量n和m  打印如下效果的矩阵
     * 如n=5 m=6
     * 1  2  3  4  5  6
     * 12 11 10 9  8  7
     * 13 14 15 16 17 18
     * 24 23 22 21 20 19
     * 25 26 27 28 29 30
     */
    public static void printMarix() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i, j;
        int num = 0;
        for (i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                for (j = 1; j <= m; j++) {
                    ++num;
                    System.out.print(num + "\t");
                }
            } else {
                num += m;
                for (j = 1; j <= m; j++) {
                    System.out.print(num + "\t");
                    num--;
                }
                num += m;
            }
            System.out.println();
        }

    }

    /**
     * 扩展题9： 计算圆周率
     * 中国古代数学家研究出了计算圆周率最简单的办法:
     * PI=4/1-4/3+4/5-4/7+4/9-4/11+4/13-4/15+4/17......
     * 这个算式的结果会无限接近于圆周率的值,
     * 我国古代数学家祖冲之计算出,圆周率在3.1415926 和3.1415927 之间,
     * 请编程计算,要想得到这样的结果,他要经过多少次加减法运算?
     * 注意：此题需要研究 循环的条件和每次加减的数的规律
     */
    public static void calPI() {
        double fm = 3.0, PI = 4 / 1.0;
        int op = -1;
        int cnt = 0;
        while (PI < 3.1415926 || PI > 3.1415927) {
            PI += op * 4 / fm;
            fm += 2;
            op *= -1;
            cnt++;
        }
        System.out.println("经过了" + cnt + "次加减法运算");
    }

    /**
     * 扩展题10： 打渔还是晒网
     * 中国有句老话叫“三天打渔，两天晒网” 。
     * 假设有一个人从2000 年1 月1 日开始“三天打渔两天晒网” ，
     * 判断今天这个人是在打渔还是在晒网？
     * 注意：此题需要使用%  和判断月份的天数
     */
    public static void dayushaiwang() {
        Scanner scanner = new Scanner(System.in);
        for (int u=1;u<10;u++){
            System.out.println("依次输入年,月,日(2000.1.1之后)");
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int num = 0;
            for (int i = 2000; i < year; i++) {
                if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
                    num += 366;
                else num += 365;
            }
            for (int j = 1; j < month; j++) {
                if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12) {
                    num += 31;
                } else if (j == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                    num += 29;
                } else if (j == 2) {
                    num += 28;
                } else num += 30;
            }
            num += day;
            System.out.println("从2000.1.1到" + year + "." + month + "." + day + "总共" + num + "天");
            int flag=num%5;
            if(flag==0 || flag==4){
                System.out.println("在晒网");
            }else {
                System.out.println("在打渔");
            }
        }
    }
}
