CREATE TABLE IF NOT EXISTS dbtechchallange.order (
    `id` VARCHAR(255) NOT NULL,
    `number_order` INT NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.item (
    `order_id` VARCHAR(255) NOT NULL,
    `sku` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.payment (
    `id` VARCHAR(255) NOT NULL,
    `order_id` VARCHAR(255) NOT NULL,
    `value` DECIMAL(10, 2) NOT NULL,
    `method` VARCHAR(100) NOT NULL,
    `date_payment` VARCHAR(100) NOT NULL,
    `gateway_payment` VARCHAR(100) NOT NULL,
    `status` VARCHAR(100) NOT NULL,
    `reading_code` VARCHAR(500) NOT NULL,
    `processing_code` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.product (
    `sku` VARCHAR(100) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `category` VARCHAR(100) NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`sku`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.client (
    `cpf` VARCHAR(20) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`cpf`)
);

insert into dbtechchallange.product(sku, name, description, price, category) values('123456A', 'MC Lanche Feliz',       'Hamburguer com queijo, salada especial e queijo', 35.00, 'Lanche');
insert into dbtechchallange.product(sku, name, description, price, category) values('123456C', 'Coca-Cola 500ML', 'Refrigerante Coca-Cola servido no copo de 500ML', 15.00, 'Bebida');
insert into dbtechchallange.product(sku, name, description, price, category) values('123456D', 'Coca-Cola 300ML', 'Refrigerante Coca-Cola servido no copo de 300ML', 10.00, 'Bebida');
insert into dbtechchallange.product(sku, name, description, price, category) values('123456E', 'Torta de Maça', 'Torta de Maça Caramelizada em uma casquinha crocante', 25.00, 'Sobremesa');
insert into dbtechchallange.product(sku, name, description, price, category) values('123456F', 'Sorvete de Casquinha', 'Sorvete de Casquinha com creme de nata e chocolate', 8.00, 'Sobremesa');
insert into dbtechchallange.product(sku, name, description, price, category) values('123456B', 'Quarteirão Com Queijo', 'Hamburguer com queijo e salada', 28.00, 'Lanche');
