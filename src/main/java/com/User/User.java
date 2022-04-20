package com.User;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Post.Post;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity(name = "User")
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NonNull
    @Column(name= "username", nullable = false)
    private String username;

    @NonNull
    @Column( name= "email", nullable = false)
    private String email;
    
    @NonNull
    @Column( name= "password", nullable = false)
    private String password;
    
    @ColumnDefault(value = "0")
    private Long postAmounts;
    
    @CreationTimestamp
    private Date createdAt;

    @OneToMany( mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
