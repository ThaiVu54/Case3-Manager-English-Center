use demo3;


delimiter $$
create procedure addNewGrade(
    newName varchar(25)
)
begin
    insert into grade (name) values (newName);
end $$
delimiter ;
drop procedure addNewGrade;
call addNewGrade('C08222');


delimiter $$
create procedure deleteGradeByID(
    gradeID int
)
begin
    delete from grade where id = gradeID;
end $$
delimiter ;
call deleteGradeByID(9);


# delimiter $$
# create procedure updateGradeByGradeID(
#     gradeID int,
#     newName varchar(25),
#     newTeacherID int,
#     newCourseID int
# )
# begin
#     update grade g join course_teacher ct on ct.id = g.course_teacher_id
#         join course_teacher c on c.id = c.course_id
#     set g.name       = newName,
#         c.course_id  = newCourseID,
#         c.teacher_id = newTeacherID
#     where g.id = gradeID;
# end $$
# delimiter ;
# drop procedure updateGradeByGradeID;
# call updateGradeByGradeID(1, 'tiger', 3, 3);

delimiter $$
create procedure selectAllGrade()
begin
    select *
    from grade g
             join course_teacher ct on g.course_teacher_id = ct.id
             join course c on c.id = ct.course_id
             join teacher t on t.id = ct.teacher_id
             join diary d on g.id = d.grade_id;
end $$
delimiter ;
drop procedure selectAllGrade;
call selectAllGrade();

delimiter $$
create procedure selectGradeByID(
    gradeID int
)
begin
    select *
    from grade g
             join course_teacher ct on g.course_teacher_id = ct.id
             join course c on c.id = ct.course_id
             join teacher t on t.id = ct.teacher_id
    where g.id = gradeID;
end $$
delimiter ;
call selectGradeByID(1);

