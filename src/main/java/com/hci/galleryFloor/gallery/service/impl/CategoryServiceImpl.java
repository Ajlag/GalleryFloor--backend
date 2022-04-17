package com.hci.galleryFloor.gallery.service.impl;

import com.hci.galleryFloor.gallery.domain.Category;
import com.hci.galleryFloor.gallery.dto.CategoryDTO;
import com.hci.galleryFloor.gallery.dto.mapper.CategoryMapper;
import com.hci.galleryFloor.gallery.repository.CategoryRepository;
import com.hci.galleryFloor.gallery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> listAll() {
        return categoryMapper.categoriesToCategoryDTOs(
                categoryRepository.findAll());
    }

    @Override
    public Optional<CategoryDTO> show(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);

        return byId.map(
                category -> categoryMapper.categoryToCategoryDTO(category));
    }

    @Override
    public Optional<CategoryDTO> show(String name) {
        Optional<Category> byName = categoryRepository.findByName(name);

        return byName.map(
                category -> categoryMapper.categoryToCategoryDTO(category)
        );

    }

    @Override
    public Optional<CategoryDTO> create(CategoryDTO category) {
        Category toCreate = categoryMapper.categoryDTOToCateory(category);

        return Optional.of(categoryMapper.categoryToCategoryDTO(
           categoryRepository.save(toCreate)));
    }

    @Override
    public Optional<CategoryDTO> update(CategoryDTO category) {
        Optional<Category> byId = categoryRepository.findById(category.getId());

        if(!byId.isPresent()){
            return Optional.empty();
        }

        Category updated = categoryMapper.categoryDTOToCateory(category);

        return Optional.of(categoryMapper.categoryToCategoryDTO(
                categoryRepository.save(updated)
        ));
    }
}
