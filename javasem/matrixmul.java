package javasem;
import java.util.Arrays;

class Matrix {
    int row, col;
    double[][] mat;

    // Constructor with row and col size
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        mat = new double[row][col];
    }

    // Constructor with 2D array
    public Matrix(double[][] data) {
        this.row = data.length;
        this.col = data[0].length;
        this.mat = new double[row][col];

        // Copy elements to avoid reference issues
        for (int i = 0; i < row; i++)
            System.arraycopy(data[i], 0, this.mat[i], 0, col);
    }

    // Matrix multiplication
    public Matrix multiply(Matrix other) {
        if (this.col != other.row) {
            System.out.println("Incompatible dimensions");
            return new Matrix(0, 0);
        }

        Matrix product = new Matrix(this.row, other.col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < other.col; j++) {
                for (int k = 0; k < col; k++) {
                    product.mat[i][j] += this.mat[i][k] * other.mat[k][j];
                }
                // Rounding result to 3 decimal places
                product.mat[i][j] = Math.round(product.mat[i][j] * 1000) / 1000.0;
            }
        }
        return product;
    }

    // Display the matrix
    public void display() {
        for (double[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }



public class matrixmul {
    public static void main(String[] args) {
        double[][] a = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        double[][] b = {{14}, {11}, {11}};

        Matrix A = new Matrix(a);
        Matrix B = new Matrix(b);
        Matrix result = A.multiply(B);

        System.out.println("Resultant Matrix:");
        result.display();
    }
}
}

