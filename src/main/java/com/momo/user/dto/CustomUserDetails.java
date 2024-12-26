package com.momo.user.dto;

import com.momo.user.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

  private final User user;

  public CustomUserDetails(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // 기본 권한을 "ROLE_USER"로 설정
    return Collections.singletonList(() -> "ROLE_USER");
  }

  /**
   * 사용자 ID 반환
   * @return 사용자 엔티티의 ID
   */
  public Long getId() {
    return user.getId();
  }

  @Override
  public String getPassword() {
    return user.getPassword(); // 암호화된 비밀번호 반환
  }

  @Override
  public String getUsername() {
    return user.getEmail(); // 이메일을 사용자명으로 사용
  }

  @Override
  public boolean isAccountNonExpired() {
    return true; // 계정 만료 여부: 항상 활성
  }

  @Override
  public boolean isAccountNonLocked() {
    return true; // 계정 잠금 여부: 항상 활성
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true; // 자격 증명 만료 여부: 항상 활성
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled(); // `enabled` 필드 값 반환
  }
}
