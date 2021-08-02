package org.aibles.backendjava.saleservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "comment")
    private String comment;

    @Column(name = "star")
    private Integer star;

    @Column(name = "time")
    private Date time;

    @Column(name = "product_id")
    Integer productId;
}
