package com.gtm.array;

import java.util.Scanner;

public class SpiralArrPrint {

	public static void printArr(int m, int n, int[][]mat){
		int i,c = 0,r = 0, row = m-1, col = n-1;
		while (r <= row && c <= col) {
			for (i = c; i <= col; i++) {
				System.out.print(mat[r][i]+" ");
			}
			r++;
			for (i = r; i <= row; i++) {
				System.out.print(mat[i][col]+" ");
			}
			col--;
			if(r < row){
				for (i = col; i >= c; i--)  {
					System.out.print(mat[row][i]+" ");
				}
				row--;
			}
			if(c < col){
				for (i = row; i >= r; i--)  {
					System.out.print(mat[i][c]+" ");
				}
				c++;
			}


		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows :");
		int m = Integer.parseInt(sc.nextLine());
		System.out.println("Enter no of columns :");
		int n = Integer.parseInt(sc.nextLine());
		int mat[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Enter a no :");
				int no = Integer.parseInt(sc.nextLine());
				mat[i][j] = no;
			}
		}
		sc.close();
		System.out.print("{");
		for (int i = 0; i < m; i++) {
			System.out.print("{");
			for (int j = 0; j < n; j++) {
				if(j<n-1)
					System.out.print(mat[i][j]+", ");
				else
					System.out.print(mat[i][j]);
			}
			if(i<n-1)
				System.out.print("}\n"+' ');
			else
				System.out.print("}");
		}
		System.out.print("}\n");
		/*int m=4,n=6;
		int mat[][] = {{1,  2,  3,  4,  5,  6},
				       {7,  8,  9,  10, 11, 12},
				       {13, 14, 15, 16, 17, 18},
				       {13, 14, 15, 16, 17, 18}};*/
		printArr(m, n, mat);
	}

}
