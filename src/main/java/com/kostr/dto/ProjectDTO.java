package main.java.com.kostr.dto;

import main.java.com.kostr.models.enums.ProjectStatus;

import java.util.UUID;

public class ProjectDTO {
    private UUID id;
    private String name;
    private double profitMargin;
    private double totalCost;
    private double surfaceArea;
    private ProjectStatus status;
    private UUID clientId;

    public ProjectDTO() {}

    public ProjectDTO(UUID id, String name, double profitMargin, double totalCost, double surfaceArea, ProjectStatus status, UUID clientId) {
        this.id = id;
        this.name = name;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.surfaceArea = surfaceArea;
        this.status = status;
        this.clientId = clientId;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getProfitMargin() {
        return profitMargin;
    }
    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public ProjectStatus getStatus() {
        return status;
    }
    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public UUID getClientId() {
        return clientId;
    }
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String[] getAttributes() {
        return new String[]{id.toString(), name, String.valueOf(profitMargin), String.valueOf(totalCost), String.valueOf(surfaceArea), status.toString(), clientId.toString()};
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profitMargin=" + profitMargin +
                ", totalCost=" + totalCost +
                ", surfaceArea=" + surfaceArea +
                ", status=" + status +
                ", clientId=" + clientId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectDTO that = (ProjectDTO) o;

        if (Double.compare(that.profitMargin, profitMargin) != 0) return false;
        if (Double.compare(that.totalCost, totalCost) != 0) return false;
        if (Double.compare(that.surfaceArea, surfaceArea) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (status != that.status) return false;
        return clientId.equals(that.clientId);
    }
}
