package org.aibles.backendjava.saleservice.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ReviewDTO {

    private Integer id;

    private String author;

    private String comment;

    private Integer star;

    private Date time;
}
