https://github.com/metalgos/Study_spring_thymeleaf_board
기존 타임리프+jpa 조합의 프로젝트를 메이븐+jsp 프로젝트로 마이그레이션 하기

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


-- 회원 테이블
drop table if exists member_table;  
create table member_table(  
id bigint primary key auto_increment,  
memberEmail varchar(20) unique,  
memberPassword varchar(20),  
memberName varchar(20),  
memberAge int,  
memberMobile varchar(30)  
);  

참조

유투브 : https://www.youtube.com/watch?v=tWgBlpgk0ls&list=PLV9zd3otBRt7HQxBTdpJ_85UEvKJl2mJ0&index=1
(github): https://github.com/codingrecipe1/springframework_setting
