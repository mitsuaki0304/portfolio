set names utf8;
set foreign_key_checks = 0;
drop database if exists lefigaro;

create database if not exists lefigaro;
use lefigaro;

create table login_user_info(
id int not null primary key auto_increment,
user_id varchar(16) unique,
user_pass varchar(16),
family_name varchar(32),
first_name varchar(32),
family_name_kana varchar(32),
first_name_kana varchar(32),
email varchar(32),
login_flg varchar(1),
regist_date datetime,
update_date datetime
);

insert into login_user_info(user_id, user_pass, family_name, first_name, family_name_kana, first_name_kana, email, regist_date, update_date)
values
("guest1","guest1","ユーザー","ゲストイチ","ゆーざー","げすといち","guest1@gmail.com",now(),now()),
("guest2","guest2","ユーザー","ゲストニ","ゆーざー","げすとに","guest2@gmail.com",now(),now()),
("guest3","guest3","ユーザー","ゲストサン","ゆーざー","げすとさん","guest3@gmail.com",now(),now()),
("guest4","guest4","ユーザー","ゲストヨン","ゆーざー","げすとよん","guest4@gmail.com",now(),now()),
("guest5","guest5","ユーザー","ゲストゴ","ゆーざー","げすとご","guest5@gmail.com",now(),now()),
("guest6","guest6","ユーザー","ゲストロク","ゆーざー","げすとろく","guest6@gmail.com",now(),now()),
("guest7","guest7","ユーザー","ゲストナナ","ゆーざー","げすとなな","guest7@gmail.com",now(),now()),
("guest8","guest8","ユーザー","ゲストハチ","ゆーざー","げすとはち","guest8@gmail.com",now(),now()),
("guest9","guest9","ユーザー","ゲストク","ゆーざー","げすとく","guest9@gmail.com",now(),now()),
("guest10","guest10","ユーザー","ゲストジュウ","ゆーざー","げすとじゅう","guest10@gmail.com",now(),now()),
("a","a","田中","太郎","たなか","たろう","taro@gmail.com",now(),now());

create table product_info(
id int primary key not null auto_increment,
product_id int unique not null,
product_name varchar(100) unique not null,
product_detail varchar(255) not null,
category_id int not null,
price int,
weight int,
vintage int,
area varchar(30),
kind varchar(30),
taiste varchar(30),
review_star int,
review_user_count int,
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名"
);
INSERT INTO product_info(product_id, product_name, product_detail, category_id, price,
weight, vintage, area,kind, taiste, review_star, review_user_count,image_file_path,image_file_name)
VALUES
(1,"サングレ・デトロ・オリジナル","説明文が入ります",1,15000,750,1980,"イタリア","カベルネソーヴィニヨン","ライト",0,0,"./images","product01.jpg"),
(2,"レゼルヴァ・カベルネソーヴィニヨン","説明文が入ります",1,6320,750,1990,"フランス","カベルネソーヴィニヨン","ミドル",0,0,"./images","product02.jpg"),
(3,"スクリーミング・カベルネソーヴィニヨン","説明文が入ります",1,4200,750,1940,"アメリカ","カベルネソーヴィニヨン","ライト",0,0,"./images","product03.jpg"),
(4,"シャトー・ラシィット・ロスチャイルド","説明文が入ります",1,45000,750,1920,"フランス","カベルネソーヴィニヨン","ミドル",0,0,"./images","product04.jpg"),
(5,"ヴィラ・アンティノリ・ロッド","説明文が入ります",1,15000,750,1980,"イタリア","メルロー","フルボディ",0,0,"./images","product05.jpg"),
(6,"オーパスワン・メルロー・オリジナル","説明文が入ります",1,9000,750,1980,"アメリカ","メルロー","ライト",0,0,"./images","product06.jpg"),
(7,"シレニー・ピノ・ノワール","説明文が入ります",1,15500,750,1980,"フランス","ピノ・ノワール","ライト",0,0,"./images","product07.jpg"),
(8,"ロス・カーネロス・ピノ・ノワール","説明文が入ります",1,9000,750,1910,"アメリカ","ピノ・ノワール","ライト",0,0,"./images","product08.jpg"),
(9,"丹波ワイン・マスカット・ベーリーA","説明文が入ります",1,500,750,2000,"日本","甲州","ミドル",0,0,"./images","product09.jpg"),
(10,"ラフィーユ・樽ベーリーA","説明文が入ります",1,2000,750,1990,"日本","甲州","フルボディ",0,0,"./images","product10.jpg"),
(11,"モンテス・アルファ・シャルドネ","説明文が入ります",2,4000,750,1990,"チリ","カベルネソーヴィニヨン","フルボディ",0,0,"./images","product11.jpg"),
(12,"リースリング・アルファ・シャルドネ","説明文が入ります",2,22000,750,1940,"フランス","リースリング","ライト",0,0,"./images","product12.jpg"),
(13,"ムートン・カデ・ソーヴィニヨン・ブラン","説明文が入ります",2,1000,750,1980,"フランス","カベルネソーヴィニヨン","ライト",0,0,"./images","product13.jpg"),
(14,"いろ甲州・マスカット・ベーリーA","説明文が入ります",2,7000,750,1990,"日本","甲州","ライト",0,0,"./images","product14.jpg"),
(15,"リースリング・セレクション・ヴィーシュ","説明文が入ります",2,35000,750,1990,"フランス","リースリング","ミドル",0,0,"./images","product15.jpg"),
(16,"喜・スパークリング・シャルドネ","説明文が入ります",3,6400,750,1990,"日本","甲州","ライト",0,0,"./images","product16.jpg"),
(17,"スパークリング・クレマン・ド・ブルゴーニュ","説明文が入ります",3,10000,750,1990,"フランス","メルロー","フルボディ",0,0,"./images","product17.jpg");



create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16),
temp_user_id varchar(255) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
total_price int not null comment "金額",
regist_date datetime not null comment "登録日"
);

create table user_destination(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
tel_num varchar(13) not null comment "電話番号",
address_num varchar(13) not null comment "郵便番号",
region varchar(32) not null comment "都道府県",
city varchar(32) not null comment "市町村",
other varchar(32) not null comment "その他建物"
);
INSERT INTO user_destination(user_id, family_name, first_name, family_name_kana, first_name_kana,
tel_num,address_num, region ,city, other)
VALUES
("a","田中","太郎","たなか","たろう","09012345678","1750082","東京都","板橋区高島平５丁目23-2","高島平ハウス201号");

create table user_review(
id int primary key not null auto_increment,
user_id varchar(16),
product_id int,
title varchar(255),
review_star int not null,
comment varchar(320)
);
INSERT INTO user_review(user_id, product_id, title, review_star, comment)
VALUES
("guest1", 1, "いい買い物しました", 4, "コメント入れます"),
("guest1", 2, "いい買い物しました", 5, "コメント入れます"),
("guest1", 3, "いい買い物しました", 5, "コメント入れます"),
("guest2", 1, "いい買い物しました", 2, "コメント入れます"),
("guest3", 1, "いい買い物しました", 3, "コメント入れます"),
("guest4", 1, "いい買い物しました", 5, "コメント入れます");


create table user_buy_history(
id int not null primary key auto_increment,
user_id varchar(16),
product_id int,
product_count int,
total_price int,
destination_id int,
regist_date datetime not null comment "登録日"
)
default charset=utf8
;





