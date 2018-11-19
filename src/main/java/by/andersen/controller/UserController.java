package by.andersen.controller;

import by.andersen.model.User;
import by.andersen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*---Add new user---*/
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user){
        int id = userService.save(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<User> get(@PathVariable("id") int id) {
        User user = userService.get(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<List<User>> list(){
        List<User> users = userService.list();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/user")
    public ResponseEntity update(@RequestBody int id, User user){
        userService.update(id, user);
        return ResponseEntity.ok().body("User updated!");
    }

    DeleteMapping("/user/{id}")
        public ResponseEntity delete(@PathVariable("id") int id){
        userService.delete(id);
        return ResponseEntity.ok().body("User deleted!");
        }


}
