package com.bosch.user.service.classes;

import com.bosch.user.dto.UserDTO;
import com.bosch.user.models.UserModel;
import com.bosch.user.producers.UserProducer;
import com.bosch.user.repository.UserRepository;
import com.bosch.user.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public UserModel save(@Valid  UserDTO dto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(dto, userModel);

        userModel =  userRepository.save(userModel);
//      publicando mensagem na fila de email
        userProducer.publishMessage(userModel);
        return  userModel;
    }
}
