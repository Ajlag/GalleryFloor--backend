package com.hci.galleryFloor.gallery.repository;

import com.hci.galleryFloor.gallery.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    Optional<Product> findByName(String name);

    List<Product> findByWidth(float width);

    @Query(value = "DELETE FROM product WHERE id =:id;", nativeQuery = true)
    @Modifying
    void delete(@Param(value = "id") Long id);

}
