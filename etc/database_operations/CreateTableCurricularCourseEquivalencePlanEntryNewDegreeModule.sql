create table CURRICULAR_COURSE_EQUIVALENCE_PLAN_ENTRY_NEW_DEGREE_MODULE (
	KEY_DEGREE_MODULE int(11) not null, 
	KEY_CURRICULAR_COURSE_EQUIVALENCE_PLAN_ENTRY int(11) not null,  
	primary key (KEY_DEGREE_MODULE, KEY_CURRICULAR_COURSE_EQUIVALENCE_PLAN_ENTRY), 
	key(KEY_DEGREE_MODULE), 
	key(KEY_CURRICULAR_COURSE_EQUIVALENCE_PLAN_ENTRY)
) type=InnoDB;
