package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.util.ConverterUtil;
import com.assignment.util.DateUtil;
import com.assignment.util.JwtUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class CommonTest {

    @Autowired
    protected ConverterUtil converterUtil;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected JwtUtil jwtUtil;
    @Autowired
    protected DateUtil dateUtil;

}
