package com.hci.galleryFloor.gallery.service;

import com.hci.galleryFloor.gallery.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> listAll();

    Optional<CategoryDTO> show(Long id);

    Optional<CategoryDTO> show(String name);

    Optional<CategoryDTO> create(CategoryDTO category);

    Optional<CategoryDTO> update(CategoryDTO category);

}
