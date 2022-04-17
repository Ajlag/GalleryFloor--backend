package com.hci.galleryFloor.gallery.dto.mapper;

import com.hci.galleryFloor.gallery.domain.User;
import com.hci.galleryFloor.gallery.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "deleted", target = "deleted")
    @Mapping(source = "orders", target = "orders")
    UserDTO userTOUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "deleted", target = "deleted")
    @Mapping(source = "orders", target = "orders")
    User userDTOToUser(UserDTO userDTO);

    List<User> userDTOsToUsers(List<UserDTO> userDTOs);
}
