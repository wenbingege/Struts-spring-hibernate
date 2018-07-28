package com.ssh.service;

import com.ssh.dao.CarDaoImp;
import com.ssh.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional()
@Service(value = "userServiceImp")
public class UserServiceImp implements UserService {
    @Autowired
    private CarDaoImp carDaoImp;

    public CarDaoImp getCarDaoImp() {
        return carDaoImp;
    }

    public void setCarDaoImp(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    public void add(){
        System.out.println("调用了service.add方法");
    }

    public boolean addUser(User user) {
        System.out.println("调用了service.addCar方法");
        boolean result=carDaoImp.addUser(user);
        if (result==true){
            return true;
        }else {
            return false;
        }
    }

    public User selectUser(int id) {
        System.out.println("调用了service.select方法");
        return carDaoImp.selectUser(id);
    }

    public boolean deleteUser(int id) {
        System.out.println("调用了service.deleteUser方法");
        boolean result=carDaoImp.deleteUser(id);
        if (result==true){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateUser(User user) {
        System.out.println("调用了updateUser方法");
        boolean result=carDaoImp.updateUser(user);
        if (result==true){
            return true;
        }else {
            return false;
        }
    }

    public boolean login(String username, String password) {
        System.out.println("调用了login方法");
        boolean result=carDaoImp.login(username,password);
        if (result==true){
            return true;
        }else {
            return false;
        }
    }
}
