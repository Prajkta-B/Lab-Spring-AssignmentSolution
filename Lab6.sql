create database if not exists studentdata;

use studentdata;

Insert into roles values
(1,"ADMIN"),
(2,"USER");

Insert into user values
(11,"$2a$12$din9NktjLGm6q2VtWxRztOnhFVGzLzzS5fzxbzo1p4wcBEemXtoIW","prajkta"),
(22,"$2a$12$din9NktjLGm6q2VtWxRztOnhFVGzLzzS5fzxbzo1p4wcBEemXtoIW","pranav");

Insert into user_roles values
(11,1),
(22,2);


