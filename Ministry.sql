use demo_m3;
select *
from ministry;

UPDATE ministry t
SET t.name    = ?,
    t.email   = ?,
    t.dob     = ?,
    t.address = ?,
    t.phone   = ?
WHERE t.id = ?;

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

call find_id_ministry(2)

