create database lojainformatica;

use lojainformatica;

create table computador(
	id int primary key auto_increment,
    marca varchar(15),
    hd varchar(10),
    processador varchar(10)
);