--=================================
-- mybatis
--=================================
create table student (
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    created_at date default sysdate,
    updated_at date,
    deleted_at date,    -- 학생정보 제거 시 실제 제거하는 것이 아닌 deleted_at을 sysdate로 작성
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

select * from student where no = 42;

insert into student(no, name, tel) values (seq_student_no.nextval, '홍길동', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '신사임당', '01099998888');
insert into student(no, name, tel) values (seq_student_no.nextval, '세종대왕', '01022223333');

select * from student where deleted_at is null;

commit;

-- kh 계정의 데이터 사용하기
select * from kh.employee;
select * from kh.department;
select * from kh.job;

-- kh계정 : select 권한 부여
grant select on kh.employee to web2;
grant select on kh.department to web2;
grant select on kh.job to web2;

-- 관리자계정 : create synonym 권한 부여
grant create synonym to web2;

-- synonym 동의어 객체 생성
create synonym emp for kh.employee;
create synonym dept for kh.department;
create synonym job for kh.job;

select * from emp order by emp_id;
select * from dept;
select * from job;
