package com.hci.galleryFloor.gallery.repository;

import com.hci.galleryFloor.gallery.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();

    Optional<Category> findByName(String name);

    @Override
    Optional<Category> findById(Long id);

    @Query(value = "UPDATE category SET name = :name WHERE id = :id;", nativeQuery = true)
    @Modifying
    void updateName(@Param(value = "name") String name, @Param(value = "id") Long id);

    @Query(value = "DELETE FROM  category WHERE id = :id;", nativeQuery = true)
    @Modifying
    void delete(@Param(value="id") Long id);
}
