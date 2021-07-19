package co.programacionmaster.hambrecero.webservice.config;

import static java.util.Collections.emptyList;

import co.programacionmaster.hambrecero.iamapi.service.UserQueries;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserQueries userQueries;

  public UserDetailsServiceImpl(UserQueries userQueries) {
    this.userQueries = userQueries;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    co.programacionmaster.hambrecero.iamapi.model.User user = userQueries
        .findByEmail(username)
        .getOrElseThrow(() -> new UsernameNotFoundException(username));

    return User.builder()
        .username(user.getId())
        .password(user.getPassword().getOrNull())
        .authorities(emptyList())
        .build();
  }
}
