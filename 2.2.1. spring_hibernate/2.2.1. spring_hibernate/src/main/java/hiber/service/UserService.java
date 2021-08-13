package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserById(Long l);

    void userDelete(Long id);

    void userAddCar(Long l, Car car);

    void showUser(String model, int series);
}

