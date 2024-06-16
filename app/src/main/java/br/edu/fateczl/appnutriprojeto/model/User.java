package br.edu.fateczl.appnutriprojeto.model;

public class User extends Person implements Identifiable {
    private String login;
    private String password;
    private float height;
    private int age;
    private float weight;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String getDetails() {
        return "Login: " + login + ", Altura: " + height + ", Idade: " + age + ", Peso: " + weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", login='" + login + '\'' +
                ", height=" + height +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}