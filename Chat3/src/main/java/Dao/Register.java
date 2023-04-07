package Dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;
public class Register extends SqlSessionDaoSupport implements UserDao{

    @Override
    public User logIn(String u, String p) {
        return null;
    }

    @Override
    public boolean add(String u, String p) {
        return getSqlSession().getMapper(UserDao.class).add(u,p);
    }

    @Override
    public User check(String u) {
        return getSqlSession().getMapper(UserDao.class).check(u);
    }
}
