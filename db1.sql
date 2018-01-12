
CREATE TABLE tb_user(
  user_id VARCHAR (100) PRIMARY KEY ,
  user_name VARCHAR (100) NOT NULL UNIQUE ,
  user_password VARCHAR (100) NOT NULL ,
  user_role INTEGER
);


INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512613','admin','admin',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512614','41512100','41512100',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512615','41512101','41512101',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512616','41512102','41512102',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512617','41512103','41512103',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512618','41512104','41512104',1);
INSERT INTO `tb_user` (`user_id`,`user_name`,`user_password`,`user_role`) VALUES ('6512619','41512105','41512105',1);