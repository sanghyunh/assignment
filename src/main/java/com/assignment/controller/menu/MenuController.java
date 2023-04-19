package com.assignment.controller.menu;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.menu.MenuDto.MenuRequestDto;
import com.assignment.exception.BindingException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    @PostMapping("/v1")
    public ResponseEntity<Void> signup(
            @Valid @RequestBody MenuRequestDto requestBody,
            BindingResult result) {
        if (result.hasErrors()) {
            throw new BindingException(result.getFieldError());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
