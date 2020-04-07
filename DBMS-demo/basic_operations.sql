use dbms_demo;
-- gives name ,highest_qualification of teachers from hyderabad
select  name,highest_qualification 
from teacher 
inner join teacher_details  on(teacher.teacher_id=teacher_details.teacher_id)
where city="hyderabad";

-- gives list of teachers(name) who teaches dbms
select teacher.name 
from teacher
inner join teacher_course on (teacher_course.teacher_id=teacher.teacher_id)
inner join course on (course.course_id=teacher_course.course_id)
where course.name="dbms";

/*gives list of corses(name) provided by udemy */
select name
from course
where provider="udemy";

-- deleting  a course without deleting associated teachers
delete from teacher_course where course_id=1;
delete from course_details where course_id=1;
delete from course where course_id=1;

-- deleting  a teacher without deleting associated courses
delete from teacher_course where teacher_id=2;
delete from teacher_details where teacher_id=2;
delete from teacher where teacher_id=2;




