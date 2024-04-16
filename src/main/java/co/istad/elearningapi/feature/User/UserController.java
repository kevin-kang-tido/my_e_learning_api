package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.base.BaseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private  final  UserService userService;
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{username}/enable")
    BaseMessage enableUserByUsername(@PathVariable String username){
        return userService.enableUserByUsername(username);
    }
    @DeleteMapping("/{username}")
    void  deleteUserByUsername(@PathVariable String username){
        userService.deleteUerByUserName(username);
    }



}
