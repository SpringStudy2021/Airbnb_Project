package com.example.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Accessors(chain = true)
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commentBy",nullable = false)
    private String commentBy;

    @Column(name = "commentTo",nullable = false)
    private String commentTo;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "score",nullable = false)
    private Double score;

    @CreatedDate
    @Column(name = "commentDate",nullable = false)
    private LocalDateTime commentDate;
}
