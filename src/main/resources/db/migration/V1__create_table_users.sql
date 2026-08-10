CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       cpf VARCHAR(14) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       especialidade VARCHAR(100) NOT NULL,

                       logradouro VARCHAR(255) NOT NULL,
                       bairro VARCHAR(255) NOT NULL,
                       cep VARCHAR(9) NOT NULL,
                       numero VARCHAR(20),
                       complemento VARCHAR(255),
                       cidade VARCHAR(255) NOT NULL,
                       uf VARCHAR(2) NOT NULL
);