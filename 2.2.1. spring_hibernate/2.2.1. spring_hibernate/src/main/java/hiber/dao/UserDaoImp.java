package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.WHERE;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long l) {

        return sessionFactory.getCurrentSession().get(User.class, l);
    }

    @Override
    public void userAddCar(Long l, Car car) {
        sessionFactory.getCurrentSession().save(car);
        sessionFactory.getCurrentSession().get(User.class, l).setCar(car);
    }

    @Override
    public void userDelete(Long id) {

        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public void showUser(String model, int series) {
        String HQL = "from Car car left outer JOIN fetch car.user where car.model = :model and car.series = :series";
        Car car = sessionFactory.getCurrentSession()
                .createQuery(HQL, Car.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
        System.out.println(car.getUser());
    }
}
