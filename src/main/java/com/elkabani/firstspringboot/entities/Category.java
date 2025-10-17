package com.elkabani.firstspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;


@ToString
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriesId")
    private int id;

    @Column (name = "categoriesName")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Product> products;
}
