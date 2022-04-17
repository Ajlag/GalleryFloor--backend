package com.hci.galleryFloor.gallery.repository;

import com.hci.galleryFloor.gallery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    List<User> findAllBy();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findByDeleted(boolean deleted);

    @Query(value = "SELECT COUNT(*) FROM user WHERE email=:email", nativeQuery = true)
    int countEmail(@Param(value = "email") String email);

    @Query(value = "UPDATE user SET password = :password WHERE email = :email ;", nativeQuery = true)
    @Modifying
    void newPassword(@Param(value = "password") String password, @Param(value = "email") String email);

    @Query(value = "UPDATE user SET deleted = TRUE WHERE id = :id;", nativeQuery = true)
    @Modifying
    void delete(@Param(value = "id") Long id);
}
