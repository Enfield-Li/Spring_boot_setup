package com.Post;
import com.User.User;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.lang.NonNull;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @NonNull
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String content;

    @ColumnDefault(value = "0")
    private Integer viewCount;
    @ColumnDefault(value = "0")
    private Integer votePoints;
    @ColumnDefault(value = "0")
    private Integer likePoints;
    @ColumnDefault(value = "0")
    private Integer confusedPoints;
    @ColumnDefault(value = "0")
    private Integer laughPoints;
    @ColumnDefault(value = "0")
    private Integer commentAmounts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;
}
