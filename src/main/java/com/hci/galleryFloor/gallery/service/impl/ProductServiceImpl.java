package com.hci.galleryFloor.gallery.service.impl;

import com.hci.galleryFloor.gallery.domain.Product;
import com.hci.galleryFloor.gallery.dto.ProductDTO;
import com.hci.galleryFloor.gallery.dto.mapper.ProductMapper;
import com.hci.galleryFloor.gallery.repository.ProductRespository;
import com.hci.galleryFloor.gallery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRespository productRespository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRespository productRespository, ProductMapper productMapper) {
        this.productRespository = productRespository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> listAll() {
        return productMapper.productsToProductDTOs(productRespository.findAll());
    }

    @Override
    public Optional<ProductDTO> show(Long id) {
        Optional<Product> byId = productRespository.findById(id);

        return byId.map(product ->  productMapper.productTOProductDTO(product));
    }

    @Override
    public Optional<ProductDTO> show(String name) {
        Optional<Product> byName = productRespository.findByName(name);

        return byName.map(product -> productMapper.productTOProductDTO(product));
    }

    @Override
    public Optional<ProductDTO> create(ProductDTO product) {
       Product toCreate = productMapper.productDTOToProduct(product);

       return Optional.of(productMapper.productTOProductDTO(
          productRespository.save(toCreate)
       ));
    }

    @Override
    public Optional<ProductDTO> update(ProductDTO product) {
       Optional<Product> byId = productRespository.findById(product.getId());

       if(!byId.isPresent()){
           return Optional.empty();
       }

       Product updated = productMapper.productDTOToProduct(product);

       return Optional.of(productMapper.productTOProductDTO(
               productRespository.save(updated)
       ));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> byId =productRespository.findById(id);

        if(!byId.isPresent()){
            return false;
        }

        productRespository.delete(id);
        return true;
    }

    @Override
    public boolean removeProdict(Long id) {
        Optional<Product> byId = productRespository.findById(id);

        if(!byId.isPresent()){
            return false;
        }

        productRespository.delete(id);
        return true;
    }
}
