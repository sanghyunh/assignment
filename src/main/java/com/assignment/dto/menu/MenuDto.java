package com.assignment.dto.menu;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class MenuDto {

    @Getter
    @Setter
    public static class MenuRequestDto {

        private Integer parentIdx;
        @NotEmpty
        private String title;
        @NotEmpty
        private String description;
        private String link;
        @NotNull
        private BannerDto banner;

    }

    @Getter
    @Setter
    public static class BannerDto {
        @NotEmpty
        private String title;
        @NotEmpty
        private String description;
        @NotEmpty
        private String imageUrl;
        @NotEmpty
        private String link;
    }

}
