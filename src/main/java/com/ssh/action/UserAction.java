package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.modle.User;
import com.ssh.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller(value = "userAction")
@Scope(value = "prototype")
public class UserAction extends ActionSupport {
    @Autowired
    private UserServiceImp userServiceImp;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public String execute() throws Exception {
            return "error";
    }
    public String addTest(){
        System.out.println("调用了action的addTest方法");
        //userServiceImp.add();
        //userServiceImp.addUser(new User(3, "cc", "cc"));
        userServiceImp.selectUser(2);
        //System.out.println(userServiceImp.login("aa","aa"));
        return NONE;
    }

    /**
     * 处理用户登陆
     * @return
     */
    public String login(){
        System.out.println("action.login");
        boolean r=userServiceImp.login(user.getUsername(),user.getPassword());
        if (r==true)
            return "success";
        else
            return "error";
    }

    /**
     * 处理用户注册
     * @return
     */
    public String register(){
        System.out.println("action.register");
        boolean r=userServiceImp.addUser(user);
        if (r==true)
            return "success";
        else
            return "error";
    }

    /**
     * 处理用户信息修改
     * @return
     */
    public String update(){
        System.out.println("action.update");
        boolean r=userServiceImp.updateUser(user);
        if (r==true)
            return "success";
        else
            return "error";
    }

    /**
     * 处理根据id删除用户
     * @param
     * @return
     */
    public String delete(){
        System.out.println("action.delete");
        boolean r=userServiceImp.deleteUser(user.getId());
        if (r==true)
            return "success";
        else
            return "error";
    }
}
