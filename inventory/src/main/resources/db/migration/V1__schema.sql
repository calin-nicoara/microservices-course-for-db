CREATE TABLE product_inventory
(
    id bigint NOT NULL PRIMARY KEY,
    product_code character varying (255),
    price decimal(10, 2),
    stock integer
);
