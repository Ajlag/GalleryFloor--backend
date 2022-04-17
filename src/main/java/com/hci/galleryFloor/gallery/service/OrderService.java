package com.hci.galleryFloor.gallery.service;

import com.hci.galleryFloor.gallery.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDTO> listAll();

    Optional<OrderDTO> show(String email);

    Optional<OrderDTO> create(OrderDTO order);

    boolean delete(Long id);
}
