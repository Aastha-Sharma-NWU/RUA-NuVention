package com.example.rua.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="user_sequence"
    )
    private Long id;
    private String name;
    private String password;
    private String contactNumber;
    private Integer roleId;
    private LocalDate createdDate;


    public Users() {
    }

    public Users(Long id, String name, String password, String contactNumber, Integer roleId, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.roleId = roleId;
        this.createdDate = createdDate;
    }

    public Users(String name, String password, String contactNumber, Integer roleId, LocalDate createdDate) {
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.roleId = roleId;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", roleId=" + roleId +
                ", createdDate=" + createdDate +
                '}';
    }
}
