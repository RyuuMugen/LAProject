package com.luvina.la.repository;

import com.luvina.la.entity.Auth;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Long> {

    Optional<Auth> findByEmployeeLoginId(String employeeLoginId);
    Optional<Auth> findByEmployeeId(Long employeeId);


}
