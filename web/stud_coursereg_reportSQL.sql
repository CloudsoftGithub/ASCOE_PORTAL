SELECT
     *,
     student_course_reg.`matricno` AS student_course_reg_matricno,
     student_course_reg.`name` AS student_course_reg_name,
     student_course_reg.`student_level` AS student_course_reg_student_level,
     student_course_reg.`session` AS student_course_reg_session,
     student_course_reg.`semester` AS student_course_reg_semester,
     student_course_reg.`course_code` AS student_course_reg_course_code,
     student_course_reg.`course_title` AS student_course_reg_course_title,
     student_course_reg.`credit_unit` AS student_course_reg_credit_unit,
     student_course_reg.`dateregistered` AS student_course_reg_dateregistered
FROM
     `student_course_reg` student_course_reg
WHERE
     matricno = ?
 AND session = ?