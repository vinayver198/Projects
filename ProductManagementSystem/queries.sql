drop table product cascade constraint;

create table Product(
id number primary key,
name varchar2(20) not null,
price number(8,2) not null,
category varchar2(20) not null,
quantity number(8) not null);


create sequence Pro_id_seq start with 1000;
commit;