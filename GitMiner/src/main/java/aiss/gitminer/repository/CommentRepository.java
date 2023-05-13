package aiss.gitminer.repository;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    Page<Comment> findByAuthor(User Author, Pageable pageable);
}
