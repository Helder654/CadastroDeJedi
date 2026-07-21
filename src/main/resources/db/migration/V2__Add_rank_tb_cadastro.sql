-- V2: migration para adicionar a coluna de rank na tabela cadastro

ALTER TABLE tb_cadastro
ADD COLUMN IF NOT EXISTS rank VARCHAR(255);