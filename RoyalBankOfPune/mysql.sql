select * from USER_DETAILS;
select * from ACCOUNTS_MASTER;
select * from  CUSTOMER_DETAILS;
select * from  SERVICE_TRACKER;
select * from TRANSACTION_DETAILS;
select * from FUND_TRANSFER;
CREATE SEQUENCE SERVICE_SEQ;
select * from payee;
INSERT INTO PAYEE VALUES(20170011,20170012,'ritu');
INSERT INTO PAYEE VALUES(20170001,20170002,'pratima');

delete from TRANSACTION_DETAILS where transaction_id=2;

