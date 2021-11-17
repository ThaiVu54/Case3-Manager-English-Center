use
    demo3;

-- StudentSQLcode--
drop procedure addNewStudent;

delimiter $$
create procedure addNewStudent(
    newstudentName varchar(50),
    newemail varchar(50),
    newmark double(10, 2),
    newdob date,
    newaddress varchar(50),
    newphone varchar(10),
    newgrade_id int
)
begin
    insert into student (name, email, mark, dob, address, phone, grade_id)
    values (newstudentName, newemail, newmark, newdob, newaddress, newphone, newgrade_id);
end $$
delimiter ;
call addNewStudent('anh', 'anh@gmail.com', 7.5, '1988-05-05', 'Ha Noi', '0973745598', 2);

delimiter $$
create procedure updateStudentByID(
    studentID int,
    newstudentName varchar(50),
    newemail varchar(50),
    newmark double(10, 2),
    newdob date,
    newaddress varchar(50),
    newphone varchar(10),
    newgrade_id int
)
begin
    update student
    set name = newstudentName, email = newemail, mark = newmark, dob = newdob, address = newaddress,phone = newphone,grade_id = newgrade_id where id = studentID;
        end $$
delimiter ;
call updateStudentByID(5,'Tuan','tuan@gmail.com',5.7,'1996-06-07','Ha Tinh','01234679',2);

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

