
public interface UserDetailsService {

	UserDetails loadUserByUsername(String username);
}
