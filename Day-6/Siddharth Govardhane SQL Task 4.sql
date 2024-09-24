use HMBank;

select * from customers;
select * from accounts;
select * from transactions;

-- Retrieve the customer(s) with the highest account balance.
select concat(first_name, ' ', last_name) as name from customers
where customer_id = (
select customer_id from accounts order by amount desc
limit 1
);

-- Calculate the average account balance for customers who have more than one account
select avg(amount) from accounts
where customer_id in (
select customer_id from accounts
group by customer_id having count(account_id) > 1
);

--  Retrieve accounts with transactions whose amounts exceed the average transaction amount.
select account_id from transactions
where amount > (
select avg(amount) from transactions
);

-- Identify customers who have no recorded transactions.
select first_name, last_name from Customers
where customer_id not in (
select customer_id from Accounts 
where account_id in (
select account_id from Transactions)
);

-- Calculate the total balance of accounts with no recorded transactions.
select sum(amount) from Accounts
where account_id not in (
select account_id from Transactions
);

-- Retrieve transactions for accounts with the lowest balance.
select * from Transactions
where account_id = (
select account_id from Accounts order by amount
limit 1
);

-- Identify customers who have accounts of multiple types.
select customer_id from Accounts
group by customer_id
having count(distinct account_type) > 1;

-- Calculate the percentage of each account type out of the total number of accounts.
select account_type, (count(*) * 100.0 / (select count(*) from Accounts)) as percentage
from Accounts
group by account_type;

-- Retrieve all transactions for a customer with a given customer_id.
select * from Transactions
where account_id in (
select account_id from Accounts 
where customer_id = 2
);

-- Calculate the total balance for each account type, including a subquery within the SELECT clause.
select account_type, 
(select sum(amount) from Accounts a2 where a2.account_type = a1.account_type) as total_balance
from Accounts a1
group by account_type;
