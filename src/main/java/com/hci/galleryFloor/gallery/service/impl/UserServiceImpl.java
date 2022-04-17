package com.hci.galleryFloor.gallery.service.impl;

import com.hci.galleryFloor.gallery.domain.User;
import com.hci.galleryFloor.gallery.dto.UserDTO;
import com.hci.galleryFloor.gallery.dto.mapper.UserMapper;
import com.hci.galleryFloor.gallery.repository.UserRepository;
import com.hci.galleryFloor.gallery.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAll() {
      return userMapper.usersToUserDTOs(
              userRepository.findByDeleted(false));
    }

    @Override
    public Optional<UserDTO> show(Long id) {
       Optional<User> byId = userRepository.findById(id);
       if(!byId.isPresent()){
           return Optional.empty();
       }
       return byId.map(user -> userMapper.userTOUserDTO(user));
    }

    @Override
    public Optional<UserDTO> showByEmail(String email) {
       Optional<User> byEmail = userRepository.findByEmail(email);

       return byEmail.map(user -> userMapper.userTOUserDTO(user));
    }

    @Override
    public Optional<UserDTO> showByUsername(String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);

        return byUsername.map(user -> userMapper.userTOUserDTO(user));
    }

    @Override
    public boolean delete(Long id) {
       Optional<User> byId = userRepository.findById(id);

       if(!byId.isPresent()){
           return false;
       }

       userRepository.delete(id);
       return true;
    }

}
