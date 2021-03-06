package io.mirko.controllers.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by mypc on 31/03/17.
 */
public class SpaturnoVO {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Min(1)
    @NotNull
    private int age;
    @NotNull
    private String id;

    public SpaturnoVO() {}

    public SpaturnoVO(String name, String surname, int age, String id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
