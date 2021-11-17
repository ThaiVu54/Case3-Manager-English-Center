use
    demo3;

# Student

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


delimiter $$
create procedure updateStudentByID(
    studentID int,
    newstudentName varchar(50),
    newemail varchar(50),
    newmark double(10, 2),
    newdob varchar(25),
    newaddress varchar(50),
    newphone varchar(10),
    newgrade_id int,
    newpasswpord varchar(30)
)
begin
    update student
    set name     = newstudentName,
        email    = newemail,
        mark     = newmark,
        dob      = newdob,
        address  = newaddress,
        phone    = newphone,
        grade_id = newgrade_id,
        password = newpasswpord
    where id = studentID;
end $$
delimiter ;
drop procedure updateStudentByID;
call updateStudentByID(5, 'Tuan', 'tuan@gmail.com', 5.7, '1996-06-07', 'Ha Tinh', '01234679', 2, '456789123');


delimiter $$
create procedure deleteStudentByID(
    studentID int
)
begin
    delete from student where id = studentID;
end $$
delimiter ;
drop procedure deleteStudentByID;
call deleteStudentByID(5);


delimiter $$
create procedure selectAllStudents()
begin
    select s.id,
           s.name,
           s.email,
           s.mark,
           s.dob,
           s.address,
           s.phone,
           g.name
    from student s
             join grade g on s.grade_id = g.id;
end $$
delimiter ;
drop procedure selectAllStudents;
call selectAllStudents();

