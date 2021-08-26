package com.example.review.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_by",nullable = false)
    private String commentBy;

    @Column(name = "comment_to",nullable = false)
    private String commentTo;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "score",nullable = false)
    private Double score;

    @CreatedDate
    private LocalDateTime commentDate;

    public static Review of(
            String commentBy,
            String commentTo,
            String description,
            Double score
    ){
        Review review = new Review();
        review.commentBy=commentBy;
        review.commentTo= commentTo;
        review.description = description;
        review.score = score;
        System.out.println("DATE: "+review.getCommentDate());
        return review;
    }

    public void update(
            String description,
            Double score
    ){
        this.description = description;
        this.score = score;
    }
}
