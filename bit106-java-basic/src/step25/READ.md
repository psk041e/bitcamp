# 실습에 필요한 테이블 생성

## 게시판 테이블 생성
create table ex_board (
    bno int not null,
    titl varchar(255) not null,
    cont text,
    rdt datetime not null
);

## 멤버 테이블 생성
create table ex_member (
    id varchar(20) not null,
    email varchar(30) not null,
    psw varchar(20) not null
);

## 수업 테이블 생성
create table ex_classroom (
    cno int not null,
    titl varchar(255) not null,
    srdt datetime not null,
    erdt datetime not null,
    room varchar(20) 
);

## 팀 테이블 생성
create table ex_team (
    name varchar(20) not null,
    des text not null,
    maq int not null,
    srdt datetime not null,
    erdt datetime not null
);
```````````````````````````````````````````````
## 작업 테이블 생성
create table ex_task (
    tno int not null,
    titl varchar(255) not null,
    srdt datetime not null,
    erdt datetime not null,
    stat int not null,
    worker varchar(20) not null,
    team varchar(20) not null
);

## 팀멤버 테이블 생성
create table ex_teammember (
    team varchar(20) not null,
    worker varchar(20) not null
);

//cdt, rdt -> create_date
// 오라클: date, mysql: datetime

## 테이블의 주키(primary key;PK) 컬럼을 설정
alter table ex_board
add constraint ex_board_pk primary key (bno);
  
alter table ex_member
add constraint ex_member_pk primary key (id);

alter table ex_classroom
add constraint ex_classroom_pk primary key (cno);

alter table ex_team
add constraint ex_team_pk primary key (name);

alter table ex_task
add constraint ex_task_pk primary key (tno);
  
## PK 컬럼 'bno' 의 값을 자동으로 증가하도록 설정
주의! primary key 컬럼인 경우에만 자동 증가를 설정할 수 있다. 일반 컬럼은 안된다.
alter table ex_board
modify column bno int not null auto_increment;

alter table ex_classroom
modify column cno int not null auto_increment;

alter table ex_task
modify column tno int not null auto_increment;
  
## ex_board의 설정 상태 보기
describe ex_board;
desc ex_board;

## 데이터 입력

 insert into ex_board(titl, cont, rdt) values('subject1', 'contents1', now());
 insert into ex_board(titl, cont, rdt) values('subject2', 'contents2', now());
 insert into ex_board(titl, cont, rdt) values('subject3', 'contents3', now());
 insert into ex_board(titl, cont, rdt) values('subject4', 'contents4', now());
 insert into ex_board(titl, cont, rdt) values('subject5', 'contents5', now());
 insert into ex_board(titl, cont, rdt) values('subject6', 'contents6', now());
 insert into ex_board(titl, cont, rdt) values('subject7', 'contents7', now());
 insert into ex_board(titl, cont, rdt) values('subject8', 'contents8', now());
 insert into ex_board(titl, cont, rdt) values('subject9', 'contents9', now());
 
 
 insert into ex_board(titl, cont, rdt) values('subject10', 'contents10', now());
 
 
 ## 데이터 조회
 select bno, titl, cont, rdt from ex_board;
 
 ## 데이터 변경
 update ex_board set titl='okok' where bno=7;
 
 ## 데이터 삭제
 delete from ex_board where bno=8;
 




