package ua.lvlv.store.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import ua.lvlv.store.domain.User;

public class CustomUserDetails extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;

	public CustomUserDetails (User user, List<String> userRoles) {
		super(user);
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	    String strRoles= StringUtils.collectionToCommaDelimitedString(userRoles);
	    return AuthorityUtils.commaSeparatedStringToAuthorityList(strRoles);
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
