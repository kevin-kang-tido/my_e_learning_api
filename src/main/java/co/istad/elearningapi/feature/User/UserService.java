package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.base.BaseMessage;
import co.istad.elearningapi.feature.User.dto.RoleResponse;

import java.util.List;

public interface UserService {
     BaseMessage enableUserByUsername(String username);
     // deleted user
    void deleteUerByUserName(String username);
    List<RoleResponse> findAllRoles();
    RoleResponse findRoleByName(String name);

}
