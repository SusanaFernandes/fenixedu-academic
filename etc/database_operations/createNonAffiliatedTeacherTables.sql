CREATE TABLE NON_AFFILIATED_TEACHER(
	ID_INTERNAL int(11) NOT NULL auto_increment, 
	NAME varchar(100) NOT NULL,
	KEY_INSTITUTION  int(11) NOT NULL,
	ACK_OPT_LOCK int(11) default NULL,
    PRIMARY KEY  (ID_INTERNAL),
    UNIQUE KEY U1 (NAME, KEY_INSTITUTION)
) TYPE=InnoDB;

CREATE TABLE INSTITUTION(
	ID_INTERNAL int(11) NOT NULL auto_increment, 
	NAME varchar(100) NOT NULL,	
	ACK_OPT_LOCK int(11) default NULL,
    PRIMARY KEY  (ID_INTERNAL),
    UNIQUE KEY U1 (NAME)
) TYPE=InnoDB;
