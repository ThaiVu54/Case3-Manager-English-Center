use englishcenter;
delimiter $$
create procedure selectAdmin()
begin
    select*
    from admin;
end $$
delimiter ;
call selectAdmin();
drop procedure selectAdmin;
call selectAdmin();
delimiter $$
create procedure editAdmin(
    in name varchar(20),
    email varchar(50),
    dob varchar(12),
    address varchar(30),
    phone varchar(10),
    username varchar(20),
    password varchar(20)
)
begin
    update admin
    set name=name,
        email=email,
        dob=dob,
        address=address,
        phone=phone,
        username=username,
        password=password;
end $$
delimiter ;
call editAdmin('Pablo', 'Pablo@gmail.com', '1988/07/16', 'Mexico', '0988889998', 'PabloAdmin', 'PabloOhoho');
select *
from admin;
