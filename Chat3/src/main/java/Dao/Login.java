package Dao;


import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

public class Login extends SqlSessionDaoSupport implements UserDao{

    @Override
    public User logIn(String u, String p) {
        return getSqlSession().getMapper(UserDao.class).logIn(u,p);
    }

    @Override
    public boolean add(String u, String p) {
        return false;
    }

    @Override
    public User check(String u) {
        return null;
    }
}
