package ru.gb.java_api.examination;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuPoint;
        Shop shop = new Shop();
        Map<String, Integer> filterInt = new HashMap<>();
        filterInt.put("Memory", -1);
        filterInt.put("HDD", -1);
        filterInt.put("Diagonal", -1);
        Map<String, String> filterStr = new HashMap<>();
        filterStr.put("Manufacturer", null);
        filterStr.put("Model", null);
        filterStr.put("CPU", null);
        filterStr.put("Color", null);
        filterStr.put("OS", null);

        prepare(shop);

        menuMain();
        menuPoint = scanner.nextInt();
        while (menuPoint != 6) {
            switch (menuPoint) {
                case 1:
                    System.out.println(shop.showAll());
                    break;
                case 2:
                    filterStatus(filterInt, filterStr);
                    break;
                case 3:
                    filterSet(filterInt, filterStr);
                    break;
                case 4:
                    filterClear(filterInt, filterStr);
                    break;
                case 5:
                    filterShow(shop, filterInt, filterStr);
                    break;
            }
            menuMain();
            menuPoint = scanner.nextInt();
        }
    }

    private static void filterShow(Shop shop, Map<String, Integer> mapInt, Map<String, String> mapStr) {
        StringBuilder result = new StringBuilder();
        for (Notebook notebook : shop.notebooks) {
            if (((mapStr.get("Manufacturer") == null) ^ (notebook.getManufacturer().equals(mapStr.get("Manufacturer")))) &&
                    ((mapStr.get("Model") == null) ^ (notebook.getModel().equals(mapStr.get("Model")))) &&
                    ((mapStr.get("CPU") == null) ^ (notebook.getCpu().equals(mapStr.get("CPU")))) &&
                    ((mapInt.get("Memory") == -1) ^ (notebook.getMemorySize() > mapInt.get("Memory") && mapInt.get("Memory") != -1)) &&
                    ((mapInt.get("HDD") == -1) ^ (notebook.getHddSize() > mapInt.get("HDD") && mapInt.get("HDD") != -1)) &&
                    ((mapInt.get("Diagonal") == -1) ^ (notebook.getDiagonal() > mapInt.get("Diagonal") && mapInt.get("Diagonal") != -1)) &&
                    ((mapStr.get("Color") == null) ^ (notebook.getColor().toString().equals(mapStr.get("Color")))) &&
                    ((mapStr.get("OS") == null) ^ (notebook.getOs().equals(mapStr.get("OS"))))) {
                result.append(notebook).append("\n");
            }
        }
        System.out.println(result);
    }

    private static void filterClear(Map<String, Integer> mapInt, Map<String, String> mapStr) {
        Scanner scanner = new Scanner(System.in);
        menuFilterСlear();
        int menuFilterClearPoint = scanner.nextInt();
        switch (menuFilterClearPoint) {
            case 1:
                mapStr.put("Manufacturer", null);
                System.out.println("Фильтр \"Фирма ролизводитель\" удален.");
                break;
            case 2:
                mapStr.put("Model", null);
                System.out.println("Фильтр \"Модель\" удален.");
                break;
            case 3:
                mapStr.put("CPU", null);
                System.out.println("Фильтр \"ЦП\" удален.");
                break;
            case 4:
                mapInt.put("Memory",-1);
                System.out.println("Фильтр \"Объем ОЗУ\" удален.");
                break;
            case 5:
                mapInt.put("HDD", -1);
                System.out.println("Фильтр \"Объем ЖД\" удален.");
                break;
            case 6:
                mapInt.put("Diagonal", -1);
                System.out.println("Фильтр \"Диагональ\" удален.");
                break;
            case 7:
                mapStr.put("Color", null);
                System.out.println("Фильтр \"Цвет\" удален.");
                break;
            case 8:
                mapStr.put("OS", null);
                System.out.println("Фильтр \"Операционная система\" удален.");
                break;
            case 0:
                mapStr.put("Manufacturer", null);
                mapStr.put("Model", null);
                mapStr.put("CPU", null);
                mapInt.put("Memory",-1);
                mapInt.put("HDD", -1);
                mapInt.put("Diagonal", -1);
                mapStr.put("Color", null);
                mapStr.put("OS", null);
                System.out.println("Все фильтры удалены.");
        }

    }

    private static void filterSet(Map<String, Integer> mapInt, Map<String, String> mapStr) {
        Scanner scanner = new Scanner(System.in);
        menuFilterSet();
        int menuFilterSetPoint = scanner.nextInt();
        int inputInt;
        String inputStr;
        switch (menuFilterSetPoint) {
            case 1:
                System.out.println("Введите название фирмы производителя:");
                scanner.nextLine();
                inputStr = scanner.nextLine();
                mapStr.put("Manufacturer", inputStr);
                break;
            case 2:
                System.out.println("Введите название модели ноутбука:");
                scanner.nextLine();
                inputStr = scanner.nextLine();
                mapStr.put("Model", inputStr);
                break;
            case 3:
                System.out.println("Введите название ЦП ноутбука:");
                scanner.nextLine();
                inputStr = scanner.nextLine();
                mapStr.put("CPU", inputStr);
                break;
            case 4:
                System.out.println("Введите объем ОЗУ ноутбука:");
                inputInt = scanner.nextInt();
                mapInt.put("Memory", inputInt);
                break;
            case 5:
                System.out.println("Введите объем ЖД ноутбука:");
                inputInt = scanner.nextInt();
                mapInt.put("HDD", inputInt);
                break;
            case 6:
                System.out.println("Введите размер диагонали ноутбука:");
                inputInt = scanner.nextInt();
                mapInt.put("Diagonal", inputInt);
                break;
            case 7:
                System.out.println("Введите цвет ноутбука:");
                scanner.nextLine();
                inputStr = scanner.nextLine();
                mapStr.put("Color", inputStr);
                break;
            case 8:
                System.out.println("Введите название операционной системы ноутбука:");
                scanner.nextLine();
                inputStr = scanner.nextLine();
                mapStr.put("OS", inputStr);
                break;
        }
    }

    private static void filterStatus(Map<String, Integer> mapInt, Map<String, String> mapStr) {
        StringBuilder sb = new StringBuilder();
        if (mapStr.get("Manufacturer") == null) {
            sb.append("Фильтр \"Фирма ролизводитель\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Фирма ролизводитель\" равен: ").append(mapStr.get("Manufacturer")).append("\n");
        }

        if (mapStr.get("Model") == null) {
            sb.append("Фильтр \"Модель\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Модель\" равен: ").append(mapStr.get("Model")).append("\n");
        }

        if (mapStr.get("CPU") == null) {
            sb.append("Фильтр \"ЦП\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"ЦП\" равен: ").append(mapStr.get("CPU")).append("\n");
        }

        if (mapInt.get("Memory") == -1) {
            sb.append("Фильтр \"Объем ОЗУ\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Объем ОЗУ\" равен: ").append(mapInt.get("Memory")).append("GB").append("\n");
        }

        if (mapInt.get("HDD") == -1) {
            sb.append("Фильтр \"Объем ЖД\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Объем ЖД\" равен: ").append(mapInt.get("HDD")).append("GB").append("\n");
        }

        if (mapInt.get("Diagonal") == -1) {
            sb.append("Фильтр \"Диагональ\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Диагональ\" равен: ").append(mapInt.get("Diagonal")).append("\"").append("\n");
        }

        if (mapStr.get("Color") == null) {
            sb.append("Фильтр \"Цвет\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Цвет\" равен: ").append(mapStr.get("Color")).append("\n");
        }

        if (mapStr.get("OS") == null) {
            sb.append("Фильтр \"Операционная система\" не задан").append("\n");
        } else {
            sb.append("Фильтр \"Операционная система\" равен: ").append(mapStr.get("OS")).append("\n");
        }

        System.out.println(sb);
    }

    private static void menuFilterСlear() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Доступные фильтры:").append("\n")
                .append("1 - Фирма ролизводитель.").append("\n")
                .append("2 - Модель.").append("\n")
                .append("3 - ЦП.").append("\n")
                .append("4 - Объем ОЗУ.").append("\n")
                .append("5 - Объем ЖД.").append("\n")
                .append("6 - Диагональ.").append("\n")
                .append("7 - Цвет.").append("\n")
                .append("8 - Операционная система.").append("\n")
                .append("0 - Все фильтры.").append("\n").append("\n")
                .append("Выберите фильтр:");
        System.out.println(stringBuilder);
    }

    private static void menuFilterSet() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Доступные фильтры:").append("\n")
                .append("1 - Фирма ролизводитель.").append("\n")
                .append("2 - Модель.").append("\n")
                .append("3 - ЦП.").append("\n")
                .append("4 - Объем ОЗУ.").append("\n")
                .append("5 - Объем ЖД.").append("\n")
                .append("6 - Диагональ.").append("\n")
                .append("7 - Цвет.").append("\n")
                .append("8 - Операционная система.").append("\n").append("\n")
                .append("Выберите фильтр:");
        System.out.println(stringBuilder);
    }

    private static void menuMain() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню.").append("\n")
                .append("1. Показать все ноутбуки.").append("\n")
                .append("2. Вывести информацию о фильтрах.").append("\n")
                .append("3. Задать фильтры.").append("\n")
                .append("4. Удалить фильтры.").append("\n")
                .append("5. Показать отфильтрованные ноутбуки.").append("\n")
                .append("6. Выход из программы.").append("\n").append("\n")
                .append("Выберите пунк меню:");
        System.out.println(stringBuilder);
    }

    private static void prepare(Shop shop) {
        Notebook notebook1 = new Notebook();
        notebook1.setId(1);
        notebook1.setManufacturer("ASUS");
        notebook1.setModel("Vivobook Go 15");
        notebook1.setCpu("Intel Processor N100");
        notebook1.setMemorySize(8);
        notebook1.setHddSize(256);
        notebook1.setDiagonal(15.6);
        notebook1.setColor(Color.Silver);
        notebook1.setOs("None");
        Notebook notebook2 = new Notebook();
        notebook2.setId(2);
        notebook2.setManufacturer("ASUS");
        notebook2.setModel("ExpertBook B1");
        notebook2.setCpu("Intel Processor N200");
        notebook2.setMemorySize(4);
        notebook2.setHddSize(128);
        notebook2.setDiagonal(15.6);
        notebook2.setColor(Color.Black);
        notebook2.setOs("None");
        Notebook notebook3 = new Notebook();
        notebook3.setId(3);
        notebook3.setManufacturer("ASUS");
        notebook3.setModel("VivoBook Go 14");
        notebook3.setCpu("AMD Ryzen 3 7320U");
        notebook3.setMemorySize(8);
        notebook3.setHddSize(256);
        notebook3.setDiagonal(14);
        notebook3.setColor(Color.Silver);
        notebook3.setOs("Windows 11 Home");
        Notebook notebook4 = new Notebook();
        notebook4.setId(4);
        notebook4.setManufacturer("ACER");
        notebook4.setModel("Aspire 3");
        notebook4.setCpu("Intel Processor N200");
        notebook4.setMemorySize(8);
        notebook4.setHddSize(256);
        notebook4.setDiagonal(15.6);
        notebook4.setColor(Color.Silver);
        notebook4.setOs("None");
        Notebook notebook5 = new Notebook();
        notebook5.setId(5);
        notebook5.setManufacturer("ACER");
        notebook5.setModel("Aspire Go");
        notebook5.setCpu("Intel Core i3-N305");
        notebook5.setMemorySize(8);
        notebook5.setHddSize(512);
        notebook5.setDiagonal(15.6);
        notebook5.setColor(Color.Silver);
        notebook5.setOs("None");
        Notebook notebook6 = new Notebook();
        notebook6.setId(6);
        notebook6.setManufacturer("ACER");
        notebook6.setModel("Aspire 5");
        notebook6.setCpu("Intel Core i3-1305U");
        notebook6.setMemorySize(8);
        notebook6.setHddSize(512);
        notebook6.setDiagonal(14);
        notebook6.setColor(Color.Grey);
        notebook6.setOs("Windows 11 Home");
        Notebook notebook7 = new Notebook();
        notebook7.setId(7);
        notebook7.setManufacturer("HONOR");
        notebook7.setModel("MagicBook 14");
        notebook7.setCpu("AMD Ryzen 5 5500U");
        notebook7.setMemorySize(8);
        notebook7.setHddSize(512);
        notebook7.setDiagonal(14);
        notebook7.setColor(Color.Silver);
        notebook7.setOs("none");
        Notebook notebook8 = new Notebook();
        notebook8.setId(8);
        notebook8.setManufacturer("HONOR");
        notebook8.setModel("MagicBook X 16");
        notebook8.setCpu("Intel Core i5-12450H");
        notebook8.setMemorySize(8);
        notebook8.setHddSize(512);
        notebook8.setDiagonal(16);
        notebook8.setColor(Color.Grey);
        notebook8.setOs("Windows 11 Home");
        Notebook notebook9 = new Notebook();
        notebook9.setId(9);
        notebook9.setManufacturer("HONOR");
        notebook9.setModel("MagicBook X 14");
        notebook9.setCpu("Intel Core i5-13420H");
        notebook9.setMemorySize(8);
        notebook9.setHddSize(512);
        notebook9.setDiagonal(14);
        notebook9.setColor(Color.Grey);
        notebook9.setOs("Windows 11 Home");
        Notebook notebook10 = new Notebook();
        notebook10.setId(10);
        notebook10.setManufacturer("HUAWEI");
        notebook10.setModel("MateBook D 14");
        notebook10.setCpu("Intel Core i3-1215U");
        notebook10.setMemorySize(8);
        notebook10.setHddSize(256);
        notebook10.setDiagonal(14);
        notebook10.setColor(Color.Grey);
        notebook10.setOs("none");
        Notebook notebook11 = new Notebook();
        notebook11.setId(11);
        notebook11.setManufacturer("HUAWEI");
        notebook11.setModel("MateBook B5-430");
        notebook11.setCpu("Intel Core i5-1135G7");
        notebook11.setMemorySize(8);
        notebook11.setHddSize(512);
        notebook11.setDiagonal(14);
        notebook11.setColor(Color.Grey);
        notebook11.setOs("Windows 10 Pro");
        Notebook notebook12 = new Notebook();
        notebook12.setId(12);
        notebook12.setManufacturer("HUAWEI");
        notebook12.setModel("MateBook 14");
        notebook12.setCpu("Intel Core i5-1340P");
        notebook12.setMemorySize(16);
        notebook12.setHddSize(512);
        notebook12.setDiagonal(14);
        notebook12.setColor(Color.Grey);
        notebook12.setOs("Windows 11 Home Single Language");
        Notebook notebook13 = new Notebook();
        notebook13.setId(13);
        notebook13.setManufacturer("Apple");
        notebook13.setModel("MacBook Air");
        notebook13.setCpu("Apple M1");
        notebook13.setMemorySize(8);
        notebook13.setHddSize(256);
        notebook13.setDiagonal(13.3);
        notebook13.setColor(Color.Gold);
        notebook13.setOs("macOS");
        Notebook notebook14 = new Notebook();
        notebook14.setId(14);
        notebook14.setManufacturer("Apple");
        notebook14.setModel("MacBook Pro");
        notebook14.setCpu("Apple M1 Pro");
        notebook14.setMemorySize(16);
        notebook14.setHddSize(512);
        notebook14.setDiagonal(16.2);
        notebook14.setColor(Color.Grey);
        notebook14.setOs("macOS");
        shop.addNotebook(notebook1);
        shop.addNotebook(notebook2);
        shop.addNotebook(notebook3);
        shop.addNotebook(notebook4);
        shop.addNotebook(notebook5);
        shop.addNotebook(notebook6);
        shop.addNotebook(notebook7);
        shop.addNotebook(notebook8);
        shop.addNotebook(notebook9);
        shop.addNotebook(notebook10);
        shop.addNotebook(notebook11);
        shop.addNotebook(notebook12);
        shop.addNotebook(notebook13);
        shop.addNotebook(notebook14);
        shop.addNotebook(new Notebook(20,"ASUS", "1", "1", 1, 1, 1.1, Color.Black,"none"));
    }



}
