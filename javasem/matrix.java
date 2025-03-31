package javasem;
import java.util.*;

//import java.util.*;


public class matrix {
	int row,col;
	//double [][]mat;
	double mat[][];
	matrix(double A[][]) {
		this.row=A.length;
		this.col=A[0].length;
		this.mat=A;
	}
	
	matrix(int row, int col){
		this.row=row;
		this.col=col;
		this.mat=new double[row][col];
	}
	
	void display() {
		for(int i=0; i<row;i++) {
			for (int j=0;j<col;j++) {
		System.out.print(mat[i][j] + " ");
	}
			System.out.println();
		}
}
	matrix addition(matrix other) {
		if (this.row != other.row || this.col != other.col) {
			System.out.println("Invalid can't be added");
			return new matrix(0,0);
					}
		else {
        matrix sum = new matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum.mat[i][j] = this.mat[i][j] + other.mat[i][j];
            }
        }
        return sum;
	}
	}
	
	matrix subtract(matrix other) {
        if (this.row != other.row || this.col != other.col) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for subtraction.");
        }
        matrix diff = new matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                diff.mat[i][j] = this.mat[i][j] - other.mat[i][j];
            }
        }
        return diff;
    }
	
	matrix multiply(matrix other) {
		if (this.col != other.row) {
			System.out.println("incompatible dimensions");
			return new matrix(0,0);
			}
		else {
			matrix prod=new matrix(this.row,other.col);
				for(int i=0; i<row;i++) {
				for (int k=0;k<col;k++) {
				for(int j=0;j<other.col;j++) {
					prod.mat[i][j]= prod.mat[i][j] + this.mat[i][k] * other.mat[k][j];
				}
				 		}
	}
				return prod;
		}
	}
	
	matrix transpose() {
		matrix T= new matrix(col,row);
		for(int i=0; i<row;i++) {			
			for (int j=0;j<col;j++) T.mat[j][i]=this.mat[i][j];
		}
		return T;
	}
	
	
	matrix RowRemove(int r){
		matrix R= new matrix(row-1,col);
		for(int j=0; j<col;j++) {
			for (int i=0,CurrRow=0;i<row;i++) {
			if(i!=r) {
				R.mat[CurrRow][j]=this.mat[i][j];
				CurrRow +=1;
			}
		}
	}
		return R;
	}
	
	matrix ColRemove(int c){
		matrix C= new matrix(row,col-1);
		for(int i=0; i<row;i++) {
			for (int j=0,CurrCol=0;j<col;j++) {
			if(j!=c) {
				C.mat[i][CurrCol]=this.mat[i][j];
				CurrCol +=1;
			}
		}
	}
		return C;
	}

	matrix minor(int i,int j) {
		matrix m1=this.RowRemove(i);
		matrix n1=m1.ColRemove(j);
		return n1;
		}
	
    double determinant() {
		if(row==1 && col==1)return mat[0][0];
		else {
		double d=0;
		for(int j=0;j<col;j++) {
			d=d+Math.pow(-1, j)*mat[0][j]*minor(0,j).determinant();
		}
		return d;
		}
	}

	matrix adjoint() {
		matrix A=new matrix(row,col);
		for(int i=0;i<row;i++) {
		for(int j=0;j<col;j++) A.mat[i][j]=Math.pow(-1,i+j)*this.minor(i, j).determinant();
		}
		return A.transpose();
	 }
	matrix inverse() {
		matrix I=new matrix(row,col);
		double d=determinant();
		for(int i=0;i<row;i++) {
		for(int j=0;j<col;j++)I.mat[i][j]=adjoint().mat[i][j]/d;}
	return I;
		}
	
	void round() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) 
				mat[i][j]=Math.round(mat[i][j]*1000)/1000.0;
		}
	}
	
	/*public static void main(String[] args) {
	double [][]A= {{1,2,3},{4,5,6},{7,8,9}};
	matrix m = new matrix(A);
	
	double[][]B= {{9, 8, 7},{6, 5, 4},{3, 2, 1}};
	matrix n=new matrix(B);

    System.out.println("Original Matrix:");
    m.display();
    System.out.println("Addition Result:");
    m.addition(n).display();
    System.out.println("Subtraction Result:");
    m.subtract(n).display();
    
    double[][] data1 = { {1, 2},{3, 4}};
    double[][] data2 = {{5, 6},{7, 8}};
    matrix m1 = new matrix(data1);
    matrix m2 = new matrix(data2);
    System.out.println("Multiplication Result:");
    m1.mul(m2).display();
    
    System.out.println("Transpose Result:");
    m.tr().display();
    
    System.out.println("\nAfter Removing Row 0:");
    m.RowRemove(0).display();

    System.out.println("\nDeterminant:");
    System.out.println(m.det());

    double[][]C= {{4, 7},{2, 6}};
    matrix mm = new matrix(C);
    System.out.println("Inverse Matrix:");
    mm.inv().display();
    
    System.out.println("Matrix after removing row 1:");
    m.RowRemove(1).display();
    System.out.println("Matrix after removing column 2:");
    m.ColRemove(2).display();
	
	Scanner sc = new Scanner(System.in);

	    // Taking matrix size as input
	    System.out.print("Enter the number of rows: ");
	    int rows = sc.nextInt();
	    System.out.print("Enter the number of columns: ");
	    int cols = sc.nextInt();
		double[][] A = new double[rows][cols];
        double[][] B = new double[rows][1];
        
        // Input Matrix A
        System.out.println("Enter the coefficients of matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = sc.nextDouble();
            }
        }

        // Input Matrix B
        System.out.println("Enter the constants of matrix B:");
        for (int i = 0; i < rows; i++) {
            B[i][0] = sc.nextDouble();
        }

        // Creating matrix objects
        matrix m = new matrix(A);
        matrix n = new matrix(B);

        // Checking if determinant is non-zero (only then inverse exists)
        if (m.determinant() == 0) {
            System.out.println("No unique solution exists (determinant is zero).");
        } else {
            matrix m_inv = m.inverse();
            matrix X = m_inv.multiply(n);

            System.out.println("Solution:");
            for (int i = 0; i < X.row; i++) {
                System.out.printf("%.5f\n", X.mat[i][0]); // Print rounded solution
            }
        }

        sc.close(); // Close scanner*/
}

