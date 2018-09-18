package ua.skillsup.DAO.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "PARAMETER", nullable = false)
    private String parameter;
    @Column(name = "COUNT", nullable = false)
    private int count;
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", parameter='" + parameter + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    public Product(Long id, String name, String category, String color, String parameter, int count, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.color = color;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
    }

    public Product(String name, String category, String color, String parameter, int count, Double price, Object o) {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
