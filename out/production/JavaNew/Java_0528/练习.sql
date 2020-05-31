create table goods(
    goods_id int,
    goods_name varchar(50),
    unit_price decimal(7,2),
    category varchar(50),
    provider varchar(50)
);

create table customer(
    customer_id int,
    name varchar(20),
    address varchar(50),
    email varchar(20),
    sex varchar(5),
    card_id varchar(20)
);


create table purchase (
    order_id int,
    customer_id int,
    goods_id int,
    nums int
)

create table student (
     id int,
     name varchar(30),
     score decimal(3,1),
     emaim varchar(50)
 );


 insert into student values(1,'test',80.5,'no@qq.com');

 select * from student;

 insert into student(id,name) values(2,'太上老君');
  insert into student(id,name) values(3,'赤脚大仙');

  create table exam_result(
      id int,
      name varchar(20),
      chinese decimal(3,1),
      math decimal(3,1),
      english decimal(3,1)
  );

  insert into exam_result values 
  (1,'岛市老八',45.9,66.5,76.4),
  (2,'抽象带篮子',99.9,99.5,96.4),
  (3,'带带大师兄',35.9,56.5,86.4),
  (4,'靳老师想开了',65.5,80.5,85.7),
  (5,'口子姐',60.9,76.5,56.4),
  (6,'小米粥',50.6,78.5,76.2);


select name,chinese + math + english as total from exam_result where chinese + math + english < 200;

select name,chinese,math from exam_result where chinese >60 and math > 60;

select name,chinese,english from exam_result where chinese > 80 or english  > 80;

select * from exam_result where chinese between 80 and 90;

select * from exam_result where name like '带%';
select * from exam_result where name like '带__';
select * from exam_result where chinese like '9%';

select name ,chinese + math + english as total from exam_result  order by chinese + math + english desc limit 3;
select name ,chinese + math + english as total from exam_result  order by total desc;
select name ,chinese + math + english as total from exam_result  order by total desc limit 3 offset 3;

update exam_result set chinese = 80 where name = '太一';   
update exam_result set math = 85,english = 86 where name = '太一';
update exam_result set chinese = chinese - 10; 
update exam_result set english = english + 10 order by chinese + math + english asc limit 3;
   select * from exam_result;

   select name,chinese from exam_result;

    select name,chinese + math + english from exam_result;

    select name,chinese + math + english as total from exam_result;

    select distinct chinese from exam_result;

    select * from exam_result order by chinese asc;
    select * from exam_result order by math desc;

    select name,chinese + math + english as total from exam_result order by total desc;

    create table student(id int, name varchar(20), score decimal(3,1));

    insert into student values
    (1,'曹操',90),
    (2,'刘备',80), 
    (3,'孙权',70)
    ;

    delete from student where name = '曹操';

    create table student(id int not null, name varchar(20), score decimal(3,1));

    create table student(id int UNIQUE, name varchar(20), score decimal(3,1));

    create table student(id int not null,name varchar(20) default 'unknown');

    create table student(id int, name varchar(20) primary key);

    create table student (id int primary key auto_increment, name varchar(20));

    insert into student values(null,'毛不易'),(null,'好妹妹');

    delete from student where name = '好妹妹';

    select * from student;

    insert into student values (null,'好妹妹');

    create table class(id int primary key auto_increment,name varchar(20));
    create table student(id int primary key auto_increment,
    name varchar(20),classId int, foreign key(classId) REFERENCES class(id));

    insert into class values(null,'物流171'),(null,'物流172'),(null,'物流173'),(null,'物流174');

    insert into student values(null,'浪客秦昊',1),(null,'张小厚',2),(null,'魏大勋',3);

    create table tmp (
        id int primary key auto_increment,
        name varchar(20),
        role varchar(20),
        salary decimai(7,2))
    )

    insert into tmp values 
    (null,'美猴王1','老师',20)




    select student.id , score.student_id , score.score from student ,score;
    select student.id , student.name, score.student_id, score.score  from student,score where student.id = score.student_id;
        select student.id , student.name, score.student_id, score.score  from student,score where student.id = score.student_id and student.name = '许仙';