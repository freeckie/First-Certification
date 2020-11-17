package com.company;
import org.jetbrains.annotations.Contract;

import java.util.Random;

/*
Создаем Класс матрицы
 */
class Matrix {

    int z;
    int x;
    double[][] thisMatrix;

    //Конструктор матрицы
    public Matrix(int z, int x) {
        this.thisMatrix = new double[z][x];
        this.z = z;
        this.x = x;
        this.inicial();
    }

    //Передача готовой матрицы
    @Contract(pure = true)
    public Matrix(double[][] thisMatrix) {
        this.thisMatrix = thisMatrix;
        this.z = thisMatrix.length;
        this.x = thisMatrix[0].length;
    }

    //Инициализатор матрицы
    private void inicial() {

        Random random = new Random();
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                thisMatrix[i][j] = random.nextInt(100);
            }
        }
    }

    //Вывод самой матрицы
    public void getvalue() {
        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[i].length; j++) {
                System.out.printf("%.2f  ", thisMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    //Умножение матрицы на число
    public Matrix numberMultiplication(double inputNumber){
        double[][] resultMatrix = new double[this.z][this.x];

        for (int i = 0; i < this.z; i++) {
            for (int j = 0; j < this.x; j++) {
                double result = this.thisMatrix[i][j] * inputNumber;
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }

    //Вычисление транспонированной матрицы
    public Matrix transpose() {

        double[][] resultMatrix = new double[this.x][this.z];
        for (int i = 0; i < this.z; i++)
            for (int j = 0; j < this.x; j++)
                resultMatrix[j][i] = thisMatrix[i][j];
        return new Matrix(resultMatrix);
    }

    //Матрицы и стпень
    public Matrix exponentiation(int N) {

        if (this.z != this.x) {
            System.out.println("Необходима квадратная матрица для ее возведения в степень!");
            return null;
        }

        Matrix newMatrix = this;
        Matrix currentMatrix = this;

        int currentN = 1;
        while (currentN < N) {
            MatrixExecuter obj = new MatrixExecuter(newMatrix, currentMatrix);
            newMatrix = obj.composition();
            currentN++;
        }
        return newMatrix;
    }
}

/*
Операции с несколькими матрицами
 */
class MatrixExecuter {

    Matrix matrix1;
    Matrix matrix2;

    public MatrixExecuter(Matrix obj1, Matrix obj2) {
        this.matrix1 = obj1;
        this.matrix2 = obj2;
    }

    //Произведение
    public Matrix composition() {

        if (matrix1.x != matrix2.z) {
            System.out.println("Кол-во столбцов матрицы != кол-ву строк");
            return null;
        }
        double[][] resultMatrix = new double[matrix1.z][matrix2.x];

        for (int i = 0; i < matrix1.z; i++) {
            for (int j = 0; j < matrix2.x; j++) {
                for (int k = 0; k < matrix1.x; k++) {
                    resultMatrix[i][j] += matrix1.thisMatrix[i][k] * matrix2.thisMatrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
    }

    //Сумма
    public Matrix summ() {
        if ((matrix1.z != matrix2.z) || (matrix1.x != matrix2.x)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultMatrix = new double[matrix1.z][matrix1.x];

            for (int i = 0; i < matrix1.z; i++) {
                for (int j = 0; j < matrix1.x; j++) {
                    double result = matrix1.thisMatrix[i][j] + matrix2.thisMatrix[i][j];
                    resultMatrix[i][j] = result;
                }
            }
            return new Matrix(resultMatrix);
        }
    }

    //Разность
    public Matrix difference() {
        if ((matrix1.z != matrix2.z) || (matrix1.x != matrix2.x)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultMatrix = new double[matrix1.z][matrix1.x];

            for (int i = 0; i < matrix1.z; i++) {
                for (int j = 0; j < matrix1.x; j++) {
                    double result = matrix1.thisMatrix[i][j] - matrix2.thisMatrix[i][j];
                    resultMatrix[i][j] = result;
                }
            }

            return new Matrix(resultMatrix);
        }
    }
}


public class Main {

    public static void main(String[] args) {

        Matrix obj1 = new Matrix(4, 2);
        Matrix obj2 = new Matrix(2, 2);
        System.out.println("Матрица А:");
        obj1.getvalue();
        System.out.println("\nМатрица B:");
        obj2.getvalue();

        System.out.println("\nТранспонированная матрца A:");
        Matrix transposed_obj1 = obj1.transpose();
        transposed_obj1.getvalue();
        System.out.println("\nТранспонированная матрца B:");
        Matrix transposed_obj2 = obj2.transpose();
        transposed_obj2.getvalue();

        double multiNumber = 4.2;
        System.out.println("\nУмножение матрицы А на число " + multiNumber);
        Matrix result = obj1.numberMultiplication(multiNumber);
        if (result != null)
            result.getvalue();

        //Сумма матриц
        MatrixExecuter executerObj = new MatrixExecuter(obj1, obj2);
        System.out.println("\nСумма:");
        result = executerObj.summ();
        if (result != null)
            result.getvalue();

        //Разность
        System.out.println("\nРазность:");
        result = executerObj.difference();
        if (result != null)
            result.getvalue();

        //Другая размерность матриц для произведения
        Matrix obj3 = new Matrix(3, 4);
        Matrix obj4 = new Matrix(3, 2);
        System.out.println("\nМатрица C:");
        obj3.getvalue();
        System.out.println("\nМатрица D:");
        obj4.getvalue();
        executerObj = new MatrixExecuter(obj3, obj4);
        System.out.println("\nПроизведение C*D:");
        result = executerObj.composition();
        if (result != null)
            result.getvalue();

        //Возведение квадратной матрицы в степень
        int N = 3;
        Matrix obj5 = new Matrix(2, 2);
        System.out.println("\nМатрица E:");
        obj5.getvalue();
        System.out.println("\nМатрица E в степени " + N);
        result = obj5.exponentiation(N);
        if (result != null)
            result.getvalue();

    }
}