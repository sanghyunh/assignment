package com.assignment.util;

import org.springframework.util.Base64Utils;

import com.assignment.CommonTest;
import com.assignment.dto.TokenDto.TokenClaimDto;
import com.assignment.dto.TokenDto.TokenPayloadDto;
import com.assignment.exception.CommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JwtUtilTest extends CommonTest {

    @Test
    public void jwtTest() {
        TokenClaimDto userResponseDto = TokenClaimDto.builder()
                .userId("test")
                .build();

        // 1시간 만료 토큰 생성
        String encData =
                this.jwtUtil.encData(userResponseDto, this.dateUtil.makeExpirationDate((long) (60 * 60)));
        System.out.println(encData);
        TokenPayloadDto decData = this.jwtUtil.decData(encData);
        System.out.println(decData.getSub());
        System.out.println(decData.getExp());
        System.out.println(decData.getIat());
        System.out.println(decData.getClaim());
    }

    @Test
    public void jwtGetPayloadTest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        String payload = token.split("\\.")[1];
        System.out.println(new String(Base64Utils.decode(payload.getBytes())));
    }

    @Test
    public void jwtDecErrorTest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        Assertions.assertThrows(CommonException.class, () -> this.jwtUtil.decData(token));
    }


}
