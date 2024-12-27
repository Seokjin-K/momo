package com.momo.config.token.repository;


import com.momo.config.token.entity.RefreshToken;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

  /**
   * Refresh Token 존재 여부 확인
   * @param token Refresh Token 값
   * @return 존재 여부
   */
  boolean existsByToken(String token);

  /**
   * 사용자 이메일 기반 Refresh Token 삭제
   * @param email 사용자 이메일
   */
  @Modifying
  @Transactional
  @Query("DELETE FROM RefreshToken rt WHERE rt.user.email = :email")
  void deleteByEmail(@Param("email") String email);

  /**
   * Refresh Token 값으로 엔티티 조회
   * @param token Refresh Token 값
   * @return RefreshToken 엔티티
   */
  Optional<RefreshToken> findByToken(String token);
}