package kr.co.farmstory.configure;

import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecurityUserService  implements UserDetailsService {

    private final UserRepository repo;

    public SecurityUserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user;
        if(repo.findById(username).isPresent()){
            user = repo.findById(username).get();
        }else{
            throw new UsernameNotFoundException(username);
        }

        return MyUserDetails
                .builder()
                .user(user)
                .build();
    }

}
