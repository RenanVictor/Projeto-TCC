drop database bdtcc;
select * from empresa;

 -- CRIANDO O BDTCC
CREATE DATABASE BDTCC;

 -- USANDO O BDTCC
USE BDTCC;

/*SET FOREIGN_KEY_CHECKS=0;
alter table candidato drop foreign key FK_USUARIO;
alter table usuario drop primary key;
alter table usuario change column codusuario codusuario int not null primary key auto_increment;
alter table candidato add CONSTRAINT FK_USUARIO FOREIGN KEY (CODUSUARIO) REFERENCES USUARIO (CODUSUARIO);
SET FOREIGN_KEY_CHECKS=1;*/

-- TABELA USUARIO
CREATE TABLE USUARIO (
    CODUSUARIO INT NOT NULL PRIMARY KEY auto_increment,
    NOME VARCHAR(80) not null,
    TELEFONE VARCHAR(100) not null,
    EMAIL VARCHAR(100) NOT NULL,
    SENHA VARCHAR(20) not null,
	LOGIN VARCHAR(20)not null
)  ENGINE=INNODB;

-- TABELA CANDIDATO
CREATE TABLE CANDIDATO (
    CODCANDIDATO INT NOT NULL PRIMARY KEY auto_increment,
    NOME VARCHAR(80) NOT NULL,
    CPF VARCHAR(11),
    ENDERECO VARCHAR(80) NOT NULL,
    NUMERO VARCHAR(10) NOT NULL,
    BAIRRO VARCHAR(30) NOT NULL,
    CIDADE VARCHAR(30) NOT NULL,
    ESTADO VARCHAR(2) NOT NULL,
    DATA_NASCIMENTO DATE NOT NULL,
    EMAIL VARCHAR(30) NOT NULL,
    TEL_RESIDENCIAL VARCHAR(11),
    TEL_CELULAR VARCHAR(11),
    STATUSCURSANDO varchar(5),
	EstadoCivil varchar(50),
    CODUSUARIO INT,
    CONSTRAINT FK_USUARIO FOREIGN KEY (CODUSUARIO)
        REFERENCES USUARIO (CODUSUARIO)
)  ENGINE=INNODB;

-- TABELA FORMAÇÃO
CREATE TABLE FORMACAO (
    CODFORMACAO INT NOT NULL PRIMARY KEY auto_increment,
    TITULO VARCHAR(80) NOT NULL,
    ESCOLA VARCHAR(60) NOT NULL,
    INICIO DATE,
    TERMINO DATE,
    CODCANDIDATO INT,
    CONSTRAINT FK_CANDIDATO FOREIGN KEY (CODCANDIDATO)
        REFERENCES CANDIDATO (CODCANDIDATO)
)  ENGINE=INNODB;

-- TABELA CURSO
CREATE TABLE CURSO (
    CODCURSO INT NOT NULL PRIMARY KEY auto_increment,
    TITULO VARCHAR(50) NOT NULL,
    AREA VARCHAR(40) NOT NULL
)  ENGINE=INNODB;

-- TABELA CURSANDO
CREATE TABLE CURSANDO (
    CODCURSANDO INT NOT NULL PRIMARY KEY auto_increment,
    INGRESSO DATE,
    CONCLUSAO DATE,
    PERIODO VARCHAR(30),
    CODCURSO INT,
    CODCANDIDATO INT,
    CONSTRAINT FK_CURSO FOREIGN KEY (CODCURSO)
        REFERENCES CURSO (CODCURSO),
    CONSTRAINT FK_CANDIDATO1 FOREIGN KEY (CODCANDIDATO)
        REFERENCES CANDIDATO (CODCANDIDATO)
)  ENGINE=INNODB;

