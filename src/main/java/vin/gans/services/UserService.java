package vin.gans.services;


import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vin.gans.customExeptions.EmailExistExeption;
import vin.gans.domain.Role;
import vin.gans.domain.User;
import vin.gans.domain.UserDto;
import vin.gans.persistence.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);
    }

    private User createNewUserAccount(UserDto userDto) throws EmailExistExeption {
        if (isSuchEmailExist(userDto.getEmail()))
                 {
            throw new EmailExistExeption("Account with such email exist" + userDto.getEmail());
            }
            User registredUser = new User();
            registredUser.setUsername(userDto.getUsername());
            registredUser.setLastName(userDto.getLastName());
            registredUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            registredUser.setAccountNonExpired(true);
            registredUser.setAuthorities(ImmutableList.of(Role.USER));
            registredUser.setAccountNonLocked(true);
            registredUser.setCredentialNonExpired(true);
            registredUser.setEnabled(true);
            userRepository.save(registredUser);
        return registredUser;
    }
    private boolean isSuchEmailExist(String email){
        User user = userRepository.findByEmail(email);
        if (user == null){
            return false;
        }else return true;
    }

    public User createUserAccount(UserDto userDto) {
        User registeredUser = null;
        try {
            createNewUserAccount(userDto);
        } catch (EmailExistExeption emailExistExeption) {
            return null;
        }
        return registeredUser;
    }


}
