abstract class Sensor {
    private String name;
    private int modelNumber;

    // getters
    public String getName() {
        return name;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    // setters
    public void setName(String n) {
        name = n;
    }

    public void setModelNumber(int m) {
        modelNumber = m;
    }

    // abstract method
    public abstract void recordMeasurement();
}