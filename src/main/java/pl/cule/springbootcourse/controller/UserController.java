package pl.cule.springbootcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cule.springbootcourse.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private List<UserDTO> userDTOS = new ArrayList<>();

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDTO registry(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public UserDTO edit(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id) {
        return new UserDTO();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO) {
        userDTOS.add(userDTO);
        System.out.println("Utworzono: " + userDTO.getFirstName() + " " + userDTO.getLastName());
        return userDTO;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
}
