package com.assignment.util;

import com.assignment.CommonTest;
import com.assignment.dto.TokenDto.TokenPayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterUtilTest extends CommonTest {

    @Test
    public void toJsonString_test() {
        TokenPayloadDto tokenPayloadDto = TokenPayloadDto.builder()
                .exp(1000L)
                .iat(2000L)
                .build();
        String requestDtoString = this.converterUtil.toJsonString(tokenPayloadDto);
        Assertions.assertNotNull(requestDtoString);
    }

    @Test
    public void toObject_test() {
        TokenPayloadDto tokenPayloadDto = TokenPayloadDto.builder()
                .exp(1000L)
                .iat(2000L)
                .build();
        String requestDtoString = this.converterUtil.toJsonString(tokenPayloadDto);
        TokenPayloadDto toObject = this.converterUtil.toObject(requestDtoString, TokenPayloadDto.class);
        Assertions.assertEquals(toObject.getExp(), tokenPayloadDto.getExp());
        Assertions.assertEquals(toObject.getIat(), tokenPayloadDto.getIat());
    }

}
