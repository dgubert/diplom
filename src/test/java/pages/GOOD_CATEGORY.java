package pages;

public enum GOOD_CATEGORY {
    SREDSTVA_DLYA_PROMIVANIYA_NOSA("Средства для промывания носа");

    private String name;

    GOOD_CATEGORY(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
