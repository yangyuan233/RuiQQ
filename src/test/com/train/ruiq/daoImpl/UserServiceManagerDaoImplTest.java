package test.com.train.ruiq.daoImpl; 

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.train.ruiq.daoImpl.UserManagerDaoImpl;
import com.train.ruiq.entity.QQUser;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import com.train.ruiq.util.*;

/** 
* UserManagerDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>9月 2, 2019</pre> 
* @version 1.0 
*/ 
public class UserServiceManagerDaoImplTest {
    UserManagerDaoImpl um=null;
    QQUser user=null;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: register(QQUser user) 
* 
*/ 
@Test
public void testRegister() throws Exception { 
     user=new QQUser(1000000008,"chen","123456"	,"这里有只丹王","1433987855@qq.com",0,1);
    um=new UserManagerDaoImpl();
    if(um.register(user)){
        System.out.println("注册成功");
    }else {
        System.out.println("注册失败");
    }
} 

/** 
* 
* Method: login(String name, String password) 
* 
*/ 
@Test
public void testLogin() throws Exception {
    um=new UserManagerDaoImpl();
    Boolean k=um.login((long) 1000000001,"123456");
    System.out.println(k);
} 

/** 
* 
* Method: selectUserByName(String name) 
* 
*/ 
@Test
public void testSelectUserByName() throws Exception {
    um=new UserManagerDaoImpl();
    user=um.selectUserByName("leo");
    System.out.println(user);
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectUserByNickname(String nickname) 
* 
*/ 
@Test
public void testSelectUserByNickname() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectUserById(int id) 
* 
*/ 
@Test
public void testSelectUserById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectUserByEmail(String email) 
* 
*/ 
@Test
public void testSelectUserByEmail() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateUser(QQUser user) 
* 
*/ 
@Test
public void testUpdateUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteUser(int id) 
* 
*/ 
@Test
public void testDeleteUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: grantUser(int id) 
* 
*/ 
@Test
public void testGrantUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectUserAll() 
* 
*/ 
@Test
public void testSelectUserAll() throws Exception { 
//TODO: Test goes here... 
} 


} 
