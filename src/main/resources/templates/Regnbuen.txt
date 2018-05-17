drop database if exists Regnbuen;
create database Regnbuen;

use Regnbuen;

create table School (
	school_id tinyint primary key,
    school_name varchar(30),
    school_address varchar(30),
    school_phone varchar(8)

);

create table Grade (
	grade_id tinyint primary key,
    grade_name varchar(2)
);

create table Doctor (
	doctor_id tinyint primary key,
    clinic_phone varchar(8),
    doctor_first_name varchar(20),
    doctor_last_name varchar(50)
);

create table Parent (
	parent_id int primary key,
    parent_first_name varchar(20),
    parent_last_name varchar(50),
    parent_phone varchar(8),
    parent_workplace_phone varchar(8)
    
);

create table Member (
	member_id int primary key,
    first_name varchar(20),
    last_name varchar(50),
    gender tinyint,
    member_phone varchar(8),
    enrollment_date date,
    date_of_resignation date,
    has_allergies varchar(1),
    school_id tinyint,
    grade_id tinyint,
    doctor_id tinyint,
    
    foreign key(school_id) references School(school_id),
    foreign key(grade_id) references Grade(grade_id),
    foreign key(doctor_id) references Doctor(doctor_id)

);

create table Parent_Member_Relation (
	parent_id int,
    member_id int,
    
    foreign key (parent_id) references Parent(parent_id),
	foreign key (member_id) references Member(member_id)	
);