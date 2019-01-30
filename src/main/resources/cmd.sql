create schema carpooling;
use carpooling;


create table carpooling.wallet (w_id integer primary key AUTO_INCREMENT, amount integer);
create table carpooling.user (u_id integer primary key AUTO_INCREMENT, email varchar(100) not null,
password varchar(100), w_id integer references wallet(w_id));

create table carpooling.vehicle (v_id integer primary key AUTO_INCREMENT, reg_no varchar(100) unique,
u_id integer references user(u_id), no_of_seats integer, name varchar(100));

create table carpooling.ride (r_id integer primary key AUTO_INCREMENT, 
driver_id integer references user(u_id),v_id integer references vehicle(v_id),source varchar(100),destination varchar(100),ride_date datetime, 
created_date datetime, cost_per_person integer,seats_available integer); 

create table carpooling.user_ride(r_id integer references ride(r_id),u_id integer references user(u_id),status varchar(100),no_of_seats integer,
requested_time datetime,accepted_time datetime);

create table carpooling.rider_status_history (r_id integer references ride(r_id), u_id integer references user(u_id), 
source varchar(100), destination varchar(100), status varchar(100), change_time datetime);

create table carpooling.wallet_history(transaction_id integer primary key AUTO_INCREMENT,r_id integer references ride(r_id),u_id integer 
references user(u_id),amount integer,transaction_date datetime,status varchar(100)); 

create table carpooling.email_history(r_id integer references ride(r_id), u_id integer references user(u_id),content varchar(2000),date datetime);



 
insert into wallet values(1,200);
insert into wallet values(2,200);
insert into wallet values(3,200);
insert into wallet values(4,200);

insert into user values(1, 'a@a.com', 'a', 1);
insert into user values(2, 'b@a.com', 'b', 2);
insert into user values(3, 'c@a.com', 'c', 3);
insert into user values(4, 'd@a.com', 'd', 4);

insert into vehicle values(1, 'TS 08 ER 1111', 1, 4, 'Tata Indica');
insert into vehicle values(2, 'TS 08 ER 2111', 1, 4, 'Tata Indica');
insert into vehicle values(3, 'TS 08 ER 3111', 2, 4, 'Tata Indica');
insert into vehicle values(4, 'TS 08 ER 4111', 3, 4, 'Tata Indica');

insert into ride values(1, 1, 1, 'himayathnagar', 'gachibowli', '2019-01-11 12:00:00', '2019-01-11 10:00:00', 200,4);
insert into ride values(2, 1, 1, 'himayathnagar', 'gachibowli', '2019-01-11 12:00:00', '2019-01-11 10:00:00', 200,4);
insert into ride values(3, 1, 1, 'himayathnagar', 'gachibowli', '2019-01-11 12:00:00', '2019-01-11 10:00:00', 200,4);
insert into ride values(4, 1, 1, 'himayathnagar', 'gachibowli', '2019-01-11 12:00:00', '2019-01-11 10:00:00', 200,4);

insert into user_ride values(1, 2,'pending',2,'2019-01-11 12:00:00','2019-01-11 10:00:00');
insert into user_ride values(1, 3,'approved',3,'2019-01-11 12:00:00','2019-01-11 10:00:00');
insert into user_ride values(1, 4,'approved',4,'2019-01-11 12:00:00','2019-01-11 10:00:00');
insert into user_ride values(1, 4,'requested',4,'2019-01-11 12:00:00','2019-01-11 10:00:00');