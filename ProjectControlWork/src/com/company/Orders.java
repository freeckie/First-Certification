package com.company;
import java.util.ArrayList;

public class Orders {

    int OrderTable;
    double OrderSum;
    ArrayList<Menu> orders = new ArrayList<>();

    public Orders(int OrderTable) {
        this.OrderTable = OrderTable;
    }

    public void add(String name) {
        if (Menu.menuHashMap.containsKey(name)) {
            if (Menu.menuHashMap.get(name).amount == 0) {
                Menu.stopList.put(name, Menu.menuHashMap.get(name));
                System.out.println("Извините, но " + name + " закончился.");
            } else {
                Menu.menuHashMap.get(name).setAmount(Menu.menuHashMap.get(name).amount - 1);
                setOrderSum(Menu.menuHashMap.get(name).price);
                orders.add(Menu.menuHashMap.get(name));
                System.out.println(name + " заказ добавлен.");
            }
        } else
            System.out.println("Простите, " + name + " данное блюдо не входит в наше меню.");
    }

    public void printOrders() {
        System.out.println("Таблица заказорв" + OrderTable);
        for (Menu value : orders) {
            System.out.println(value.toString());
        }
    }
    public void closeTable() {
        System.out.println("таблица заказов " + OrderTable);
        orders.clear();
        setOrderSum(0);
        System.out.println("Зыкрыта");
    }

    public void setOrderSum(double orderSum) {
        this. OrderSum += orderSum;
    }

    public double getOrderSum() {
        return  OrderSum;
    }
}