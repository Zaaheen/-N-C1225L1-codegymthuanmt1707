package ss16_IO_stream.readfile;

public class Country {
    private Integer id;
    private String code;
    private String name;

    public Country() {
    }
    public Country(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("| %-3s | %-10s | %-20s |",
                this.getId(), this.getCode(), this.getName());
    }
}
