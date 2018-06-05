package ua.skillsup.DAO.model;

public class Product {

    private String name;
    private String category;
    private String color;
    private String parameter;
    private int count;
    private int price;
    private Long id;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", parameter='" + parameter + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    public Product(Long id, String name, String category, String color, String parameter, int count, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.color = color;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
    }

    public Product(String name, String category, String color, String parameter, int count, int price, Object o) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
