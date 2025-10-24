insert into tb_order (moment, order_status, client_Id, payment_Id) values 
	('2019-06-20 19:53:07', 2, 1, 1),
	('2019-07-21 03:42:10', 1, 2, null),
	('2019-07-22 15:21:22', 1, 1, null);

insert into tb_order_item (order_id, product_id, quantity, price) values 
	(1, 1, 2, 90.5),
	(1, 3, 1, 1250.0),
	(2, 3, 2, 1250.0),
	(3, 5, 2, 100.99);
