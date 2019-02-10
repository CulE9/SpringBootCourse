package pl.cule.springbootcourse.service;

import pl.cule.springbootcourse.model.UserDTO;
import pl.cule.springbootcourse.persistence.model.User;
import pl.cule.springbootcourse.persistence.repository.UserRepo;

public interface UserService extends BaseService<User, Long, UserRepo> {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO editUser(UserDTO userDTO);
}