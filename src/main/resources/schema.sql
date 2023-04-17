CREATE TABLE Menu
(
    idx         int          NOT NULL primary key auto_increment,
    rootIdx     int null comment '최상위 메뉴 식별자',
    parentIdx   int null comment '상위 메뉴 식별자',
    depth       int null comment '노드 깊이',
    seq         int null comment '노드 정렬 순서',
    lft         int          not null comment '노드 왼쪽 번호',
    rgt         int          not null comment '노드 오른쪽 번호',
    title       varchar(50)  not null comment '메뉴 타이틀',
    description varchar(20)  not null comment '메뉴 설명',
    link        varchar(200) not null comment 'link',
    isActive    boolean      not null default true comment '활성화 여부',
    isDelete    boolean      not null default false comment '삭제 여부',
    createUser  int          not null comment '등록자',
    createDate  datetime     not null comment '등록일자'
);

CREATE TABLE Banner
(
    idx        int          NOT NULL primary key auto_increment,
    menuIdx    int null comment '메뉴 고유 식별자',
    bannerName varchar(50)  not null comment '배너명',
    imageUrl   varchar(200) not null comment '배너 이미지 url',
    link       varchar(200) not null comment '배너 link',
    isActive   boolean      not null default true comment '활성화 여부',
    isDelete    boolean      not null default false comment '삭제 여부',
    createUser int          not null comment '등록자',
    createDate datetime     not null comment '등록일자',
    foreign key (menuIdx) references Menu(idx)
);