package pages;

public enum GOODS {

    TERAFLYU(3728, "Порошок", "325мг+10мг+20мг+50мг", "Длительный срок", "США Франция", "784 ₽", "teraflyu-ot-grippa-i-prostudy-por-d-r-ra-vn-pak-10-limon-1"),
    AKVAMARIS (355970, "Капли назальные", "30%", "Длительный срок", "Хорватия", "257 ₽", "akva-maris-kapli-naz-d-detey-fl-kap-10ml-1"),
    NUROFEN(112301, "Капсулы", "200мг", "Длительный срок", "Нидерланды", "288 ₽", "nurofen_ekspress_kaps_200mg_n16");

    private int id;
    private String form,
            dosage,
            expirationDate,
            country,
            price,
            link;

    GOODS(int id, String form, String dosage, String expirationDate, String country, String price, String link) {
        this.id = id;
        this.form = form;
        this.dosage = dosage;
        this.expirationDate = expirationDate;
        this.country = country;
        this.price = price;
        this.link = link;
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

    public String getLink() {
        return link;
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
                ", link='" + link + '\'' +
                '}';
    }
}
