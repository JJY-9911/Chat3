package Dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;


public interface UserDao {
    //方法名和语句映射名一样
    User logIn(@Param("userName") String u, @Param("passWord") String p);
    boolean add(@Param("userName") String u, @Param("passWord") String p);
    User check(@Param("userName") String u);
}
