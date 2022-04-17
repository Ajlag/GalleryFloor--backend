package com.hci.galleryFloor.gallery.dto.mapper;

import com.hci.galleryFloor.gallery.domain.OrderPlaced;
import com.hci.galleryFloor.gallery.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "totalPrice", target = "totalPrice")
    OrderDTO orderToOrderDTO(OrderPlaced order);

    List<OrderDTO> ordersToOrderDTOs(List<OrderPlaced> orders);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "totalPrice", target = "totalPrice")
    OrderPlaced orderDTOToOrder(OrderDTO orderDTO);

    List<OrderPlaced> orderDTOsToOrders(List<OrderDTO> orderDTOs);

}
