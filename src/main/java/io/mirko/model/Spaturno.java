package io.mirko.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name="spaturno")
public class Spaturno {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Min(1)
    @NotNull
    private int age;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String uuid;

    public Spaturno(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public String getUuid() {
        return uuid;
    }

    @PrePersist
    private void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }
}
