package com.tapestry.dao.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tapestry.dao.user.UserDAO;
import com.tapestry.entities.User;

/**
 *
 * @author Home
 */
@Service("userService")
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public Long getCount() {
        return dao.getCount();
    }

    @Override
    public List<User> getList(Integer start, Integer max) {
       return dao.getList(start, max);
    }

    @Override
    public Long save(User entity) {
       return dao.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(User entity) {
       return dao.update(entity);
    }

    @Override
    public User getById(Long id) {
       return dao.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return dao.getByEmail(email);
    }

   

}
