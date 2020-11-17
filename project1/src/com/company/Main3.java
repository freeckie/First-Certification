package com.company;

class Shape {
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

class Pyramid extends Shape {
    private double s;
    private double h;

}

class Box extends Shape {


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

class SolidOfRevolution extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

}

class Cylinder extends SolidOfRevolution {
    private double height;


}

class Ball extends SolidOfRevolution {

}


public class Main3 {

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
