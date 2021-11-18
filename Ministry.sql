use demo_m3;
select *
from ministry;

UPDATE ministry
SET name    = 'vu',
    email   = 'vu@gmail.com',
    dob     = '1998-1-18',
    address = 'nghia tan',
    phone   = '0987654321'
WHERE id = 1;
select * from ministry;

DELETE
FROM ministry
WHERE id = ?;

select *
from ministryaccount;

DELIMITER $$
create procedure update_account_ministry(in user_name varchar(40), in user_password varchar(40), in ministry int)
begin
    update ministryaccount
    set username    = user_name,
        password    = user_password,
        ministry_id = ministry
    where ministry_id = ministry;
END; $$

delimiter ;

CALL update_account_ministry('vu','thai',1);

DELIMITER $$
create procedure find_id_ministry (in ministry_id int)
begin
    select id, name, email,dob,address,phone from ministry where id = ministry_id;
end; $$
DELIMITER ;

call find_id_ministry(2);

Delimiter $$
create procedure create_ministry(in name_m varchar(40), in email_m varchar(40), in dob_m varchar(40), in address_m varchar(40), in phone_m varchar(40) )
begin
    INSERT INTO ministry (name, email, dob, address, phone) VALUES (name_m,email_m,dob_m,address_m,phone_m);
end; $$
DELIMITER ;
drop procedure create_ministry;
call create_ministry('thai','thai@gmail.com','1999-1-1','nam dinh','0909880834');

drop table ministryaccount;
create table ministryaccount(
    username varchar(50) primary key ,
    password varchar(50) not null ,
    ministry_id int,
    foreign key (ministry_id) references ministry(id)
);

