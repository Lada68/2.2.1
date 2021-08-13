package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserById(Long l);

    void userAddCar(Long l, Car car);

    void userDelete(Long id);

    void showUser(String model, int series);
}