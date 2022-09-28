/*
* 1. У головному класі описати метод, що обчислює значення функції, яка задана у
* таблиці і у тестовому класі - тестові методи для нього.
*
* 2. Розробити метод, що за вказаними значеннями кроку, початку та кінця інтервалу
* обчислює кількість кроків для табулювання та тестові методи для нього.
*
* 3. Створити методи, що створюють масиви значень функції (y) та її аргументу (x) в
* усіх точках вказаного інтервалу із заданим кроком. (розмір масивів обчислити програмно за допомогою метода з п.2).
*
* 4. Створити методи, які після формування масивів, знаходять номери найбільшого та найменшого елементів масиву значень функції,
* та методи, що обчислюють та суму та середнє арифметичне елементів масиву значень функції.
*
* 5. Створити методи виведення найбільшого та найменшого елементів масиву значень функції, вказавши їхні номери і відповідні значення аргументу.

*/

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        Main prog = new Main();
        prog.run();
    }

    public double tabulation(double x, double a) {

        double eps = 0.0001;

        if (x > 1.2 - eps) {

            return log10(x + 1);

        } else {

            //y = pow(sin(sqrt(a * x)), 2);
            return (sin(sqrt(a * x))) * (sin(sqrt(a * x)));

        }

    }

    public int calculateSteps(double x1, int x2, double step) {

        return (int) ((x2 - x1) / step) + 1;
    }

    public double[] yValuesArrayCreate(double x1, int x2, double step) {

        return new double[calculateSteps(x1, x2, step)];
    }

    public double[] xValuesArrayCreate(double x1, int x2, double step) {

        return new double[calculateSteps(x1, x2, step)];
    }


    public double[] yValuesArrayFill(double [] xValues, double a) {

        double [] yValues = new double [xValues.length];

        for (int i = 0; i < yValues.length; i++) {

            yValues[i] = tabulation(xValues[i], a);

        }

        return yValues;

    }

    public double[] xValuesArrayFill(double x1, int x2, double step) {

        double [] xValues = xValuesArrayCreate(x1, x2, step);

        for (int i = 0; i < xValues.length; i++) {

            xValues[i] = x1 + i * step;
        }

        return xValues;
    }

    public int getMinIndex(double[] yValues) {

        int minIndex = 0;

        for (int i = 0; i < yValues.length; i++) {

            if (yValues[i] < yValues[minIndex]) {

                minIndex = i;
            }

        }

        return minIndex;
    }

    public double getMinElement(double[] yValues) {

        int minNumber = getMinIndex(yValues);
        return yValues[minNumber];
    }

    public double getMinElementArgument(double[] yValues, double[] xValues) {

        int minNumber = getMinIndex(yValues);
        return xValues[minNumber];
    }

    public int getMaxIndex(double[] yValues) {

        int maxIndex = 0;

        for (int i = 0; i < yValues.length; i++) {

            if (yValues[i] > yValues[maxIndex]) {

                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public double getMaxElement(double[] yValues) {

        int maxNumber = getMaxIndex(yValues);
        return yValues[maxNumber];
    }

    public double getMaxElementArgument(double[] yValues, double[] xValues) {

        int maxNumber = getMaxIndex(yValues);
        return xValues[maxNumber];
    }

    public double getSum(double[] yValues) {

        double sum = 0;
        for (int i = 0; i < yValues.length; i++) {
            sum = sum + yValues[i];
        }

        return sum;
    }

    public double getAverage(double[] yValues) {

        double sum = getSum(yValues);
        double average = 0;

        average = sum / yValues.length;

        return average;

    }

    public void run() {

        double a = 20.3;
        double x1 = 0.5;
        int x2 = 2;
        double step = 0.005;

        double[] xValues = xValuesArrayCreate(x1, x2, step);
        double[] yValues = yValuesArrayCreate(x1, x2, step);

        xValues = xValuesArrayFill(x1, x2, step);
        yValues = yValuesArrayFill(xValues, a);

        System.out.println("Найбільший елемент масиву значень функції: " + getMaxElement(yValues));
        System.out.println("Аргумент найбільшого елементу масиву значень функції: " + getMaxElementArgument(yValues, xValues));
        System.out.println("Індекс найбільшого елементу масиву значень функції: " + getMaxIndex(yValues));
        System.out.println("\n");

        System.out.println("Найменший елемент масиву значень функції: " + getMinElement(yValues));
        System.out.println("Аргумент найменшого елементу масиву значень функції: " + getMinElementArgument(yValues, xValues));
        System.out.println("Індекс найменшого елементу масиву значень функції: " + getMinIndex(yValues));
        System.out.println("\n");

        System.out.println("Сумма елементів массиву значень функції: " + getSum(yValues));
        System.out.println("Середнє арифметичне елементів значень функції: " + getAverage(yValues));
        System.out.println("\n");

    }
}



//------------------------------------------------------------------------------------------------//
// ТЕСТЫ

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {
    Main main;

    @BeforeEach
    void setUp() {

        main = new Main();

    }

    @Test
    void yValuesArrayCreateTest() {

        double[] yValues = null;
        double x1 = 0.5;
        int x2 = 1;
        double step = 0.1;

        yValues = main.yValuesArrayCreate(x1, x2, step);

        assertNotNull(yValues);
    }

    @Test
    void xValuesArrayCreateTest() {

        double[] xValues = null;
        double x1 = 0.5;
        int x2 = 1;
        double step = 0.1;;

        xValues = main.xValuesArrayCreate(x1, x2, step);

        assertNotNull(xValues);
    }

    @Test
    void yValuesArrayFillTest0() {

        double a = 20.3;
        double x1 = 0.5;
        int x2 = 2;
        double step = 0.005;

        double[] xValues = main.xValuesArrayFill(x1, x2, step);
        double[] yValues = main.yValuesArrayFill(xValues, a);

        double element0 = yValues[0];

        assertEquals(0.00196, element0, 0.00001);

    }

    @Test
    void yValuesArrayFillTest140(){

        double a = 20.3;
        double x1 = 0.5;
        int x2 = 2;
        double step = 0.005;

        double[] xValues = main.xValuesArrayFill(x1, x2, step);
        double[] yValues = main.yValuesArrayFill(xValues, a);

        double element140 = yValues[140];

        assertEquals(0.34242, element140, 0.00001);

    }

    @Test
    void yValuesArrayFillTest300(){

        double a = 20.3;
        double x1 = 0.5;
        int x2 = 2;
        double step = 0.005;

        double[] xValues = main.xValuesArrayFill(x1, x2, step);
        double[] yValues = main.yValuesArrayFill(xValues, a);

        double element300 = yValues[300];

        assertEquals(0.47712, element300, 0.00001);
    }


    @Test
    void xValuesArrayFillTest() {

        double x1 = 0.5;
        int x2 = 1;
        double step = 0.1;
        double a = 20.3;

        double[] xValuesTemp = {0.5, 0.6, 0.7, 0.8, 0.9, 1};
        double[] xValues = main.xValuesArrayFill(x1, x2, step);

        assertArrayEquals(xValuesTemp, xValues, 0.01);
    }


    @Test
    void getMinIndexTest() {

        double[] yValues = {2.2, 0.2, 3.0, 1.3};

        int minIndex = main.getMinIndex(yValues);

        assertEquals(1, minIndex);
    }


    @Test
    void getMinElementTest() {

        double[] yValues = {1.1, 2.2, 3.3};

        double minElement = main.getMinElement(yValues);

        assertEquals(1.1, minElement, 0.01);
    }


    @Test
    void getMinElementArgumentTest() {

        double[] yValues = {1.1, 2.2, 3.3};
        double[] xValues = {0.5, 1, 1.5};

        double minElementArgument = main.getMinElementArgument(yValues, xValues);

        assertEquals(0.5, minElementArgument, 0.01);

    }

    @Test
    void getMaxIndexTest() {

        double[] yValues = {2.2, 7.1, 9.0, 5.2};

        int maxIndex = main.getMaxIndex(yValues);

        assertEquals(2, maxIndex);

    }

    @Test
    void getMaxElementTest() {

        double[] yValues = {1.1, 2.2, 3.3};

        double maxElement = main.getMaxElement(yValues);

        assertEquals(3.3, maxElement, 0.01);
    }


    @Test
    void getMaxElementArgumentTest() {

        double[] yValues = {1.1, 2.2, 3.3};
        double[] xValues = {0.5, 1, 1.5};

        double maxElementArgument = main.getMaxElementArgument(yValues, xValues);

        assertEquals(1.5, maxElementArgument, 0.01);
    }

    @Test
    void getSumTest() {

        double[] yValues = {1.1, 2.2, 3.3};

        double sum = main.getSum(yValues);

        assertEquals(6.6, sum, 0.01);

    }

    @Test
    void getAverageTest() {

        double[] yValues = {1.1, 2.2, 3.3};

        double average = main.getAverage(yValues);

        assertEquals(2.2, average, 0.01);
    }


    @Test
    void calculateStepsTest() {

        double x1 = 0.5;
        int x2 = 1;
        double step = 0.1;

        int result = main.calculateSteps(x1, x2, step);

        assertEquals(6, result);
    }


}
