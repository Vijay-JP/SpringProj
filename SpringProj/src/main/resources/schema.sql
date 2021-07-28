DROP TABLE IF EXISTS INVESTMENTS;

CREATE TABLE INVESTMENTS(
	investment_id bigint auto_increment  PRIMARY KEY,
    portal varchar(50) not null,
    investment_date varchar(50) not null,
    amount float not null)