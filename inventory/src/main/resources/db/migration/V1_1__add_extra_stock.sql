ALTER TABLE product_inventory ADD COLUMN extra_stock integer;

UPDATE product_inventory set extra_stock = stock;
