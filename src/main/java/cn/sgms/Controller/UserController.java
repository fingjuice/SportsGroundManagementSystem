package cn.sgms.Controller;

import cn.sgms.dao.UserDao;
import cn.sgms.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping(path="Login")
public class UserController {

    @RequestMapping(path="Confirm")
    public Object LoginConfirm() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user=new User("admin","123456");
        List<User> listusers=userDao.LoginConfirm(user);
        session.close();
        in.close();
        return "success";
    }
}
