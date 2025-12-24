package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
