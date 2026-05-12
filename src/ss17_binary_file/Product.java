package ss17_binary_file;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String manufacturer;
    private String description;

    public Product() {
    }
    public Product(Integer id, String name, Double price, String manufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("| %-4s | %-25s | %-12.2f | %-12s | %-15s |",
                id, name, price, manufacturer, description);
    }
}
