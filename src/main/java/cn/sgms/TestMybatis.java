package cn.sgms;
import cn.sgms.dao.UserDao;
import cn.sgms.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user=new User("admin","123466","0","0");
        List<User> listusers=userDao.LoginConfirm(user);
        System.out.println(listusers.size());
        session.close();
        in.close();
    }
}
