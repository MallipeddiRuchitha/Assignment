use dbms_demo;
insert into teacher(name,password) values("ram","ram123");
insert into teacher(name,password) values("lauren","lar123");
insert into teacher(name,password) values("priya","caty123");

insert into teacher_details(teacher_id,highest_qualification,email,phone,address,city,state,zip) values(1,"phD","ram@gmail.com","9293456456","3-11/1","hyderabad","telangana","500074");
insert into teacher_details(teacher_id,highest_qualification,email,phone,address,city,state,zip) values(2,"phD","lauren@gmail.com","9294456456","3-16/1","chennai","tamilnadu","500674");
insert into teacher_details(teacher_id,highest_qualification,email,phone,address,city,state,zip) values(3,"phD","caty@gmail.com","9287456456","3-11/4","hyderabad","telangana","500074");
  
  insert into course(name,provider) values("java","coursera");
  insert into course(name,provider) values("machine learning","udemy");
  insert into course(name,provider) values("dbms","coursera");
  
  insert into course_details(course_id,duration,fee,description) values(1,5,2500,"Java is a general-purpose programming language that is object-oriented programming language");
  insert into course_details(course_id,duration,fee,description) values(2,8,2000,"Machine learning is a method of data analysis that automates analytical model building.");
  insert into course_details(course_id,duration,fee,description) values(3,4,3500,"Database management system is a software which is used to manage the database");
  
  insert into teacher_course(course_id,teacher_id) values(1,1);
   insert into teacher_course(course_id,teacher_id) values(2,2);
    insert into teacher_course(course_id,teacher_id) values(3,3);
     insert into teacher_course(course_id,teacher_id) values(1,3);
      insert into teacher_course(course_id,teacher_id) values(3,2);
       insert into teacher_course(course_id,teacher_id) values(2,1);
  
      
  
  
  
  
