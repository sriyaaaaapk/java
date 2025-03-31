package Collections;
import java.lang.Math;

public class Matrix {
    int row, col;
    double[][] mat;

    // Constructor from 2D array
    Matrix(double A[][]) {
        this.row = A.length;
        this.col = A[0].length;
        this.mat = new double[row][col];

        // Copying elements
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                this.mat[i][j] = A[i][j];
    }

    // Constructor with row and col size
    Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.mat = new double[row][col];
    }

    // Display Matrix
    void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Matrix multiplication
    Matrix mul(Matrix other) {
        if (this.col != other.row) {
            System.out.println("Incompatible Dimensions");
            return new Matrix(0, 0);
        } else {
            Matrix prod = new Matrix(this.row, other.col);
            for (int i = 0; i < row; i++) {
                for (int k = 0; k < col; k++) {
                    for (int j = 0; j < other.col; j++) { // FIXED: `j+++` to `j++`
                        prod.mat[i][j] += this.mat[i][k] * other.mat[k][j];
                    }
                }
            }
            return prod;
        }
    }

    // Transpose of a matrix
    Matrix tr() {
        Matrix T = new Matrix(col, row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                T.mat[j][i] = this.mat[i][j];
        }
        return T;
    }

    // Remove row
    Matrix RowRemove(int r) {
        Matrix R = new Matrix(row - 1, col);
        for (int j = 0; j < col; j++) {
            for (int i = 0, CurrRow = 0; i < row; i++) {
                if (i != r) {
                    R.mat[CurrRow][j] = this.mat[i][j];
                    CurrRow++;
                }
            }
        }
        return R;
    }

    // Remove column
    Matrix ColRemove(int c) {
        Matrix C = new Matrix(row, col - 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0, CurrCol = 0; j < col; j++) {
                if (j != c) {
                    C.mat[i][CurrCol] = this.mat[i][j];
                    CurrCol++;
                }
            }
        }
        return C;
    }

    // Minor matrix
    Matrix minor(int i, int j) {
        return this.RowRemove(i).ColRemove(j);
    }

    // Determinant calculation (recursive)
    double det() {
        if (row != col) {
            throw new IllegalArgumentException("Determinant can only be calculated for square matrices.");
        }
        if (row == 1) return mat[0][0];
        if (row == 2) return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);

        double d = 0;
        for (int j = 0; j < col; j++) {
            d += Math.pow(-1, j) * mat[0][j] * minor(0, j).det();
        }
        return d;
    }

    // Adjugate matrix
    Matrix adj() {
        Matrix A = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                A.mat[i][j] = Math.pow(-1, i + j) * this.minor(i, j).det();
        }
        return A.tr();
    }

    // Inverse matrix
    Matrix inv() {
        double d = det();
        if (d == 0) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted.");
        }
        Matrix I = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                I.mat[i][j] = adj().mat[i][j] / d;
            }
        }
        return I;
    }

    // Round elements to 3 decimal places
    void round() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                mat[i][j] = Math.round(mat[i][j] * 1000) / 1000.0;
        }
    }

    public static void main(String[] args) {
        double A[][] = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        Matrix m = new Matrix(A);

        Matrix Min = m.inv();
        Min.round();

        double[][] r = {{14}, {11}, {11}};
        Matrix b = new Matrix(r);
        Matrix x = Min.mul(b);
        System.out.println("Determinant of A: " + m.det());
        System.out.println("Inverse of A:");
        Min.display();
        System.out.println("Solution x:");
        x.display();

    }
}
