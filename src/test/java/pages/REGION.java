package pages;

public enum REGION {
    SAINT_PETERSBURG(27, "Санкт-Петербург");

    private final int id;
    private final String name;

    REGION(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
