package ua.skillsup.services.DTO;

public class ProductDTO {

    private String name;
    private String category;
    private String color;
    private String parameter;
    private int count;
    private Double price;

    public ProductDTO() {
    }

    public ProductDTO(String name, String category, String color, String parameter, int count, Double price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
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
