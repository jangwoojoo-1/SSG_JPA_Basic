use gallery;

drop table items;
create table items(
  id int comment '아이디',
  name varchar(50) not null comment '상품 이름',
  img_path varchar(100) not null comment '상품 사진 경로',
    price int not null comment '상품 가격',
    discount_per int not null comment '상품 할인율',
    created datetime not null default current_timestamp() comment '생성 일시'
);

alter table items add constraint PK_items PRIMARY KEY (id);
alter table items modify  id int AUTO_INCREMENT;

INSERT INTO items (name, img_path, price, discount_per)
VALUES ('Starry', '/img/001.jpg', 10000000, 5)
     , ('Seascape', '/img/002.jpg', 20000000, 10)
     , ('Arles', '/img/003.jpg', 30000000, 15)
     , ('Mountain', '/img/004.jpg', 40000000, 20)
     , ('Provence', '/img/005.jpg', 50000000, 25)
     , ('Houses', '/img/006.jpg', 60000000, 30);