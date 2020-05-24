package com.blog.dao;

import com.blog.domain.User;
import java.util.List;

/**
 * 用户持久层接口
 */

public interface IUserDao {
    /**
     * 查询用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     *  ID查询用户
     * @param id
     * @return
     */
    List<User> findById(int id);

    /**
     * 模糊查询
     * @return
     */
    List<User> findByName(String username);
}
