package co.istad.elearningapi.feature.User;

import co.istad.elearningapi.base.BaseMessage;
import co.istad.elearningapi.domain.Role;
import co.istad.elearningapi.domain.User;
import co.istad.elearningapi.feature.User.dto.RoleResponse;
import co.istad.elearningapi.mapper.RoleMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.channels.ReadPendingException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements  UserService{
    private  final  UserRepository userRepository;
    private  final  RoleRepository roleRepository;
    private  final RoleMapper roleMapper;
    @Transactional
    @Override
    public BaseMessage enableUserByUsername(String username) {
           if (!userRepository.existsByUsername(username)){
               throw new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "User has been not found!"
               );
           }
            userRepository.enableUserByUsername(username);
            return new BaseMessage("User has been Disable");
    }

    @Override
    public void deleteUerByUserName(String username) {
        if (!userRepository.existsByUsername(username)){
            throw  new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User has been not found!"
            );
        };
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User with username " + username + " not found"
                        )
                );
        userRepository.delete(user);

    }

    @Override
    public List<RoleResponse> findAllRoles() {
            List<Role> roles = roleRepository.findAll();

            return roleMapper.toRoleResponseList(roles);
        }

    @Override
    public RoleResponse findRoleByName(String name) {
        if (!roleRepository.existsByName(name)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Role has been not found"
            );
        }
        Role role = roleRepository.findByName(name)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Role has been not found"
                        ));
        return roleMapper.toRoleResponse(role);
    }
}

