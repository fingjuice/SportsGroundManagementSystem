package cn.sgms.dao;

import cn.sgms.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user where username=#{username} and password=#{password}")
    public List<User> LoginConfirm(User user);
}
