package HumanResources.entity;

import java.time.LocalDate;

public class Project {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private Employee manager;

    public Project() {
    }
    public Project(Integer id, String name, LocalDate startDate, LocalDate endDate, String status) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return String.format("| %-4d | %-25s | %-12s | %-12s | %-10s |",
                id,
                name,
                startDate,
                (endDate != null ? endDate : "N/A"),
                status);
    }
}
