package com.hci.galleryFloor.gallery.api;

import com.hci.galleryFloor.gallery.domain.Category;
import com.hci.galleryFloor.gallery.dto.CategoryDTO;
import com.hci.galleryFloor.gallery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(categoryService.listAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> show(@PathVariable(value = "id") Long id){
        Optional<CategoryDTO> byId = categoryService.show(id);

        return byId
                .map(categoryDTO -> new ResponseEntity<>(categoryDTO, HttpStatus.OK))
                .orElseGet( () -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> create(CategoryDTO category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, CategoryDTO category){
       category.setId(id);

       Optional<CategoryDTO> updated = categoryService.update(category);

       return updated
               .map(categoryDTO -> new ResponseEntity<>(categoryDTO, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
