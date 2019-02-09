package pl.cule.springbootcourse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.cule.springbootcourse.model.UserDTO;

@RestController
@RequestMapping(value = "/")
public class Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    public String hello() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("CulE");
        return "Hello End UserDTO";
    }
}
