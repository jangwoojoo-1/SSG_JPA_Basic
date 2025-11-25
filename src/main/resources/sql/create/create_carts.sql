use gallery;

drop table carts;
create table carts
(
    id       int primary key auto_increment comment '아이디',
    member_id int  not null comment '회원 아이디',
    item_id int not null comment '상품 아이디',
    created  datetime     not null default current_timestamp() comment '생성 일시'
) comment '장바구니 테이블';


