package com;

import com.Interactions.Interactions;
import com.Post.Post;
import com.Post.PostRepository;
import com.User.User;
import com.User.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );

    UserRepository userRepo = configContext.getBean(UserRepository.class);
    PostRepository postRepo = configContext.getBean(PostRepository.class);

    User user1 = new User("user1", "user1@gmail.com", "user1Password");
    User user2 = new User("user2", "user2@gmail.com", "user2Password");

    Post post1 = new Post("post1Title", "post1Content", user1);
    Post post2 = new Post("post2Title", "post2Content", user1);
    Post post3 = new Post("post3Title", "post3Content", user2);

    // Interactions interactPost1 = new Interactions(
    //   null,
    //   true,
    //   null,
    //   null,
    //   null,
    //   null,
    //   user1,
    //   post1
    // );
    // post1.setInteractions(Arrays.asList(interactPost1));

    List<Post> user1Posts = Arrays.asList(post1, post2);
    user1.setPosts(user1Posts);
    // user1.setInteractions(Arrays.asList(interactPost1));

    List<Post> user2Posts = Arrays.asList(post3);
    user2.setPosts(user2Posts);

    userRepo.save(user1);
    userRepo.save(user2);
  }
}
