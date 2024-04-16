package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.feature.User.dto.RoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private  final  UserService userService;
    @GetMapping
    List<RoleResponse> findAllRole(){
        return userService.findAllRoles();
    }
    @GetMapping("/{name}")
    RoleResponse findRoleByName(@PathVariable String name){
        return userService.findRoleByName(name);
    }

}
