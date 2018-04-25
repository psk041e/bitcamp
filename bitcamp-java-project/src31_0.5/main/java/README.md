# 변경 내역
- build.gradle 변경
- eclipse 설정 파일 갱신
- pms_board 테이블 생성
```
drop table pms_board;

create table pms_board (
    bno int not null,
    titl varchar(255) not null,
    cont text,
    cdt datetime not null
);

// 보통 실무에서는 테이블을 만든 후 설정을 따로 해준다.
alter table pms_board
    add constraint pms_board_pk primary key (bno); => 제약조건을 추가하겠다.

alter table pms_board
    modify column bno int not null auto_increment; 
=> primary key컬럼만이 지정할 수 있다. 따라서, add constraint해준 후 auto_increment를 설정한다.

```
 - Board.java 변경
 - BoardXxxController.java 변경
 - pms_member 테이블 생성
```
drop table pms_member;

create table pms_member (
    mid varchar(20) not null,
    email varchar(255) not null,
    pwd varchar(200) not null
);

alter table pms_member
    add constraint pms_member_pk primary key (mid);
```
- Member.java 변경
- MemberXxxController.java 변경
- pms_classroom 테이블 생성
```
drop table pms_classroom;

create table pms_classroom (
    crno int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    room varchar(50) // 수업을 몇번 교실에서 하는지 지정하지 않았을수 있다.
);

alter table pms_classroom
    add constraint pms_classroom_pk primary key (crno);
    
alter table pms_classroom
    modify column crno int not null auto_increment;
```
- Classroom.java 변경
- ClassroomXxxController.java 변경
- pms_team 테이블 생성
```

drop table pms_team;

create table pms_team (
    name varchar(100) not null,
    dscrt text,
    max_qty int not null,
    sdt datetime not null,
    edt datetime not null
);

alter table pms_team
    add constraint pms_team_pk primary key (name);
```
- Team.java 변경
- TeamDao.java 변경
- TeamXxxController.java 변경
- pms_task 테이블 생성
```
drop table pms_task;

create table pms_task (
    tano int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    stat int default 0,
    mid varchar(20) not null,
    tnm varchar(100) not null
);

alter table pms_task
    add constraint pms_task_pk primary key (tano);
    
alter table pms_task
    modify column tano int not null auto_increment;
    
alter table pms_task 
    add constraint pms_task_fk foreign key (mid)
    references pms_member (mid);
    
alter table pms_task
    add constraint pms_task_fk2 foreign key (tnm)
    references pms_team (name);
    
```
- Task.java 변경
- TaskDao.java 변경
- TaskXxxController.java 변경
- pms_team_member 테이블 생성
```
drop table pms_team_member;

create table pms_team_member (
    tnm varchar(100) not null,
    mid varchar(20) not null
);

alter table pms_team_member
    add constraint pms_team_member_pk primary key (tnm, mid);
// => 두개를 묶어서 primary key로 쓰겠다.
// => 두개가 모두 같은 값이 들어올수 없게된다.

alter table pms_team_member
    add constraint pms_team_member_fk foreign key (tnm)
    references pms_team (name);
    
alter table pms_team_member
    add constraint pms_team_member_fk2 foreign key (mid)
    references pms_member (mid);
    






