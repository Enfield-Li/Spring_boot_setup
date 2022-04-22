package com.Post;

import com.Post.dto.PostWithInteractions;
import com.User.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  public List<Post> findByUserId(Long id);

  @Query(
    value = "select p.title, i.vote_status from post p join interactions i on p.id = i.post_id where i.post_id = 2 and i.user_id = 1;",
    nativeQuery = true
  )
  public Object findPostWithInteractions();
}
