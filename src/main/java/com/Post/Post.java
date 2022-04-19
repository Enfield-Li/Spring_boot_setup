package com.Post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.ManyToOne; 

import com.User.User;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull; 

@Entity
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
    private Long viewCount;
    @ColumnDefault(value = "0")
    private Long votePoints;
    @ColumnDefault(value = "0")
    private Long likePoints;
    @ColumnDefault(value = "0")
    private Long confusedPoints;
    @ColumnDefault(value = "0")
    private Long laughPoints;
    @ColumnDefault(value = "0")
    private Long commentAmounts;
    
    // Relations
    @Column(name = "user_id", insertable=false, updatable = false)
    private long userId;
    @ManyToOne
    private User user;
}
