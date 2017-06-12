//package vin.gans.persistence;
//
//import com.google.common.collect.ImmutableList;
//import org.hibernate.validator.constraints.Email;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import vin.gans.domain.Role;
//import vin.gans.domain.User;
//import vin.gans.domain.UserField;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
//
///**
// * Created by root on 01.05.17.
// */
//@Component
//public class UserDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    private List<User> baseUsers;
//
//    public List<User> getUsersFromdb(){
//        return mongoTemplate.findAll(User.class);
//    }
//    @PostConstruct
//    public void initDB() {
//        if (!hasUsers()) {
//           initUsersDB();
//        }
//    }
//    public void save(UserDetails user) {
//        mongoTemplate.save(user);
//    }
//
//    public void initUsersDB() {
//        baseUsers = createUsers();
//        baseUsers.stream().forEach(s-> mongoTemplate.save(s));
//    }
//
//    public Optional<UserDetails>findByUserName(String name) {
//        return Optional.of(mongoTemplate.findOne(query(where("username").is(name)), User.class,"users"));
//    }
//    public  void removeUserByName (String name){
//        mongoTemplate.remove(query(where("username").is(name)), User.class);
//    }
//
//    private Boolean hasUsers(){
//        Optional<User> user =  Optional.ofNullable(mongoTemplate.findOne(query(where("username").is(UserField.USER.field())), User.class, "users"));
//        Optional<User> admin =  Optional.ofNullable(mongoTemplate.findOne(query(where("username").is(UserField.ADMIN.field())), User.class, "users"));
//        if (user.isPresent() && admin.isPresent()){
//            return true;
//        }return false;
//    }
//    private List<User> createUsers(){
//        User admin = new User();
//        admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
//        admin.setAccountNonExpired(true);
//        admin.setAuthorities(ImmutableList.of(Role.ADMIN));
//        admin.setAccountNonLocked(true);
//        admin.setCredentialNonExpired(true);
//        admin.setEnabled(true);
//
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(new BCryptPasswordEncoder().encode("user"));
//        user.setAccountNonExpired(true);
//        user.setAuthorities(ImmutableList.of(Role.USER));
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialNonExpired(true);
//
//        List<User> users = new ArrayList<>();
//        users.add(admin);
//        users.add(user);
//        return users;
//    }
//
//}
