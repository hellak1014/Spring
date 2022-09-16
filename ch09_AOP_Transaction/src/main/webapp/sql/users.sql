create table users(
	id			varchar2(20)		primary key,
	password	varchar2(20),
	name		varchar2(20),
	role		varchar2(5)
);

insert into user values('admin', 'admin', '관리자', 'Admin');
insert into user values('hongkd', '1234', '홍길동', 'User');
