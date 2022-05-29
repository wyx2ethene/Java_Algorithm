package com.wyx;

/**
 * 二维数组转稀疏数组思路：
 * 1. 遍历原始数组，得到有效数据个数sum
 * 2. 根据sum创建稀疏数组sparseArr int[sum+1][3]，列数固定为3，分别为行row，列col，值val
 * 3. 将二维数组的有效数据存入稀疏数组
 * <p>
 * 稀疏数组转二维数组思路：
 * 1. 读取稀疏数组第一行，根据第一行数据，创建原始二维数组
 * 2. 分别读取稀疏数组后几行数据，并赋给二维数组即可
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始二维数组，6行7列JKM
        int[][] dimArr = new int[6][7];
        //在指定位置填入数据GHY45=
        dimArr[1][2] = 1;
        dimArr[2][3] = 2;
        dimArr[4][5] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组：");
        for (int[] row : dimArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        dimArr2SparseArr(dimArr);

        int[][] sparseArr = new int[4][3];
        sparseArr[0][0] = 6;
        sparseArr[0][1] = 7;
        sparseArr[0][2] = 3;
        sparseArr[1][0] = 1;
        sparseArr[1][1] = 2;
        sparseArr[1][2] = 1;
        sparseArr[2][0] = 2;
        sparseArr[2][1] = 3;
        sparseArr[2][2] = 2;
        sparseArr[3][0] = 4;
        sparseArr[3][1] = 5;
        sparseArr[3][2] = 2;
        sparseArr2DimArr(sparseArr);
    }

    /**
     * 二维数组转稀疏数组
     *
     * @param dimArr 二维数组
     */
    private static void dimArr2SparseArr(int[][] dimArr) {
        // 遍历原始数组，得到有效数据个数sum
        int sum = 0;
        for (int[] row : dimArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        // 根据sum创建稀疏数组sparseArr int[sum+1][3]，列数固定为3，分别为行row，列col，值val
        int[][] sparseArr = new int[sum + 1][3];
        //将二维数组的有效数据存入稀疏数组
        sparseArr[0][0] = dimArr.length;
        sparseArr[0][1] = dimArr[0].length;
        sparseArr[0][2] = sum;
        // i记录稀疏数组的行列数，由于第一行已经被填充，故i从1开始
        int i = 1;
        for (int row = 0; row < dimArr.length; row++) {
            for (int col = 0; col < dimArr[row].length; col++) {
                int val = dimArr[row][col];
                if (val != 0) {
                    sparseArr[i][0] = row;
                    sparseArr[i][1] = col;
                    sparseArr[i][2] = val;
                    i++;
                }
            }
        }
        // 输出稀疏数组
        System.out.println("稀疏数组：");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 稀疏数组转二维数组
     *
     * @param sparseArr 稀疏数组
     */
    private static void sparseArr2DimArr(int[][] sparseArr) {
        // 读取稀疏数组第一行，根据第一行数据，创建原始二维数组
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] dimArr = new int[row][col];
        // 分别读取稀疏数组后几行数据，并赋给二维数组即可
        // r代表行，因为i第一行已被读取，故r从1开始
        for (int r = 1; r < sparseArr.length; r++) {
            //获取dimArr中有效数据所在行索引
            int dim_row = sparseArr[r][0];
            //获取dimArr中有效数据所在列索引
            int dim_col = sparseArr[r][1];
            //获取dimArr中有效数据的值
            int dim_val = sparseArr[r][2];
            //赋值
            dimArr[dim_row][dim_col] = dim_val;
        }
        // 输出二维数组
        System.out.println("二维数组：");
        for (int[] rows : dimArr) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
