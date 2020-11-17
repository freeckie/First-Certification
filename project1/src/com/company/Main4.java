package com.company;

abstract class Shape4 {
    private double volume;

    //Установка объёма
    public void setVolume(double volume) {
        this.volume = volume;
    }

    //Получение объёма
    public double getVolume() {
        return this.volume;
    }

}

abstract class Pyramid4 extends Shape {
    private double s;
    private double h;

}

class Box4 extends Shape4 {


    //Добавление фигуры в контейнер
    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return false;
        } else {
            //Оставшееся свободное место
            double freeVolume = this.getVolume() - shape.getVolume();
            this.setVolume(freeVolume);
            return true;
        }
    }
}

class SolidOfRevolution4 extends Shape4 {
    private double radius;

    public double getRadius() {
        return radius;
    }

}

abstract class Cylinder4 extends SolidOfRevolution4 {
    private double height;


}

class Ball4 extends SolidOfRevolution4 {

}


public class Main4 {

    public static void main(String[] args) {
        //Бокс куда складываем наши фигуры
        Box box = new Box();
        //Максимальный объём коробки, в случае переполнения обьекты нельзя добавить
        box.setVolume(100);

        //Объект шар объемом 50
        Ball ball1 = new Ball();
        ball1.setVolume(50);


        //Добавляем первый шар в коробку
        System.out.println("\nОбъём коробки: " + box.getVolume());
        boolean result = box.add(ball1);
        System.out.println("Можно ли добавить: " + result);
        System.out.println("Остаток объёма коробки: " + box.getVolume());

        //Добавим объект для заполнения коробки
        SolidOfRevolution obj = new SolidOfRevolution();
        obj.setVolume(50);
        System.out.println("\nОбъём коробки: " + box.getVolume());
        result = box.add(obj);
        System.out.println("Можно ли добавить: " + result);
        System.out.println("Остаток объёма коробки: " + box.getVolume());

    }
}
