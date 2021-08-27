
#123456Ab
#123
INSERT IGNORE  INTO `school`.`app_user` (`uuid`,`created_date`,`updated_date`,`version`,`active`,`user_name`, `password`) values ('ab38c1cd-5a50-41de-844e-14afd6cdb5a1','2019-05-09 10:21:36','2019-05-09 10:21:36',1,1, 'raed', '$2a$10$T0yMRAGW/I3jXtFBTuUEIup76IT5vYRUiDlXPjJN4loP2.Aa4kmQm'); 
INSERT IGNORE  INTO `school`.`app_user` (`uuid`,`created_date`,`updated_date`,`version`,`active`,`user_name`, `password`) values ('ab38c1cd-5a50-41de-844e-14afd6cdb5a2','2019-05-09 10:21:36','2019-05-09 10:21:36',1,1, 'christeen', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');


INSERT IGNORE  INTO `school`.`user_role` (`uuid`,`created_date`,`updated_date`,`version`, `user_id`, `user_role` ) VALUES ('ab38c1cd-5a50-41de-844e-14afd6cdb5a1','2019-05-09 10:21:36','2019-05-09 10:21:36',1, 'ab38c1cd-5a50-41de-844e-14afd6cdb5a1', 'ROLE_ADMIN');
INSERT IGNORE  INTO `school`.`user_role` (`uuid`,`created_date`,`updated_date`,`version`, `user_id`, `user_role` ) VALUES ('ab38c1cd-5a50-41de-844e-14afd6cdb5a2','2019-05-09 10:21:36','2019-05-09 10:21:36',1, 'ab38c1cd-5a50-41de-844e-14afd6cdb5a2', 'ROLE_USER');


INSERT IGNORE  INTO `school`.`document`(`uuid`,`created_date`,`updated_date`,`version`,`name`,`active`) VALUES ('ab38c1cd-5a50-41de-844e-14afd6cdb5a1','2019-05-09 10:21:36','2019-05-09 10:21:36',1,'Anmeldebescheinigung',1);
