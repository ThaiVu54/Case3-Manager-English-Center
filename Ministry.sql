use demo_m3;
select * from ministry;
UPDATE ministry t SET t.name = ?, t.email = ?, t.dob = ?, t.address = ?, t.phone = ? WHERE t.id = ?;
