공공 api : 기존 foma프로젝트(https://github.com/metalgos/Foma_project) 해썹 인증기관 api 조회 기능 업그레이트

https://github.com/metalgos/Study_spring_thymeleaf_board

기존 타임리프+jpa 조합의 프로젝트를 메이븐+jsp 프로젝트로 마이그레이션 및 추가기능 구현 하기

=============추가 기능===================

openAPI 이용하여 공공api 기능 활용하기

json데이터를 서버와 주고 받기

======================================

접속주소 : http://localhost:8055/

설치 플러그인 : smart tomcat

개발환경  
IntelliJ IDEA Community Edition  
amazon corretto open jdk 11  
mysql 8  
mybatis  
JSP  
Tomcat 9  
주요 기능  
회원가입  
로그인  
회원목록 출력  
상세조회  
수정  
삭제  
ajax 이메일 중복체크  


DB sql  



drop table if exists member_table;  
create table member_table(  
id bigint primary key auto_increment,  
memberEmail varchar(20) unique,  
memberPassword varchar(20),  
memberName varchar(20),  
memberAge int,  
memberMobile varchar(30)  
);  

drop table if exists board_table;
create table board_table(
    id bigint primary key auto_increment,
    boardWriter varchar(50),
    boardPass varchar(20),
    boardTitle varchar(50),
    boardContents varchar(500),
    boardCreatedTime datetime default now(),
    boardHits int default 0,
    fileAttached int default 0
);
drop table if exists board_file_table;
create table board_file_table
(
    id	bigint auto_increment primary key,
    originalFileName varchar(100),
    storedFileName varchar(100),
    boardId bigint,
    constraint fk_board_file foreign key(boardId) references board_table(id) on delete cascade
);
drop table if exists comment_table;
create table comment_table(
    id bigint primary key auto_increment,
    commentWriter varchar(50),
    commentContents varchar(200),
    boardId bigint,
    commentCreatedTime datetime default now(),
    constraint fk_comment_table foreign key (boardId) references board_table(id) on delete cascade
);

참조

유투브 : https://www.youtube.com/watch?v=tWgBlpgk0ls&list=PLV9zd3otBRt7HQxBTdpJ_85UEvKJl2mJ0&index=1
(github): https://github.com/codingrecipe1/springframework_setting
