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

select * from student;

insert into student(no, name, tel) values (seq_student_no.nextval, '홍길동', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '신사임당', '01099998888');
insert into student(no, name, tel) values (seq_student_no.nextval, '세종대왕', '01022223333');

select * from student where deleted_at is null;

commit;