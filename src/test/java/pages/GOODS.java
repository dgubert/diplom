package pages;

public enum GOODS {

    AKVAZIN (300608, "Аэрозоль", "0,9%", "5 месяцев", "Россия", "495 ₽", GOOD_CATEGORY.SREDSTVA_DLYA_PROMIVANIYA_NOSA),
    AKVAMARIS (355970, "Капли назальные", "30%", "Длительный срок", "Хорватия", "274 ₽", GOOD_CATEGORY.SREDSTVA_DLYA_PROMIVANIYA_NOSA);

    private int id;
    private String form,
            dosage,
            expirationDate,
            country,
            price;

    private GOOD_CATEGORY goodCategory;

    GOODS(int id, String form, String dosage, String expirationDate, String country, String price, GOOD_CATEGORY goodCategory) {
        this.id = id;
        this.form = form;
        this.dosage = dosage;
        this.expirationDate = expirationDate;
        this.country = country;
        this.price = price;
        this.goodCategory = goodCategory;
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

    public GOOD_CATEGORY getGoodCategory() {
        return goodCategory;
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
