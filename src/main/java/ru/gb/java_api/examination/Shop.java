package ru.gb.java_api.examination;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Notebook> notebooks;

    public Shop() {
        this.notebooks = new ArrayList<>();
    }

    public void addNotebook(Notebook notebook) {
        this.notebooks.add(notebook);
    }

    public StringBuilder showAll() {
        StringBuilder result = new StringBuilder();
        for (Notebook notebook : notebooks) {
            result.append(notebook).append("\n");
        }
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                notebooks +
                '}';
    }
}
