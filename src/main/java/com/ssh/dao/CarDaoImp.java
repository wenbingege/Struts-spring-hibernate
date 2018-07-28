package com.ssh.dao;

import com.ssh.modle.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository(value = "carDaoImp")
@Transactional(propagation = Propagation.SUPPORTS)
public class CarDaoImp implements CarDao {
    public CarDaoImp() {
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            System.out.println("向数据库插入了USER");
//            sessionFactory.openSession().save(user);
//            sessionFactory.openSession().flush();
//            sessionFactory.openSession().close();
            System.out.println(user);
            hibernateTemplate.save(user);
            hibernateTemplate.flush();
            System.out.println("success");
            flag= true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public User selectUser(int id) {

        try{
          User user=new User();
          user.setId(id);
          user=(User) hibernateTemplate.get(User.class,user.getId());
            System.out.println(user);
            System.out.println("查找了一个Car");
            return user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            User user=(User) hibernateTemplate.get(User.class,id);
            if (user!=null||user.equals("")){
                hibernateTemplate.delete(user);
                System.out.println("删除了一个User");
                flag=true;
            }else {
                System.out.println("未找到该user");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            System.out.println("向数据库更新了USER");
            hibernateTemplate.update(user);
            System.out.println("success");
            flag= true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public boolean login(String username, String password) {
        System.out.println("aaaaaaaaaaaaaaaaaaaa");
        //Session s=this.sessionFactory.getCurrentSession();
        User u=new User();
        u.setUsername(username);
        u.setPassword(password);
        try{
            User listUser=(User) hibernateTemplate.findByExample(u).get(0);
            System.out.println(listUser);
            if(listUser!=null){
                return  true;
            }else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
