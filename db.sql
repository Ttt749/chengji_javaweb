create table student(
  s_id VARCHAR (100) PRIMARY KEY ,
  s_name VARCHAR (100) NOT NULL ,
  s_age INTEGER ,
  s_sex VARCHAR (1),
  S_class VARCHAR (100)
);
create table course(
  c_id VARCHAR (100) PRIMARY KEY ,
  c_name VARCHAR (100) NOT NULL UNIQUE ,
  c_attr VARCHAR (100),
  c_classroom VARCHAR (100)
);
CREATE TABLE teacher(
  t_id VARCHAR (100) PRIMARY KEY ,
  t_name VARCHAR (100) NOT NULL ,
  t_age INTEGER NOT NULL ,
  t_sex VARCHAR (10) NOT NULL ,
  t_school VARCHAR (100) NOT NULL ,
  t_graduate VARCHAR (100) ,
  t_text VARCHAR (1000)
);
create table s_c(
  s_id VARCHAR (100),
  c_id VARCHAR (100),
  s_c_score INTEGER,
  PRIMARY KEY(s_id,c_id),
	CONSTRAINT student_id_fk FOREIGN KEY (s_id) REFERENCES student(s_id),
	CONSTRAINT course_id_fk FOREIGN KEY (c_id) REFERENCES course(c_id)
);
CREATE TABLE t_c(
  t_id VARCHAR (100),
  c_id VARCHAR (100),
  PRIMARY KEY (t_id,c_id),
  CONSTRAINT teacher_id_fk FOREIGN KEY (t_id) REFERENCES teacher(t_id),
	CONSTRAINT course_id_fk1 FOREIGN KEY (c_id) REFERENCES course(c_id)
);
CREATE TABLE tb_user(
  user_id VARCHAR (100) PRIMARY KEY ,
  user_name VARCHAR (100) NOT NULL UNIQUE ,
  user_password VARCHAR (100) NOT NULL ,
  user_role INTEGER
);

INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512100','张三',18,'男','软工1502');
INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512101','李四',19,'男','软工1502');
INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512102','王五',20,'男','软工1502');
INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512103','王明',21,'男','软工1502');
INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512104','李华',20,'男','软工1502');
INSERT INTO `student` (`s_id`,`s_name`,`s_age`,`s_sex`,`s_class`) VALUES ('41512105','李东',21,'男','软工1502');

INSERT INTO `course` (`c_id`,`c_name`,`c_attr`,`c_classroom`) VALUES ('c451265','数据结构','必修','文津1620');
INSERT INTO `course` (`c_id`,`c_name`,`c_attr`,`c_classroom`) VALUES ('c451266','算法','必修','文津1520');
INSERT INTO `course` (`c_id`,`c_name`,`c_attr`,`c_classroom`) VALUES ('c451267','高数','必修','文津1420');
INSERT INTO `course` (`c_id`,`c_name`,`c_attr`,`c_classroom`) VALUES ('c451268','线性代数','必修','文津1320');

INSERT INTO `teacher` (`t_id`,`t_name`,`t_sex`,`t_age`,`t_school`,`t_graduate`,`t_text`) VALUES ('1999058','张晓春','男',40,'计算机科学学院','清华大学','');
INSERT INTO `teacher` (`t_id`,`t_name`,`t_sex`,`t_age`,`t_school`,`t_graduate`,`t_text`) VALUES ('1999059','承宪春','男',40,'计算机科学学院','清华大学','');
INSERT INTO `teacher` (`t_id`,`t_name`,`t_sex`,`t_age`,`t_school`,`t_graduate`,`t_text`) VALUES ('1999060','吴晓春','女',40,'计算机科学学院','清华大学','');
INSERT INTO `teacher` (`t_id`,`t_name`,`t_sex`,`t_age`,`t_school`,`t_graduate`,`t_text`) VALUES ('1999057','郑晓春','男',40,'计算机科学学院','清华大学','');
INSERT INTO `teacher` (`t_id`,`t_name`,`t_sex`,`t_age`,`t_school`,`t_graduate`,`t_text`) VALUES ('1999056','王晓春','女',40,'计算机科学学院','清华大学','');

INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512100','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512100','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512100','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512100','c451268',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512101','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512101','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512101','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512101','c451268',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512102','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512102','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512102','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512102','c451268',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512103','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512103','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512103','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512103','c451268',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512104','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512104','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512104','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512104','c451268',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512105','c451265',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512105','c451266',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512105','c451267',0);
INSERT INTO `s_c` (`s_id`,`c_id`,`s_c_score`) VALUES ('41512105','c451268',0);

INSERT INTO `t_c` (`t_id`,`c_id`) VALUES ('1999056','c451265');
INSERT INTO `t_c` (`t_id`,`c_id`) VALUES ('1999057','c451266');
INSERT INTO `t_c` (`t_id`,`c_id`) VALUES ('1999058','c451267');
INSERT INTO `t_c` (`t_id`,`c_id`) VALUES ('1999059','c451268');

INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512613','admin','admin',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512614','41512100','41512100',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512615','41512101','41512101',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512616','41512102','41512102',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512617','41512103','41512103',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512618','41512104','41512104',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512619','41512105','41512105',1);