package ss8_clean_code.Entity;

public class Customer {
    private Integer id;
    private String name;
    private String dob;
    private String address;

    public Customer() {
    }

    public Customer(Integer id, String name, String dob, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("| %-2d | %-20s | %-10s | %-20s |",
                this.getId(), this.getName(), this.getDob(), this.getAddress());
    }
}
