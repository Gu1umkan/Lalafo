package models;

public class Announcement {
    private  String name;
    private String description;
    private int price;
    private String owner;

    public Announcement() {
    }

    public Announcement(String name, String description, int price, String owner) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                '}';
    }
}


