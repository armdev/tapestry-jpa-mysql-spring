package com.tapestry.dao.services;


import com.tapestry.entities.User;

import java.util.List;

/**
 *
 * @author Home
 */
public interface UserService {

   
    public Long getCount();

    public List<User> getList(Integer start, Integer max);

    public Long save(User entity);

    public boolean delete(Long id);

    public boolean update(User entity);

    public User getById(Long id);
  
    public User getByEmail(String email);
}
