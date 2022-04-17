package com.hci.galleryFloor.gallery.service.impl;

import com.hci.galleryFloor.gallery.domain.OrderPlaced;
import com.hci.galleryFloor.gallery.dto.OrderDTO;
import com.hci.galleryFloor.gallery.dto.mapper.OrderMapper;
import com.hci.galleryFloor.gallery.repository.OrderRepository;
import com.hci.galleryFloor.gallery.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> listAll() {
        return orderMapper.ordersToOrderDTOs(orderRepository.findAll());
    }

    @Override
    public Optional<OrderDTO> show(String email) {
        Optional<OrderPlaced> byEmail = orderRepository.findByEmail(email);

        return byEmail.map(
                order -> orderMapper.orderToOrderDTO(order));
    }

    @Override
    public Optional<OrderDTO> create(OrderDTO order) {
        OrderPlaced toCreate = orderMapper.orderDTOToOrder(order);

        return Optional.of(orderMapper.orderToOrderDTO(
                orderRepository.save(toCreate)));
    }

    @Override
    public boolean delete(Long id) {
        Optional<OrderPlaced> byId= orderRepository.findById(id);

        if(!byId.isPresent()){
            return false;
        }
        return true;
    }
}
