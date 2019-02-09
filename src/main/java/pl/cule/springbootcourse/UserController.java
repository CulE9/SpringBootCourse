package pl.cule.springbootcourse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private List<User> users = new ArrayList<>();

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public User registry(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public User edit(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public User confirm(@PathVariable(value = "id") Long id) {
        return new User();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public User add(@RequestBody User user) {
        users.add(user);
        System.out.println("Utworzono: " + user.getFirstName() + " " + user.getLastName());
        return user;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
