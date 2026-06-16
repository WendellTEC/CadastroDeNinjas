-- Migration for add RANK at register table

ALTER TABLE tb_register
ADD COLUMN rank VARCHAR(255);