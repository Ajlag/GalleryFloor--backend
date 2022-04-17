package com.hci.galleryFloor.gallery.api;

import com.hci.galleryFloor.gallery.dto.OrderDTO;
import com.hci.galleryFloor.gallery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderApi {

    private OrderService orderService;

    @Autowired
    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return  new ResponseEntity<>(orderService.listAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{email}")
    public  ResponseEntity<?> showEmail(@PathVariable(value = "email") String email){
        Optional<OrderDTO> byEmail = orderService.show(email);

        return byEmail
                .map(orderDTO -> new ResponseEntity<>(orderDTO, HttpStatus.OK))
                .orElseGet(() ->  new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> create(OrderDTO order){
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean result = orderService.delete(id);

        return result
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
