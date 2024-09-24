use HMBank;

show tables;

select * from accounts;
select * from customers;
select * from transactions;

select avg(amount) as AvgAmount from accounts;

select customer_id, amount from accounts order by amount desc limit 10;

update transactions set transaction_date = '2024-03-01' where transaction_id = 5;

select sum(amount) from transactions
where transaction_type = 'Deposit' and transaction_date = '2024-03-01';

-- to find oldest and newest customers we don't have a registration date column in any  table
-- hence I'll use DOB

select max(dob) as newest_customer, min(dob) as oldest_customer from customers;

select a.customer_id, a.account_type, t.transaction_type, t.transaction_date, t.amount
from accounts a
join transactions t
on a.account_id = t.account_id;

select concat(c.first_name, ' ', c.last_name) as name, a.account_id, a.account_type, a.amount
from customers c
join accounts a
on c.customer_id = a.customer_id;

select concat(c.first_name, ' ', c.last_name) as name, c.phone_no, c.address,
a.account_type, t.transaction_type, t.amount, t.transaction_date
from customers c
join accounts a
on c.customer_id = a.customer_id
join transactions t
on a.account_id = t.account_id
where a.account_id = 1;

select customer_id, count(account_id) from accounts 
group by customer_id
having count(account_id) > 1;

select t.account_id, a.account_type, a.amount, count(t.transaction_id) as transaction_count 
from transactions t
join accounts a
on a.account_id = t.account_id
group by account_id
order by transaction_count desc;

select transaction_date, amount, account_id, count(*) as duplicate_count
from transactions
group by amount, transaction_date, account_id
having duplicate_count > 1;

select account_type, sum(amount) as total_balance
from accounts
group by account_type;

select account_id, avg(amount) as avgDailyBalance
from transactions where account_id = 1
and transaction_date between '2024-01-10' and '2024-01-11';
