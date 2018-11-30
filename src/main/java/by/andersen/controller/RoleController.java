package by.andersen.controller;

import by.andersen.model.Role;
import by.andersen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {


    private RoleService roleService;

    @Autowired
    public void setService(RoleService roleService){
        this.roleService = roleService;
    }


    @PostMapping("/role")
    public ResponseEntity save(@RequestBody Role role) {
        int id = roleService.save(role);
        return ResponseEntity.ok().body("Role saved!"+id);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") int id){
        Role role = roleService.getRole(id);
        return ResponseEntity.ok().body(role);
    }

    @GetMapping("/role")
    public ResponseEntity<List<Role>> getListRole(){
        List<Role> list  = roleService.list();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/role")
    public ResponseEntity update(@RequestBody Role role){
        roleService.update(role);
        return ResponseEntity.ok().body("Role updated!");
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity remove(@PathVariable("id") int id){
        roleService.delete(id);
        return  ResponseEntity.ok().body("Role delete!");
    }
}
