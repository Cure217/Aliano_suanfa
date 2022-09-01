package Test.Test4;

/**
 * @Author Cure
 * @Time 2022/5/25 15:56
 */
import java.util.Scanner;

public class AHP {

    /*
1	2	3
1/2	1	2/3
1/3	3/2	1
     *
6
1  1  1  4  1  1/2
1  1  2  4  1  1/2
1  1/2  1  5  3  1/2
1/4  1/4  1/5  1  1/3  1/3
1  1  1/3  3  1  1
2  2  2  3  1  1
     */
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double d[][] = new double[n][n];
        double temp[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sToD = SToD(scanner.next());
                d[i][j] = sToD;
                temp[i][j] = sToD;
            }
        }

        System.out.println("以下是判断矩阵");
        // 得到判断矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f\t", d[i][j]);
            }
            System.out.println();
        }

        // 1.对判断矩阵进行求和
        System.out.println("列相加结果");

        double w1[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w1[i] = w1[i] + d[j][i];
            }
            System.out.printf("%.2f\t", w1[i]);
        }

        // 2.相除
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = d[i][j] / w1[j];
            }
        }
        System.out.println("和积法第一步求出的结果");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f\t", d[i][j]);
            }
            System.out.println();
        }

        System.out.println("对第一步求出的结果进行 行相加");

        System.out.println("行相加结果");

        double w2[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w2[i] = w2[i] + d[i][j];
            }
            System.out.printf("\t%.2f\n", w2[i]);
        }

        System.out.println("特征向量求解第一步 ： 将上面的行相加的所有结果相加：");
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += w2[i];
        }
        System.out.printf("结果为sum = \t%.2f\n", sum);

        System.out.println("将行结果与 sum 相除 得出结果为 ：  ");
        double w3[] = new double[n];
        for (int i = 0; i < n; i++) {
            w3[i] = w2[i] / sum;
            System.out.printf("\t%.2f\n", w3[i]);
        }

        System.out.println();
        System.out.println("用和积法计算其最大特征向量为：W = ");
        // 以下是校验
        System.out.printf("(");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f ,", w3[i]);
        }
        System.out.printf(")");

        System.out.println("\nBW = ");
        double w4[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w4[i] = w4[i] + temp[i][j] * w3[j];
            }
            System.out.printf("%.3f \t", w4[i]);
        }
        System.out.println("\n----------------------------------------");
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            sum2 = sum2 + w4[i];
        }
        System.out.printf("得到sum2\t %.2f\n", sum2);

        System.out.println("最大的特征向量为 ：  ");

        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result = result + w4[i] / (6 * w3[i]);
        }
        System.out.printf(" %.2f \n", result);

        System.out.println("\n判断矩阵一致性指标C.I.(Consistency Index)");
        double CI = (result - n) / (n - 1);
        System.out.printf(" %.2f \n", CI);

        System.out.println("随机一致性比率C.R.(Consistency Ratio)。");

		/*
		 *
		 n  1  2  3  	4  		5	  6	  7		  8		 9	  10	  11
		RI  0  0  0.58  0.90  1.12  1.24  1.32  1.41  1.45  1.49  1.51
		一般，当一致性比率 <0.1 时
		的不一致程度在容许范围之内，可用其归一化特征向量
		作为权向量，否则要重新构造成对比较矩阵，对  加
		以调整
		 */
        double RI = 0.0;
        switch (n) {
            case 0:
                RI=0;
                break;
            case 1:
                RI=0;
                break;
            case 2:
                RI=0;
                break;
            case 3:
                RI=0.58;
                break;
            case 4:
                RI=0.90;
                break;
            case 5:
                RI=1.12;
                break;
            case 6:
                RI=1.24;
                break;
            case 7:
                RI=1.32;
                break;

            default:
                break;
        }
        System.out.printf("C.R =  %.2f \n", CI / RI);

        scanner.close();
    }

    public static double SToD(String s) {
        String[] p = s.split("/");
        if (p.length > 1) {
            return Double.parseDouble(p[0]) / Double.parseDouble(p[1]);
        }
        return Double.parseDouble(s);
    }
}