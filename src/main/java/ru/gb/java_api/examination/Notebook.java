package ru.gb.java_api.examination;

public class Notebook {
    private int id;
    private String manufacturer;
    private String model;
    private String cpu;
    private int memorySize;
    private int hddSize;
    private double diagonal;
    private Color color;
    private String os;

    public Notebook() {}

    public Notebook(int id, String manufacturer, String model, String cpu, int memorySize, int hddSize, double diagonal, Color color, String os) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.cpu = cpu;
        this.memorySize = memorySize;
        this.hddSize = hddSize;
        this.diagonal = diagonal;
        this.color = color;
        this.os = os;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCpu() {
        return cpu;
    }

    public String getModel() {
        return model;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getHddSize() {
        return hddSize;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public Color getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "Id=" + id +
                ", Manufacturer='" + manufacturer + '\'' +
                ", Model='" + model + '\'' +
                ", CPU='" + cpu + '\'' +
                ", Memory Size=" + memorySize + "GB" +
                ", HDD Size=" + hddSize + "GB" +
                ", Diagonal=" + diagonal + "\"" +
                ", Color='" + color + '\'' +
                ", OS='" + os + '\'' +
                '}';
    }
}
