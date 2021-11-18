create database english_center;
use demo3;
create table course
(
    id   int primary key auto_increment,
    name nvarchar(50)
);
insert into course(name)
values ('Toeic450'),
       ('Communication'),
       ('IELTs');
create table ministry
(
    id      int auto_increment primary key,
    name    varchar(50) not null,
    email   varchar(50) not null,
    dob     date        not null,
    address varchar(50),
    phone   varchar(10)
);
insert into ministry(name, email, dob, address, phone)
VALUES ('John', 'john@gmail.com', '1972-9-2', 'Venezuela', '0969999888');
create table teacher
(
    id      int auto_increment primary key,
    name    varchar(50) not null,
    email   varchar(50) not null,
    dob     date        not null,
    address varchar(50),
    phone   varchar(10)
);
drop table teacher;
insert into teacher(name, email, dob, address, phone)
VALUES ('Grayson', 'grayson@gmail.com', '1977-9-2', 'Nevada', '0969999880');
insert into teacher(name, email, dob, address, phone)
VALUES ('Obama', 'obama@gmail.com', '1999-9-2', 'Venezuela', '0969999881');
create table course_teacher
(
    id         int auto_increment primary key,
    course_id  int,
    teacher_id int,
    foreign key (course_id) references course (id),
    foreign key (teacher_id) references teacher (id)
);
drop table course_teacher;
insert into course_teacher(course_id, teacher_id)
VALUES (1, 1),
       (2, 2),
       (3, 2);
-- test select
select c.name, t.name
from course_teacher cou
         join course c on cou.course_id = c.id
         join teacher t on cou.teacher_id = t.id;

create table grade
(
    id                int auto_increment primary key,
    name              varchar(15),
    course_teacher_id int,
    foreign key (course_teacher_id) references course_teacher (id)
);
insert into grade(name, course_teacher_id)
VALUES ('fish', 4),
       ('duck', 5),
       ('dolphin', 6);
-- test select fun fun
select t.name, c.name, g.name
from grade g
         join course_teacher ct on g.course_teacher_id = ct.id
         join teacher t on ct.teacher_id = t.id
         join course c on c.id = ct.course_id;
create table student
(
    id       int auto_increment primary key,
    name     varchar(50) not null,
    email    varchar(50) not null,
    mark     double(10, 2) check ( mark > 0 and mark <= 10 ),
    dob      date        not null,
    address  varchar(50),
    phone    varchar(10),
    grade_id int,
    foreign key (grade_id) references grade (id)
);
drop table student;
INSERT INTO english_center.student (name, email, mark, dob, address, phone, grade_id)
VALUES ('quang anh', 'qa@gmail.com', 9.2, '1998-01-01', 'ha loi', '0123456789', 1);
INSERT INTO english_center.student (name, email, mark, dob, address, phone, grade_id)
VALUES ('thai vu', 'thaivu@gmail.com', 10, '1998-01-18', 'nam dinh', '0337334335', 3);
INSERT INTO english_center.student (name, email, mark, dob, address, phone, grade_id)
VALUES ('xuan anh', 'xuananh@gmail.com', 2.1, '2021-11-10', 'bac giang', '7894563210', 2);
INSERT INTO english_center.student (name, email, mark, dob, address, phone, grade_id)
VALUES ('beng', 'beng@gmail.com', 9, '2021-11-26', 'ha noi', '0147852369', 1);
create table admin
(
    name     varchar(50) not null,
    email    varchar(50) not null,
    dob      date        not null,
    address  varchar(50),
    phone    varchar(10),
    username varchar(20),
    password varchar(20)
);
insert into admin (name, email, dob, address, phone, username, password)
VALUES ('Hello Kitty', 'hellokitty@gmail.com', '2000-12-31', 'American Thor', '0888888888', 'admin', 'codeslayder');
-- tao account
create table studentaccount(
    username varchar(20) primary key ,
    password varchar(20),
    student_id int,
    foreign key (student_id) references student(id)
);
create table teacheraccount(
   username varchar(20) primary key ,
   password varchar(20),
   teacher_id int,
   foreign key (teacher_id) references teacher(id)
);
create table ministryaccount(
   username varchar(20) primary key ,
   password varchar(20),
   ministry_id int,
   foreign key (ministry_id) references ministry(id)
);
create table diary(
    id int auto_increment primary key ,
    content varchar(1000),
    grade_id int,
    foreign key (grade_id) references grade(id)
);
-- test username password student
select s.name, s2.username, s2.password
from student s join studentaccount s2 on s.id = s2.student_id where s.id = 1;
<<<<<<< HEAD

drop table teacheraccount;

=======
alter table teacher add username varchar(20);
alter table teacher add password varchar(20);
alter table student add username varchar(20);
alter table student add password varchar(20);
>>>>>>> fd761bb2c7413ade8c8b4c06169d4faba8d2dfad

