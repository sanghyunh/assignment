package com.assignment.controller;

import org.springframework.http.MediaType;

import com.assignment.CommonTest;
import com.assignment.dto.menu.MenuDto.BannerDto;
import com.assignment.dto.menu.MenuDto.MenuRequestDto;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MenuControllerTest extends CommonTest {

    @Test
    public void menu_post_test_request_empty_error() throws Exception {
        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle(null);
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

        menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription(null);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void menu_post_created_test() throws Exception {
        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void menu_post_banner_notnull_and_title_empty_error() throws Exception {
        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        BannerDto bannerDto = new BannerDto();
        bannerDto.setTitle(null);
        bannerDto.setDescription("test banner description");
        bannerDto.setImageUrl("test banner image");
        bannerDto.setLink("test link");
        menuRequestDto.setBanner(bannerDto);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

        menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        bannerDto = new BannerDto();
        bannerDto.setTitle("banner title");
        bannerDto.setDescription(null);
        bannerDto.setImageUrl("test banner image");
        bannerDto.setLink("test link");
        menuRequestDto.setBanner(bannerDto);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

        menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        bannerDto = new BannerDto();
        bannerDto.setTitle("banner title");
        bannerDto.setDescription("test banner description");
        bannerDto.setImageUrl(null);
        bannerDto.setLink("test link");
        menuRequestDto.setBanner(bannerDto);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());

        menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        bannerDto = new BannerDto();
        bannerDto.setTitle("banner title");
        bannerDto.setDescription("test banner description");
        bannerDto.setImageUrl("banner imageURl");
        bannerDto.setLink(null);
        menuRequestDto.setBanner(bannerDto);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void menu_post_banner_created() throws Exception {
        MenuRequestDto menuRequestDto = new MenuRequestDto();
        menuRequestDto.setTitle("test title");
        menuRequestDto.setLink("testLink");
        menuRequestDto.setDescription("test description");
        BannerDto bannerDto = new BannerDto();
        bannerDto.setTitle("test banner title");
        bannerDto.setDescription("test banner description");
        bannerDto.setImageUrl("test banner image");
        bannerDto.setLink("test link");
        menuRequestDto.setBanner(bannerDto);
        this.mockMvc.perform(post("/menu/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.converterUtil.toJsonString(menuRequestDto))
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }


}
