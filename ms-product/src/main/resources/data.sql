INSERT INTO tb_category (name) VALUES
	('Electronics'),
	('Books'),
	('Computers');

insert into tb_product (name, description, price, img_url) values 
	('The Lord of the Rings', 'Lorem ipsum dolor sit amet, consectetur.', 90.5, ''),
	('Smart TV', 'Nulla eu imperdiet purus. Maecenas ante.', 2190.0, ''),
	('Macbook Pro', 'Nam eleifend maximus tortor, at mollis.', 1250.0, ''),
	('PC Gamer', 'Donec aliquet odio ac rhoncus cursus.', 1200.0, ''),
	('Rails for Dummies', 'Cras fringilla convallis sem vel faucibus.', 100.99, '');
	
insert into tb_product_category (product_id, category_id) values
	(1, 2),
	(2, 1),
	(2, 3),
	(3, 3),
	(4, 3),
	(5, 2);
