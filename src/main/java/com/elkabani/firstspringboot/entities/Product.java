package com.elkabani.firstspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Entity
@Table(name ="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productsId")
    private int id;

    @Column(name = "productsName")
    private String name;

    @Column(name = "productsPrice", scale = 2)
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoriesId")
    @ToString.Exclude
    private Category category;
}
