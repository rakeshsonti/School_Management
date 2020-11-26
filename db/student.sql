create table student(
roll_number int primary key,
name char(35) not null unique,
mobile_number char(15) not null unique,
date_of_birth date not null,
gender char(1) not null,
is_indian boolean not null,
city_code int not null,
foreign key(city_code) references city);
