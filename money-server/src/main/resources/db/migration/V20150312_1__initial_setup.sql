/*
 * Initial database setup.
 * 
 * Matthias Köhler, 12.03.2015 
 */

create table Account (
	id bigint not null auto_increment, 
	name varchar(255), 
	currency_id bigint, 
	primary key (id)
);

create table Currency (
	id bigint not null auto_increment, 
	active boolean, 
	isoCode varchar(255), 
	name varchar(255), 
	primary key (id)
);

create table Transaction (
	id bigint not null auto_increment, 
	amount decimal(19,2), 
	date date, 
	description varchar(255), 
	account_id bigint, 
	currency_id bigint, 
	primary key (id)
);

alter table Account add index IDX_ACCOUNT_CURRENCY (currency_id), add constraint FK_ACCOUNT_CURRENCY foreign key (currency_id) references Currency (id);
alter table Transaction add index IDX_TRANSACTION_CURRENCY (currency_id), add constraint FK_TRANSACTION_CURRENCY foreign key (currency_id) references Currency (id);
alter table Transaction add index IDX_TRANSACTION_ACCOUNT (account_id), add constraint FK_TRANSACTION_ACCOUNT foreign key (account_id) references Account (id);