package models;

public class Announcement {
    private long id;
    private  String name;
    private String description;
    private int price;
    private User owner;

    public Announcement() {
    }

    public Announcement(String name, String description, int price, User owner) {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public long getId(){
        return id;}
    public void setId(long id){
        this.id = id;}

    @Override
    public String toString() {
        return "\nAnnouncement{" +
                "    id"+ id+ 
                "    name: " + name + 
                "    description: " + description + 
                "    price=" + price +
                "    owner='" + owner + 
                '}';
    }
}


