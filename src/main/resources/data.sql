insert into user(login, hash,user_type,email) values
  ('admin','$2a$04$qzvZPxjlKJbJqqIx4Wo66uFX16w3b.mQ6GV8GW86QDRKEHbvNqUYW','ADMIN','nice2h8u@gmail.com');
insert into user(login, hash,user_type,email) values
  ('user','$2a$04$qzvZPxjlKJbJqqIx4Wo66uFX16w3b.mQ6GV8GW86QDRKEHbvNqUYW','USER','owesterg@gmail.com');
insert into apart(apart_name,apart_city, apart_address, apart_phone,  apart_x, apart_y, apart_cost, apart_description,apart_image_url) VALUES
  ('Europe','Spb','Nevskiy prospect, 78','2285992','59.94','30.28',4500,'Hotel at the middle of SPB','https://gogolhotel.ru/images/r2.jpg');

insert into apart(apart_name,apart_city, apart_address, apart_phone,  apart_x, apart_y, apart_cost, apart_description,apart_image_url) VALUES
  ('Hilton','Moscow','Nevskiy prospect, 26','2282121','59.01','31.38',4300,'Greatesst Hotel of SPB','https://kazanriviera.ru/images/standart_double1_b.jpg');

insert into apart(apart_name,apart_city, apart_address, apart_phone,  apart_x, apart_y, apart_cost, apart_description,apart_image_url) VALUES
  ('Reddison','Spb','Sadovaya, 19','2282129','55.71','37.52',8300,'Luxure Hotel','https://t-ec.bstatic.com/images/hotel/max1280x900/433/43346502.jpg');

insert into zak(order_name,order_date_begin, order_date_end,  order_cost, apart_id,user_id) VALUES
  ('first order','2018-06-11','2018-06-13',8600,1,1);

insert into zak(order_name,order_date_begin, order_date_end,  order_cost, apart_id,user_id) VALUES
  ('second order','2018-06-10','2018-06-11',8300,3,1);