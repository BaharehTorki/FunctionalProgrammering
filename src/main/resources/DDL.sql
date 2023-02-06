# ---------------------      DDL ------------------------
drop
database if exists mySQLAssignment;
create
database mySQLAssignment;
use
mySQLAssignment;


create table avdelningar
(
    avdelningId int auto_increment not null primary key,
    name        varchar(20) not null
);
INSERT INTO `mysqlassignment`.`avdelningar` (`name`)
VALUES ('man');
INSERT INTO `mysqlassignment`.`avdelningar` (`name`)
VALUES ('dam');
INSERT INTO `mysqlassignment`.`avdelningar` (`name`)
VALUES ('barn');


create table kategorier
(
    kategoryId int auto_increment not null primary key,
    name       varchar(20) not null
);

INSERT INTO mysqlassignment.kategorier (name)
VALUES ('PlattaSkor');
INSERT INTO mysqlassignment.kategorier (name)
VALUES ('sport');
INSERT INTO mysqlassignment.kategorier (name)
VALUES ('party');
INSERT INTO mysqlassignment.kategorier (name)
VALUES ('sneakers');
INSERT INTO mysqlassignment.kategorier (name)
VALUES ('vinterskor');


create table produkt
(
    id          int         not null auto_increment primary key,
    storlek     int         not null,
    märke       varchar(20) not null,
    färg        varchar(20) not null,
    pris        int         not null,
    kategoryId  int         not null,
    avdelningId int         not null,
    created     timestamp default current_timestamp,
    updated     timestamp default null ON UPDATE CURRENT_TIMESTAMP,
    foreign key (avdelningId) references avdelningar (avdelningId),
    foreign key (kategoryId) references kategorier (kategoryId)
);


create table adress
(
    id      int auto_increment not null primary key,
    zipkod  int         not null,
    postOrt varchar(20) not null,
    created timestamp default current_timestamp,
    updated timestamp default null ON UPDATE CURRENT_TIMESTAMP
);

create table kund
(
    id           int         not null auto_increment primary key,
    lösenord     varchar(20) not null,
    username     varchar(20) not null,
    namn         varchar(10) not null,
    efternamn    varchar(10) not null,
    adressId     int,

    updated      timestamp default null ON UPDATE CURRENT_TIMESTAMP,
    foreign key (adressId) REFERENCES adress (id)
);

insert into produkt (storlek, färg, märke, pris, kategoryId, avdelningId)
values (38, 'vit', 'Ecco', 300, 1, 1),
       (37, 'svart', 'Puma', 100, 2, 3),
       (36, 'blå', 'Ecco', 350, 4, 2),
       (37, 'svart', 'Reebok', 270, 2, 3),
       (32, 'grön', 'Timberland', 290, 3, 2),
       (38, 'vit', 'Ecco', 50, 4, 1),
       (40, 'svart', 'Nike', 420, 3, 2),
       (32, 'blå', 'Timberland', 150, 5, 2),
       (38, 'Grön', 'Ecco', 300, 3, 2),
       (34, 'blå', 'Polo', 270, 1, 1),
       (39, 'Rosa', 'Reebok', 280, 2, 3),
       (32, 'vit', 'Puma', 190, 5, 1),
       (37, 'Rosa', 'Timberland', 450, 3, 3),
       (38, 'vit', 'Ecco', 200, 4, 2);


select *
from produkt;


insert into adress (zipkod, postOrt)
values (21, 'Huddinge'),
       (22, 'Solna'),
       (23, 'Sollentuna'),
       (24, 'Häggvik'),
       (25, 'Stockholm'),
       (26, 'Lidingö'),
       (27, 'Södermalm'),
       (28, 'Norrviken');

insert into kund(username, lösenord, namn, efternamn, adressId)
values ('username1', 'a1', 'Simon', 'Eriksson', 1),
       ('username2', 'b2', 'Maria', 'Lund', 2),
       ('username3', 'c3', 'Lina', 'Johansson', 3),
       ('username4', 'd4', 'Sofia', 'Edlund', 4),
       ('username5', 'e5', 'Emilia', 'Petersson', 3),
       ('username6', 'f6', 'Mikael', 'Elvinsson', 4),
       ('username7', 'g7', 'Robin', 'Falk', 4),
       ('username8', 'h8', 'Oskar', 'Andersson', 5),
       ('username9', 'i9', 'Maria', 'Johansson', 6),
       ('username10', 'j1', 'Jonathan', 'Björklund', 7),
       ('username11', 'k2', 'David', 'Jacobsson', 7),
       ('username12', 'l3', 'Kristina', 'Fröjd', 8),
       ('username13', 'm4', 'Anna', 'Petersson', 8);

create table beställning
(
    id             int         not null auto_increment primary key,
    beställningsId varchar(16) not null,
    köpdatum       timestamp default current_timestamp,
    produktId      int         not null,
    kundId         int         not null,
    updated        timestamp default current_timestamp,
    foreign key (produktId) references produkt (id),
    foreign key (kundId) references kund (id)
);


insert into beställning (beställningsId, köpdatum, produktId, kundId)
values ('001001', '2023-01-14', 2, 1),
       ('001001', '2023-01-14', 1, 1),
       ('004001', '2022-10-17', 14, 4),
       ('005001', '2022-10-15', 4, 5),
       ('002001', '2023-01-12', 5, 2),
       ('002001', '2023-01-12', 3, 2),
       ('002001', '2023-01-12', 4, 2),
       ('008001', '2023-01-15', 14, 8),
       ('002002', '2023-01-14', 5, 2),
       ('004001', '2022-11-13', 3, 4),
       ('005002', '2022-12-12', 4, 5),
       ('001002', '2022-12-14', 5, 1),
       ('001002', '2022-11-15', 14, 1);

create table lager
(
    id          int not null auto_increment primary key,
    produktId   int not null,
    antalIlager int not null,
    updated     timestamp on update current_timestamp,
    foreign key (produktId) references produkt (id)
);

INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (1, 10);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (2, 50);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (3, 70);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (4, 15);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (5, 30);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (6, 10);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (7, 50);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (8, 70);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (9, 15);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (10, 30);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (11, 0);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (12, 10);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (13, 18);
INSERT INTO `mysqlassignment`.`lager` (produktId, antalIlager)
VALUES (14, 30);


