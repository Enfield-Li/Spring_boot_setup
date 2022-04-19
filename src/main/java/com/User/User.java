package com.User;
 
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Post.Post;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    private Long postAmounts;
    
    @CreationTimestamp
    private Date createdAt;
    @OneToMany()
    @JoinColumn(name = "post_id")
    private List<Post> post;
}
