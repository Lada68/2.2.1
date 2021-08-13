package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        userService.userAddCar(1L, new Car("aaa", 11528));

        userService.showUser("aaa", 11528);

        List<User> users = userService.listUsers();
        users.forEach(user1 -> {
            System.out.println("Id = " + user1.getId());
            System.out.println("First Name = " + user1.getFirstName());
            System.out.println("Last Name = " + user1.getLastName());
            System.out.println("Email = " + user1.getEmail());
            System.out.println("Car = " + user1.getCar());
            System.out.println();
        });

        userService.userDelete(1L);

        context.close();
    }
}
