use case3;
select id,name,email,dob,address,phone from ministry;
delete from ministry where id=1;
select id,name,email,dob,address,phone from ministry where id = 1;

UPDATE case3.ministry SET name = ?, email = ?, dob = ?, address = ?, phone = ?, username = ?, password = ? WHERE id = ?

INSERT INTO case3.ministry (name, email, dob, address, phone, username, password) VALUES ('vu', 'vu', '2021-11-19', 'vu', '12345', 'con', 'me');