-- TABELA EXPERIENCIA
CREATE TABLE EXPERIENCIA (
    CODEXPERIENCIA INT NOT NULL PRIMARY KEY auto_increment,
    EMPRESA VARCHAR(80) NOT NULL,
    CARGO VARCHAR(40) NOT NULL,
    FUNCOES LONGTEXT,
    ENTRADA DATE,
    SAIDA DATE,
    CODCANDIDATO INT,
    CONSTRAINT FK_CANDIDATO2 FOREIGN KEY (CODCANDIDATO)
        REFERENCES CANDIDATO (CODCANDIDATO)
)  ENGINE=INNODB;

-- TABELA EMPRESA
CREATE TABLE EMPRESA (
    CODIGO INT NOT NULL PRIMARY KEY auto_increment,
    FANTASIA VARCHAR(80) NOT NULL,
    RAZAO VARCHAR(80) NOT NULL,
    EMPRESA VARCHAR(45),
    CODEXPERIENCIA INT,
    CONSTRAINT FK_EXPERIENCIA FOREIGN KEY (CODEXPERIENCIA)
        REFERENCES EXPERIENCIA (CODEXPERIENCIA)
)  ENGINE=INNODB;

-- TABELA CONTRATO
CREATE TABLE CONTRATO (
    NUMERO INT NOT NULL PRIMARY KEY auto_increment,
    MODALIDADE varchar(80),
    INICIO DATE,
    TERMINO DATE,
    SEGURO varchar(5),
    CODCANDIDATO INT,
    CODIGO INT,
    CONSTRAINT FK_CANDIDATO3 FOREIGN KEY (CODCANDIDATO)
        REFERENCES CANDIDATO (CODCANDIDATO),
    CONSTRAINT FK_EMPRESA FOREIGN KEY (CODIGO)
        REFERENCES EMPRESA (CODIGO)
)  ENGINE=INNODB;

insert into curso (titulo, area) values('Técnico em Informática','Informática');
insert into curso (titulo, area) values('Técnico Web','Informática');
insert into curso (titulo, area) values('Técnico Mecatrônica','Mecânica');
insert into curso (titulo, area) values('Técnico em Eletrônica','Eletrônica');
insert into curso (titulo, area) values('Técnico em Enfermagem','Saúde');
insert into curso (titulo, area) values('Técnico em Finanças','Econômica');
insert into curso (titulo, area) values('Técnico em Administração','Administrativa');

insert into empresa (FANTASIA, RAZAO) Values('Baldan','Industria');
insert into empresa (FANTASIA, RAZAO) Values('Antoniosi','Industria');
insert into empresa (FANTASIA, RAZAO) Values('Marchesan','Industria');
insert into empresa (FANTASIA, RAZAO) Values('ETEC','Escola');
insert into empresa (FANTASIA, RAZAO) Values('SENAI','Escola');
insert into empresa (FANTASIA, RAZAO) Values('CCAA','Escola');

Insert into CANDIDATO(Nome,endereco,cpf,numero,bairro,cidade,estado,DATA_NASCIMENTO,EMAIL,Tel_Residencial,Tel_Celular,Statuscursando,estadocivil) 
Values('Renan Victor','Rua João Pessoa','37854330803','166','Vila Pereira','Matão','SP','1991-11-25','Renan.victor.p@gmail.com','33849731','992531793','SIM','Solteiro');

insert into usuario(nome,telefone,email,senha,login) values ('Renan','33849731','Renan@','123','Renan');

DROP TABLE CONTRATO;

-- CHAMADOS TODOS OS CAMPOS DAS TABELAS:
SELECT * FROM USUARIO;
SELECT * FROM CANDIDATO;
SELECT * FROM EMPRESA order by fantasia;

SELECT * FROM FORMACAO;
SELECT * FROM CURSANDO;
SELECT * FROM CURSO;
SELECT * FROM CONTRATO;
SELECT * FROM EXPERIENCIA;

alter table formacao drop column curso;
alter table usuario add column empresa varchar(80);
ALTER TABLE usuario change column nome nome varchar(80);

select login,senha from usuario where login = 'Renans' or senha = 'renan';
