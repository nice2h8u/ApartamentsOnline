insert into user(login, hash,user_type) values ('user','$2a$04$qzvZPxjlKJbJqqIx4Wo66uFX16w3b.mQ6GV8GW86QDRKEHbvNqUYW',1);
insert into apart(apart_name,apart_city, apart_address, apart_phone,  apart_x, apart_y, apart_cost, apart_description) VALUES
('Europe','SPB','Nevskiy prospect, 78','2285992','32','324',4500,'Hotel at the middle of SPB');

insert into apart(apart_name,apart_city, apart_address, apart_phone,  apart_x, apart_y, apart_cost, apart_description) VALUES
('Hilton','SPB','Nevskiy prospect, 26','2282121','32','843',4300,'Greatesst Hotel of SPB');

insert into zak(order_name,order_date_begin, order_date_end,  order_cost, apart_id,user_id) VALUES
  ('first order','2017-04-03','2017-04-03',4000,1,1);



