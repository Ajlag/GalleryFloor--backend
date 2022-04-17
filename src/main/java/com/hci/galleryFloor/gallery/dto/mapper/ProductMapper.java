package com.hci.galleryFloor.gallery.dto.mapper;

import com.hci.galleryFloor.gallery.domain.Product;
import com.hci.galleryFloor.gallery.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "width", target = "width")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "orders", target = "orders")
    ProductDTO productTOProductDTO(Product product);

    List<ProductDTO> productsToProductDTOs(List<Product> products);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "width", target = "width")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "orders", target = "orders")
    Product productDTOToProduct(ProductDTO productDTO);

    List<Product> productDTOsToProducts(List<ProductDTO> productDTOs);


}
