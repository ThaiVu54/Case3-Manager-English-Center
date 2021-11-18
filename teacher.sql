use english_center;
delimiter $$
-- hien thi toan bo giao vien
create procedure selectallteacher()
begin
    select t.id, t.name, t.email, t.dob, t.address, t.phone, t.username, t.password, c.id, c.name
    from teacher t left join course_teacher ct on t.id = ct.teacher_id left join course c on ct.course_id = c.id;
end $$

delimiter ;
drop procedure selectallteacher;
call selectallteacher();

-- hien thi giao vien theo id
create procedure selectteacherbyid(
    teacherid int
)
begin
    select *
        from teacher where id = teacherid;
end;
drop procedure selectteacherbyid;
call selectteacherbyid(2);

-- hien thi mon hoc theo idteacher
delimiter $$
create procedure selectgradebyidteacher(
    teacherid int
)
begin
    select c.id, c.name
        from course c join course_teacher ct on c.id = ct.course_id where ct.teacher_id = teacherid;
end $$
delimiter ;

drop procedure selectgradebyidteacher;
call selectgradebyidteacher(2);
-- them giao vien
delimiter $$
create procedure insertteacher(
    newname varchar(50),
    newemail varchar(50),
    newdob varchar(20),
    newaddress varchar(50),
    newphone varchar(10),
    newusername varchar(20),
    newpassword varchar(20),
    out teacherid int
)
begin
    insert into teacher(name, email, dob, address, phone, username, password) VALUES (newname, newemail, newdob, newaddress, newphone, newusername, newpassword);
    set teacherid = LAST_INSERT_ID();
end $$
drop procedure insertteacher;
set @teacherid = 0;
call insertteacher('xuan', 'xuan@gmail.com', '1994-12-13', 'ha noi','08889494', 'taikhoan', 'password', @teacherid);
select @teacherid;
-- sua giao vien
delimiter $$
create procedure updateteacher(
    in teacherid int,
    newname varchar(50),
    newemail varchar(50),
    newdob varchar(20),
    newaddress varchar(50),
    newphone varchar(10)
)
begin
    update teacher set name = newname, email = newemail, dob = newdob, address = newaddress, phone = newphone where id = teacherid;
end $$
delimiter ;
call updateteacher(?, ?, ?, ?, ?, ?);
-- xóa giáo viên
delimiter $$
create procedure deleteteacher(
    teacherid int
)
begin
    update course_teacher set teacher_id = null where teacher_id = teacherid;
    delete from teacher where id = teacherid;
end $$

delimiter ;
drop procedure deleteteacher;
call deleteteacher(2);

-- thêm ghi id giáo viên và id môn học vào bảng
delimiter $$
create procedure insertcourse_teacher(
    in teacherid int,
    courseid int
)
begin
    insert into course_teacher(teacher_id, course_id) VALUES (teacherid, courseid);
end $$
delimiter ;
drop procedure insertcourse_teacher;
call insertcourse_teacher(8,1);

-- show toàn bộ môn học
delimiter $$
create procedure selectallcourse()
begin
    select c.id, c.name, t.id, t.name, t.email, t.phone, t.address, t.dob, t.username, t.password
    from course c left join course_teacher ct on c.id = ct.course_id left join teacher t on ct.teacher_id = t.id group by c.id;
end $$
delimiter ;
drop procedure selectallcourse;
call  selectallcourse();
-- show khóa học theo id
delimiter $$
create procedure selectcoursebyid(
    courseid int
)
begin
    select * from course where id = courseid;
end $$
delimiter ;
call selectcoursebyid(3);
-- ghi khóa học vào bảng
delimiter $$
create procedure insertcourse(
    newname varchar(20),
    out courseid int
)
begin
    insert into course(name) values (newname);
    set courseid = LAST_INSERT_ID();
end $$
delimiter ;
drop procedure insertcourse;
call insertcourse('ruamat');
-- sửa khóa học

delimiter $$
create procedure updatecourse(
    courseid int,
    newname varchar(20)
)
begin
    update course set name = newname where id = courseid;
end $$
delimiter ;

call updatecourse(1, 'het roi');
-- Xóa khóa học
delimiter $$
create procedure deletecourse(
    courseid int
)
begin
    update grade set course_teacher_id = null where course_teacher_id = (select id from course_teacher group by course_id having course_id = courseid);
    delete from course_teacher where course_id = courseid;
    delete from course where id = courseid;

end $$

delimiter ;
call deletecourse(1);
drop procedure deletecourse;

-- lấy toàn bộ khóa học qua teacherid
delimiter $$
create procedure selectallcoursebyteacherid(
    teacherid int
)
begin
    select c.id, c.name, t.id, t.name, t.email, t.phone, t.dob, t.address, t.username, t.password
        from course c join course_teacher ct on c.id = ct.course_id join teacher t on ct.teacher_id = t.id where t.id = teacherid;
end $$
delimiter ;
call selectallcoursebyteacherid(1);
drop procedure selectallcoursebyteacherid;

-- Lấy toàn bộ giáo viên qua id khóa học
delimiter $$
create procedure selectallteacherbycourseid(
    courseid int
)
begin
    select t.id, t.name, t.phone, t.dob, t.address, t.email, t.username, t.password, c.id, c.name
        from teacher t join course_teacher ct on t.id = ct.teacher_id join course c on ct.course_id = c.id where ct.course_id = courseid;
end $$
delimiter ;
drop procedure selectallteacherbycourseid;
call selectallteacherbycourseid(3);