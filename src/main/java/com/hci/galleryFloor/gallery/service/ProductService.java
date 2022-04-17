package com.hci.galleryFloor.gallery.service;
import com.hci.galleryFloor.gallery.dto.ProductDTO;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> listAll();

    Optional<ProductDTO> show(Long id);

    Optional<ProductDTO> show(String name);

    Optional<ProductDTO> create(ProductDTO product);

    Optional<ProductDTO> update(ProductDTO product);

    boolean delete(Long id);

    boolean removeProdict(Long id);
}
