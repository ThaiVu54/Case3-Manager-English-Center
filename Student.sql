use demo3;

#Student

delimiter $$
create procedure addNewStudent(
    newstudentName varchar(50),
    newemail varchar(50),
    newmark double(10, 2),
    newdob varchar(20),
    newaddress varchar(50),
    newphone varchar(10),
    newgrade_id int,
    newusername varchar(25),
    newpassword varchar(25)
)
begin
    insert into student (name, email, mark, dob, address, phone, grade_id, username, password)
    values (newstudentName, newemail, newmark, newdob, newaddress, newphone, newgrade_id, newusername, newpassword);
end $$
delimiter ;
drop procedure addNewStudent;
call addNewStudent('anh', 'anh@gmail.com', 7.5, '1988-05-05', 'Ha Noi', '0973745598', 2, 'anhpro', '123456789');


delimiter
$$
create procedure updateStudentByID(
    studentID int,
    newstudentName varchar(50),
    newemail varchar(50),
    newmark double(10, 2),
    newdob varchar(25),
    newaddress varchar(50),
    newphone varchar(10),
    newgrade_id int
)
begin
    update student
    set name     = newstudentName,
        email    = newemail,
        mark     = newmark,
        dob      = newdob,
        address  = newaddress,
        phone    = newphone,
        grade_id = newgrade_id
    where id = studentID;
end $$
delimiter ;
drop procedure updateStudentByID;
call updateStudentByID(5, 'Tuan', 'tuan@gmail.com', 5.7, '1996-06-07', 'Ha Tinh', '01234679', 2);

delimiter
$$
create procedure updatePasswordByUserName(
    newPassword varchar(30)
)
begin
    update student
    set password = newPassword;
end $$
delimiter ;


delimiter
$$
create procedure deleteStudentByID(
    studentID int
)
begin
    delete
    from student
    where id = studentID;
end $$
delimiter ;
drop procedure deleteStudentByID;
call deleteStudentByID(5);


delimiter
$$
create procedure selectAllStudents()
begin
    select s.id,
           s.name,
           s.email,
           s.mark,
           s.dob,
           s.address,
           s.phone,
           s.username,
           s.password,
           g.id
    from student s
             join grade g on s.grade_id = g.id;
end $$

delimiter ;
drop procedure selectAllStudents;
call selectAllStudents();


delimiter
$$
create procedure getStudentInforByID(
    studentID int
)
begin
    select *
    from student
    where id = studentID;
end $$
delimiter ;
drop procedure getStudentInforByID;
call getStudentInforByID(2);

delimiter
$$
create procedure selectstudentbygradeid(
    gradeid int
)
begin
    select *
    from student s
             join grade g on g.id = s.grade_id
    where grade_id = gradeid;
end $$

delimiter ;
drop procedure selectstudentbygradeid;
call selectstudentbygradeid(2);

-- Lấy ra khóa học từ id grade
delimiter
$$
create procedure selectcourbyId(
    gradeid int
)
begin
    select c.id, c.name
    from course c
             join course_teacher ct on c.id = ct.course_id
             join grade g on ct.id = g.course_teacher_id;
end $$
delimiter ;
call selectcourbyId(3);

delimiter
$$
create procedure selectteacherbygradeid(
    gradeid int
)
begin
    select *
    from teacher t
             join course_teacher ct on t.id = ct.teacher_id
             join grade g on ct.id = g.course_teacher_id
    where g.id = gradeid;
end $$
delimiter ;

drop procedure selectteacherbygradeid;
call selectteacherbygradeid(2);


