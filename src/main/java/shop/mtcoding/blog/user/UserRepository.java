package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
@RequiredArgsConstructor
@Repository

public class UserRepository {
    @Autowired
    private EntityManager em;

    public User findByUsernameAndPassword(UserRequest.LoginDTO requestDTO){
        Query  query = em.createNativeQuery("select * from user_tb where username=? and password=?", User.class);
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());

        User user = (User) query.getSingleResult();
        return user;
    }

    @Transactional
    public void save(UserRequest.JoinDTO requestDTO){
        Query query = em.createNativeQuery("insert into user_tb(username, password, email,created_at) values (?,?,?,now())");
        query.setParameter(1,requestDTO.getUsername());
        query.setParameter(2,requestDTO.getPassword());
        query.setParameter(3,requestDTO.getEmail());
        query.executeUpdate();

    }
}
