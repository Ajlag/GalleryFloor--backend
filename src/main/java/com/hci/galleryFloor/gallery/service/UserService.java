package com.hci.galleryFloor.gallery.service;

import com.hci.galleryFloor.gallery.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> listAll();

    Optional<UserDTO> show(Long id);

    Optional<UserDTO> showByEmail(String email);

    Optional<UserDTO> showByUsername(String username);

    boolean delete(Long id);



}
