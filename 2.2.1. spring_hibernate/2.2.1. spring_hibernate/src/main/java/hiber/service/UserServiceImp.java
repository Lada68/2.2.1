package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public User getUserById(Long l) {
        return userDao.getUserById(l);
    }

    @Transactional
    @Override
    public void userAddCar(Long l, Car car) {
        userDao.userAddCar(l, car);
    }

    @Transactional
    @Override
    public void showUser(String model, int series) {
        userDao.showUser(model, series);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void userDelete(Long id) {
        userDao.userDelete(id);
    }
}
