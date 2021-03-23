
create table users (id serial PRIMARY KEY);
create table cart (id serial PRIMARY KEY,user_id integer references users(id),items text);
create table users (id serial PRIMARY KEY,shop_id integer references shop(id),email text,password text,address text,isAdmin boolean);
create table shop (id serial PRIMARY KEY,name text,title text,carts text);
create table Orders (id serial PRIMARY KEY,shop_id integer references shop(id),time text,status boolean,user text,items text);
create table Item (id serial PRIMARY KEY,shop_id integer references shop(id),name text,price integer ,info text);
create table Categories (id serial PRIMARY KEY,shop_id integer references shop(id),name text);



