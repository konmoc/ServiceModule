package com.company.service.service;

import com.company.service.entity.Role;
import com.company.service.entity.User;
import com.company.service.repository.RoleRepository;
import com.company.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleService roleService;


    public UserService(UserRepository userRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * this method puts new user into database and encodes his password - it is only used when user
     * is savet to DB for the first time - we do not want out password encoded twice
     * @param user
     */

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role role = new Role();
        if(user.getUsername().contains("admin")) {
             role = roleRepository.findByName("ROLE_ADMIN");
        }else if(user.getUsername().contains("service")){
             role = roleRepository.findByName("ROLE_SERVICEMAN");
        }else{
             role = roleRepository.findByName("ROLE_USER");
        }
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
    }

    public void saveUserWithoutEncoding(User user){
        userRepository.save(user);
    }

    public User findUserById(Long id){
        return  userRepository.findUserById(id);
    }

    public User findByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void deleteUserWithId(Long id){
        userRepository.deleteUserById(id);
    }

    public long countAllPlayers(){ return userRepository.count();}

    public List<User> findAll(){return  userRepository.findAll();}

    public List<User> findAllServicemen(){
        List<User> allUsers = findAll();
        List<User> servicemen = new ArrayList<>();
        for(User user : allUsers){
            Set<Role> roles = user.getRoles();
            if(roles.contains(roleService.findRoleById(3L))){
                servicemen.add(user);
            }

        }
        return servicemen;
    }
}
