package ru.orangemaks.restaurant.database;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.orangemaks.restaurant.domain.admin.users.Admin_UserDataAccess;
import ru.orangemaks.restaurant.domain.order.OrderUserDataAccess;
import ru.orangemaks.restaurant.domain.user.lk.LkUserDataAccess;
import ru.orangemaks.restaurant.domain.user.registration.UserDataAccess;
import ru.orangemaks.restaurant.entities.Role;
import ru.orangemaks.restaurant.entities.User;
import ru.orangemaks.restaurant.models.RoleCategories;
import ru.orangemaks.restaurant.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

/**
 * Class data access to User
 */
public class JpaUser implements UserDataAccess, Admin_UserDataAccess, OrderUserDataAccess, LkUserDataAccess {

    /**
     * data access
     */
    private final UserRepository userRepository;

    /**
     * default EntityManager
     */
    @PersistenceContext
    private EntityManager em;

    public JpaUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * get all users
     * @return list of all users
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * filter user by parametres
     * @param id id user
     * @param username username
     * @param ROLE_USER role parameter
     * @param ROLE_ADMIN role parameter
     * @return filtered users
     */
    @Override
    public List<User> filter(Long id, String username, String ROLE_USER, String ROLE_ADMIN) {
        if (id==null && username.equals("") && ROLE_USER.equals("") && ROLE_ADMIN.equals("")){
            return getAll();
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Join<User,Role> join = user.join("roles",JoinType.INNER);

        Predicate predicateForId = cb.equal(user.get("id"), id);
        Predicate predicateForUsername = cb.like(user.get("username"), username);
        Predicate predicateForRoleUser = cb.like(join.get("name").as(String.class), RoleCategories.ROLE_USER.name());
        Predicate predicateForRoleAdmin = cb.like(join.get("name").as(String.class),RoleCategories.ROLE_ADMIN.name());

        Predicate fieldPredicate = null;
        Predicate rolePredicate = null;
        Predicate finalePredicate;

        if(id!=null){
            fieldPredicate = cb.and(predicateForId);
        }
        if(!username.equals("")){
            if (fieldPredicate != null) fieldPredicate = cb.and(fieldPredicate,predicateForUsername);
            else fieldPredicate = predicateForUsername;
        }
        if(!ROLE_USER.equals("")){
            rolePredicate = cb.and(predicateForRoleUser);
        }
        if(!ROLE_ADMIN.equals("")){
            if (rolePredicate != null) rolePredicate = cb.or(rolePredicate,predicateForRoleAdmin);
            else rolePredicate = predicateForRoleAdmin;
        }

        if (fieldPredicate==null) finalePredicate = rolePredicate;
        else if (rolePredicate==null) finalePredicate = fieldPredicate;
        else finalePredicate = cb.and(fieldPredicate,rolePredicate);

        criteriaQuery.select(user).where(finalePredicate);
        List<User> users = em.createQuery(criteriaQuery).getResultList();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    /**
     * find user by id
     * @param id id
     * @return user by id
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * save user
     * @param user user for save
     */
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * find user by username
     * @param username username
     * @return user by username
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * delete user by id
     * @param id id
     * @return deleted user
     */
    @Override
    public User deleteById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null){
            userRepository.deleteById(id);
            return user;
        }
        else return null;
    }

    /**
     * get user by session
     * @return user by session
     */
    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(auth.getName());
    }
}
