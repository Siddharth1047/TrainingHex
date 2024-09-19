show databases;
-- create database HMBank
create database if not exists HMBank;

use HMBank;

-- create 3 tables and enter 10 sample records
create table Customers(
customer_id int not null primary key,
first_name varchar(20),
last_name varchar(20),
dob date,
email varchar(30),
phone_no varchar(20) not null
);

INSERT INTO Customers VALUES
(1, 'John', 'Doe', '1990-05-14', 'johndoe@gmail.com', 1234567890),
(2, 'Jane', 'Smith', '1985-08-22', 'janesmith@yahoo.com', 2345678901),
(3, 'Michael', 'Johnson', '1992-03-10', 'mjohnson@hotmail.com', 3456789012),
(4, 'Emily', 'Brown', '1988-12-30', 'emilybrown@gmail.com', 4567890123),
(5, 'David', 'Wilson', '1995-07-18', 'dwilson@outlook.com', 5678901234),
(6, 'Sophia', 'Lee', '1993-11-25', 'sophialee@gmail.com', 6789012345),
(7, 'James', 'Clark', '1987-02-05', 'jamesclark@gmail.com', 7890123456),
(8, 'Olivia', 'Martinez', '1991-06-15', 'oliviamartinez@yahoo.com', 8901234567),
(9, 'Daniel', 'Rodriguez', '1994-10-09', 'drodriguez@hotmail.com', 9012345678),
(10, 'Isabella', 'Garcia', '1989-04-21', 'isabellagarcia@gmail.com', 1234509876);


create table Accounts(
account_id int not null primary key,
customer_id int not null,
account_type varchar(20),
amount int not null,
transaction_date date,
foreign key (customer_id) references Customers(customer_id)
);

INSERT INTO Accounts VALUES
(1, 1, 'Savings', 1500, '2024-01-10'),
(2, 2, 'Checking', 3200, '2024-01-15'),
(3, 3, 'Savings', 4500, '2024-01-20'),
(4, 4, 'Checking', 2800, '2024-01-25'),
(5, 5, 'Savings', 5000, '2024-02-01'),
(6, 6, 'Checking', 2300, '2024-02-05'),
(7, 7, 'Savings', 6100, '2024-02-10'),
(8, 8, 'Checking', 4700, '2024-02-15'),
(9, 9, 'Savings', 5500, '2024-02-20'),
(10, 10, 'Checking', 6200, '2024-02-25');


create table Transactions(
transaction_id int not null primary key,
account_id int not null,
transaction_type varchar(20),
amount int not null,
transaction_date date,
foreign key (account_id) references Accounts(account_id)
);

INSERT INTO Transactions VALUES
(1, 1, 'Deposit', 500, '2024-03-01'),
(2, 2, 'Withdrawal', 300, '2024-03-05'),
(3, 3, 'Deposit', 1000, '2024-03-10'),
(4, 4, 'Withdrawal', 400, '2024-03-12'),
(5, 5, 'Deposit', 1500, '2024-03-15'),
(6, 6, 'Withdrawal', 200, '2024-03-18'),
(7, 7, 'Deposit', 2000, '2024-03-20'),
(8, 8, 'Withdrawal', 600, '2024-03-25'),
(9, 9, 'Deposit', 1200, '2024-03-27'),
(10, 10, 'Withdrawal', 800, '2024-03-30');

-- verifying the entries
select * from Accounts;
select * from Customers;

-- write sql queries

select CONCAT(c.first_name, ' ', c.last_name) as name, a.account_type, c.email 
from Customers c
join Accounts a
on c.customer_id = a.customer_id;

select a.account_id, t.transaction_id, t.amount, t.transaction_type
from Transactions t
join Accounts a
on a.account_id = t.account_id;

update Accounts set amount = 1000 where account_id = 1;

select concat(first_name, ' ', last_name) as full_name from Customers;

delete from Accounts
where amount = 0 and account_type = 'Savings';

alter table Customers add address varchar(20);

update Customers set address = 'Delhi'
where customer_id in (1,2,3,4,5);

update Customers set address = 'Pune'
where customer_id in (6,7,8,9,10);

select * from Customers where address = 'Pune';

select customer_id, amount from Accounts where amount = 2300;

select customer_id, amount from Accounts where amount > 1000;

select * from Transactions;

select * from Transactions where account_id = 7;

select * from Accounts where amount < 3000;

select * from Customers where address != 'Pune';

-- assuming interest rate of 5%
select customer_id, amount, amount + (amount*0.05) as AfterInterest from Accounts;