package com.Post;

import com.Post.dto.PostWithInteractions;
import com.User.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  public List<Post> findByUserId(Long id);

  @Query(
    value = "SELECT p.title, i.vote_status" +
    " FROM post p" +
    " JOIN interactions i" +
    " On p.id = i.post_id" +
    " WHERE i.post_id = :postId AND i.user_id = :userId ;",
    nativeQuery = true
  )
  public Object findPostWithInteractions(
    @Param("postId") Integer postId,
    @Param("userId") Integer userId
  );
}
