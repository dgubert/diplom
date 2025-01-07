package pages;

public enum GOODS {

    AKVAZIN (300608, "Аэрозоль", "0,9%", "5 месяцев", "Россия", "495 ₽"),
    AKVAMARIS (355970, "Капли назальные", "30%", "Длительный срок", "Хорватия", "274 ₽"),
    NUROFEN(112301, "Капсулы", "200мг", "Длительный срок", "Нидерланды", "289 ₽");

    private int id;
    private String form,
            dosage,
            expirationDate,
            country,
            price;

    GOODS(int id, String form, String dosage, String expirationDate, String country, String price) {
        this.id = id;
        this.form = form;
        this.dosage = dosage;
        this.expirationDate = expirationDate;
        this.country = country;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getDosage() {
        return this.dosage;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public String getForm() {
        return form;
    }

    public String getCountry() {
        return country;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", form='" + form + '\'' +
                ", dosage='" + dosage + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
