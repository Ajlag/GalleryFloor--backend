package com.hci.galleryFloor.gallery.api;

import com.hci.galleryFloor.gallery.dto.ProductDTO;
import com.hci.galleryFloor.gallery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductApi {

    private ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> show(@PathVariable(value = "id") Long id) {
        Optional<ProductDTO> byId = productService.show(id);

        return byId.map(
                productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
                .orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<?> create(ProductDTO product){
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long id, ProductDTO product){
        product.setId(id);

        Optional<ProductDTO> updated = productService.update(product);

        return updated
                .map(productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> toggleDeleted(@PathVariable(value = "id") Long id){
        boolean result = productService.removeProdict(id);

        return result
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
