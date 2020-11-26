create table student_subject(
roll_number int not null,
subject_code int not null,
primary key(roll_number,subject_code),
foreign key(roll_number) references student,
foreign key(subject_code) references subject);
