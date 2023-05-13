package aiss.gitminer.repository;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Page<User> findByName(String name, Pageable pageable);
}

