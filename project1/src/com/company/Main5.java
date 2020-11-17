package com.company;

class Returner {
    int[] valuesArr;
    int[] scalesArr;
    int[] rangesArr;
    int sum = 0;

    public Returner(int[] values, int[] scales) {
        valuesArr = values;
        scalesArr = scales;
        rangesArr = new int[valuesArr.length];

        // Сумма отрехков
        sum = 0;

        for (int i = 0; i < scalesArr.length; i++)
            sum += scalesArr[i];

        int s = 0;
        for (int i = 0; i < rangesArr.length; i++) {
            rangesArr[i] = s;
            s += scalesArr[i];
        }
    }


    public int getNumber() {
        int random = (int) (Math.random() * (sum - 1));

        int index = 0;
        for (int i = 0; i < rangesArr.length; i++) {
            if (rangesArr[i] > random)
                break;
            index = i;
        }

        return valuesArr[index];
    }
}
//Класс возвращает случайный элемент массива
public class Main5 {

    public static void main(String[] args) {

        int[] values = {1, 2, 3};
        int[] scales = {1, 2, 10};

        Returner returner = new Returner(values, scales);
        int returnValue = returner.getNumber();
        System.out.println("Возвращенное значение: "+returnValue);
        //Значение 1 должно встречаться в 2 раза реж чем 2, и в 10 раз реже чем 3
    }

}
