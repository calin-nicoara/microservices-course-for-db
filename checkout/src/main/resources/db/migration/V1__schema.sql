CREATE TABLE cart
(
    id bigint NOT NULL PRIMARY KEY,
    clientCode character varying (255)
)

CREATE TABLE cart_item
(
    id bigint NOT NULL PRIMARY KEY,
    productCode character varying (255)
    quantity integer,
    cart_id bigint
)

CREATE TABLE cart
(
    id bigint NOT NULL PRIMARY KEY,
    clientCode character varying (255)
)

CREATE TABLE cart
(
    id bigint NOT NULL PRIMARY KEY,
    clientCode character varying (255)
)
