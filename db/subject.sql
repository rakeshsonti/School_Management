create table subject
(
code int primary key generated always as identity(start with 1,increment by 1),
name char(35) not null unique);