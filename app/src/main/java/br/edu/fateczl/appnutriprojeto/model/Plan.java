package br.edu.fateczl.appnutriprojeto.model;

public class Plan implements Identifiable {
    private int id;
    private String name;
    private String type;
    private String description;
    private int userId;

    public Plan() {}

    public Plan(String name, String type, String description, int userId) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.userId = userId;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
