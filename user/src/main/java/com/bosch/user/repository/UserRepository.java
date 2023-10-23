package com.bosch.user.repository;

import com.bosch.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,String> {

}
