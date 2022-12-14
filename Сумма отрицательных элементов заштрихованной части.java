// https://ru.stackoverflow.com/questions/1453006/
// https://studfile.net/preview/5680538/page:36/
// https://studfile.net/preview/1566570/

// Знайти суму від'ємних елементів заштрихованої частини
    @Override
    public double calculate(double[][] array) {

        double sum = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                /*
                 * Если номер строки элемента совпадает с номером столбца (i = j), это означает что элемент лежит на главной диагонали матрицы;
                 * Если номер строки превышает номер столбца (i > j), то элемент находится ниже главной диагонали;
                 * Если номер столбца больше номера строки (i < j), то элемент находится выше главной диагонали;
                 * Элемент лежит на побочной диагонали квадратной матрицы, если его индексы удовлетворяют равенству i + j + 1 = n;
                 * Неравенство i + j + 1 < n характерно для элемента находящегося выше побочной диагонали квадратной матрицы;
                 * соответственно, элементу квадратной матрицы, лежащему ниже побочной диагонали соответствует выражение i + j + 1 > n;
                 *
                 * Для нижнего правого квадрата (четверти) индексы i, j элементов начинаются с N / 2, где N - размер массива
                 */

                if ((i + j + 1 >= array.length) && ((i < array.length / 2) || (j < array.length / 2))) {

                    if (array[i][j] < 0) {

                        sum += array[i][j];
                    }

                }
            }
        }

        return sum;
    }
