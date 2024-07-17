CREATE TABLE IF NOT EXISTS dbtechchallange.order (
    `id` VARCHAR(255) NOT NULL,
    `number_order` INT NOT NULL,
    `description` VARCHAR(100) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `amount` DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.item (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `order_id` VARCHAR(255) NOT NULL,
    `sku` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`),
    FOREIGN KEY (`sku`) REFERENCES `product`(`sku`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.product (
    `sku` VARCHAR(255) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `category` VARCHAR(100) NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`sku`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.payment (
    `id` VARCHAR(255) NOT NULL,
    `order_id` VARCHAR(255) NOT NULL,
    `value` DECIMAL(10, 2) NOT NULL,
    `method` VARCHAR(100) NOT NULL,
    `datetime` VARCHAR(100) NOT NULL,
    `gateway_payment` VARCHAR(100) NOT NULL,
    `status` VARCHAR(100) NOT NULL,ReadingCodePayment,
    `reading_code` VARCHAR(500) NOT NULL,
    `processing_code` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`)
);

CREATE TABLE IF NOT EXISTS dbtechchallange.client (
    `cpf` VARCHAR(20) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`cpf`)
);
