package com.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public Optional<User> findByUsername(String username);

  public Optional<User> findByEmail(String email);

  // @Query("SELECT user FROM User user WHERE user.id = ?1")
  @Query("FROM #{#entityName} WHERE id = ?1")
  public Optional<User> findByEmailWithQuery(Long id);
}
