package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Food f1 = new Food("Овсяная каша", 150, 4,
                new HashSet<>(Arrays.asList("Геркулес", "молоко", "сахар", "масло сливочное")));

        Food f2 = new Food("Омлет с помидорами и сыром", 250, 5,
                new HashSet<>(Arrays.asList("Молоко", "яйцо", "помидоры")));

        Food f3 = new Food("Яичница с беконом", 300, 2,
                new HashSet<>(Arrays.asList("Яицо", "бекон", "соль")));

        Food f4 = new Food("Цезарь с курицей", 250, 3,
                new HashSet<>(Arrays.asList("Куриное филе", "листья салата", "Пармезан", "гренки")));

        Food f5 = new Food("Борщ 'Как у мамы' ", 220, 6,
                new HashSet<>(Arrays.asList("Говядина", "свекла", "картофель", "капуста", "спции")));

        Food f6 = new Food("Свиные Ребрышки", 500, 2,
                new HashSet<>(Arrays.asList("Свиные ребрышки", "Мясной соус (соевый слус, тобаско, имбирь)")));

        Drinks d1 = new Drinks("Pepsi (0,25)", 100, 50,
                new HashSet<>(Collections.singletonList("Пепси")));

        Drinks d2 = new Drinks("Red Bull (0,33)", 180, 10,
                new HashSet<>(Collections.singletonList("Red Bull (18+)")));

        Drinks d3 = new Drinks("Quantum Nuke-Cola", 5000, 0,
                new HashSet<>(Collections.singletonList("Кола, изотоп стронция 772, радиоактивные изотопы")));

        Drinks d4 = new Drinks("Black Tea", 60, 90,
                new HashSet<>(Collections.singletonList("Чайные листья")));

        Drinks d5 = new Drinks("Espresso", 60, 90,
                new HashSet<>(Collections.singletonList("Зерна кофе")));

        Drinks d6 = new Drinks("Cappuccino", 100, 80,
                new HashSet<>(Collections.singletonList("Зерна кофе, молоко")));


        Menu.printMenu();

        System.out.println("------------");

        Orders t1 = new Orders(1);

        t1.add("Яичница с беконом");
        t1.add("Омлет с помидорами и сыром");
        t1.add("Борщ 'Как у мамы");
        t1.add("Цезарь с курицей");
        t1.add("Espresso");
        t1.add("Cappuccino");
        t1.add("Яичница с беконом");
        t1.add("Яичница с беконом");
        t1.add("Свиные Ребрышки");
        t1.add("Espresso");
        t1.add("Cappuccino");
        t1.add("Quantum Nuke-Cola");

        System.out.println("------------");
        t1.printOrders();
        System.out.println(t1.getOrderSum());

        System.out.println("------------");
        t1.closeTable();

        System.out.println("------------");
        Menu.printMenu();

        System.out.println("------------");
        Menu.printStopList();

        Menu.addAmount("Яичница с беконом", 5);
        f3.setConsistency(new HashSet<>(Arrays.asList("Яицо", "бекон", "соль")));

        Menu.addAmount("Яичница с беконом", 1);
        d3.setConsistency(new HashSet<>(Arrays.asList("Кола, изотоп стронция 772, радиоактивные изотопы")));

        System.out.println("------------");
        Menu.printMenu();

        System.out.println("------------");
        Menu.printStopList();
    }

}
