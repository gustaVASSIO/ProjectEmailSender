package com.bosch.user.service.interfaces;

import com.bosch.user.dto.UserDTO;
import com.bosch.user.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserModel save(UserDTO dto);
}
