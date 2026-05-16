CREATE DATABASE IF NOT EXISTS arena_pernambuco
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE arena_pernambuco;

CREATE TABLE IF NOT EXISTS users (
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255),
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255),
    role       ENUM('citizen','empresa','gestor','admin'),
    created_at DATETIME     DEFAULT NOW(),
    updated_at DATETIME     DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS categories (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS sectors (
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL UNIQUE,
    capacity INT         NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS evento (
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255),
    date        DATETIME,
    image_url   VARCHAR(1000),
    full_price  DOUBLE,
    half_price  DOUBLE,
    description VARCHAR(1000),
    status      ENUM('PENDENTE','APROVADO','CANCELADO') NOT NULL DEFAULT 'PENDENTE',
    category_id BIGINT,
    sector_id   BIGINT,
    empresa_id  BIGINT,
    created_by  BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_evento_category FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_evento_sector   FOREIGN KEY (sector_id)   REFERENCES sectors(id)    ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_evento_empresa  FOREIGN KEY (empresa_id)  REFERENCES users(id)      ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_evento_creator  FOREIGN KEY (created_by)  REFERENCES users(id)      ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS ingresso (
    id         BIGINT     NOT NULL AUTO_INCREMENT,
    setor      VARCHAR(255),
    assento    VARCHAR(255),
    preco      DOUBLE,
    disponivel TINYINT(1) NOT NULL DEFAULT 1,
    evento_id  BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_ingresso_evento FOREIGN KEY (evento_id) REFERENCES evento(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS tickets (
    id               BIGINT         NOT NULL AUTO_INCREMENT,
    user_id          BIGINT         NOT NULL,
    event_id         BIGINT         NOT NULL,
    quantity_full    INT                     DEFAULT 0,
    quantity_half    INT                     DEFAULT 0,
    total_price      DECIMAL(10, 2) NOT NULL,
    reservation_code VARCHAR(50)    NOT NULL UNIQUE,
    created_at       DATETIME,
    PRIMARY KEY (id),
    CONSTRAINT fk_ticket_user  FOREIGN KEY (user_id)  REFERENCES users(id)  ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_ticket_event FOREIGN KEY (event_id) REFERENCES evento(id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS compra (
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    nome          VARCHAR(255),
    email         VARCHAR(255),
    cpf           VARCHAR(20),
    telefone      VARCHAR(20),
    numero_cartao VARCHAR(20),
    nome_cartao   VARCHAR(255),
    validade      VARCHAR(10),
    cvv           VARCHAR(5),
    evento_id     BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_compra_evento FOREIGN KEY (evento_id) REFERENCES evento(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT IGNORE INTO categories (id, name, description) VALUES
(2,  'Teatro',      'Pecas teatrais e apresentacoes culturais'),
(19, 'Musica',      'Shows e festivais musicais'),
(20, 'Festival',    'Eventos de grande porte com multiplas atracoes'),
(21, 'Esporte',     'Competicoes e eventos esportivos'),
(22, 'Comedia',     'Shows de stand-up e humor'),
(23, 'Exposicao',   'Exposicoes de arte e cultura'),
(24, 'Tecnologia',  'Conferencias e feiras de tecnologia');

INSERT IGNORE INTO sectors (id, name, capacity) VALUES
(1, 'Pista',         5000),
(2, 'Arquibancada',  3000),
(3, 'Camarote',       500),
(4, 'Area Externa',  2000);

INSERT IGNORE INTO users (id, name, email, password, role, created_at, updated_at) VALUES
(1, 'Gestor Arena', 'gestor@arena.com',
 '$2a$10$7QJ9QJ9QJ9QJ9QJ9QJ9QJOeK1vQ5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z2',
 'gestor', NOW(), NOW()),
(2, 'Empresa Demo', 'empresa@arena.com',
 '$2a$10$7QJ9QJ9QJ9QJ9QJ9QJ9QJOeK1vQ5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z2',
 'empresa', NOW(), NOW()),
(3, 'Cliente Demo', 'cliente@arena.com',
 '$2a$10$7QJ9QJ9QJ9QJ9QJ9QJOeK1vQ5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z2',
 'citizen', NOW(), NOW());

INSERT IGNORE INTO evento
    (id, title, description, date, category_id, sector_id, image_url, full_price, half_price, status, empresa_id, created_by)
VALUES
(1,  'Show de Sabrina Carpenter',
     'Grande show com a maior popstar do mundo em Pernambuco',
     '2026-05-15 20:00:00', 19, 1,
     'https://rollingstone.com.br/wp-content/uploads/2024/10/formato-foto-do-site-rolling-14.jpg',
     150.00, 75.00, 'APROVADO', 2, 1),

(2,  'Festival de Verao',
     'Festival com multiplos artistas e muita musica',
     '2026-06-10 18:00:00', 20, 1,
     'https://culture.com.br/wp-content/uploads/2018/10/38136066_1942137959143005_7139338499064332288_n.jpg',
     120.00, 60.00, 'APROVADO', 2, 1),

(3,  'Campeonato de Futsal',
     'Competicao estadual de futsal masculino',
     '2026-05-20 19:00:00', 21, 2,
     'https://img.lance.com.br/cdn-cgi/image/width=950,quality=75,fit=pad,format=webp/uploads/2025/03/Captura-de-tela-2025-03-30-204127-aspect-ratio-512-320.png',
     50.00, 25.00, 'APROVADO', 2, 1),

(4,  'Stand-up de Rodrigo Marques',
     'Noite de comedia com Rodrigo Marques',
     '2026-07-01 20:00:00', 22, 2,
     'https://soubh.uai.com.br/wp-content/uploads/2024/12/Rodrigo-Marques.jpg',
     80.00, 40.00, 'APROVADO', 2, 1),

(5,  'Exposicao de Arte Pernambucana',
     'Mostra de artistas locais de Pernambuco',
     '2026-05-25 10:00:00', 23, 3,
     'https://www.cultura.pe.gov.br/wp-content/uploads/2015/01/4768147970_4151b21681_b.jpg',
     30.00, 15.00, 'APROVADO', 2, 1),

(6,  'ExpoTech Brasil',
     'Conferencia de tecnologia e inovacao',
     '2026-06-15 09:00:00', 24, 3,
     'https://i0.wp.com/blog.portaleducacao.com.br/wp-content/uploads/2022/02/365-O-que-e-tecnologia_.jpg',
     200.00, 100.00, 'APROVADO', 2, 1),

(7,  'Romeu e Julieta - Teatro Classico',
     'Adaptacao classica de Shakespeare com elenco renomado',
     '2026-06-20 19:30:00', 2, 2,
     'https://static.wixstatic.com/media/20653c_05d5976ca27042a2b5dc3091f285040f~mv2.jpeg/v1/fill/w_1000_h_562_al_c_q_85_usm_0_66_1_00_0_01/20653c_05d5976ca27042a2b5dc3091f285040f~mv2.jpeg',
     90.00, 45.00, 'APROVADO', 2, 1),

(8,  'Show de Encerramento Verao 2026',
     'Grande show encerrando a temporada de verao',
     '2026-07-15 21:00:00', 19, 1,
     'https://billboard-com-br.s3.amazonaws.com/wp-content/uploads/2025/06/25090926/Joao-Gomes-se-apresenta-no-Sao-Joao-de-CaruaruLeo-Franco-_AgNews.jpg',
     180.00, 90.00, 'PENDENTE', 2, 1),

(9,  'Festival Gastronomico',
     'Festival com comida, musica e diversao',
     '2026-07-20 12:00:00', 20, 1,
     'https://www.pe.senac.br/wp-content/uploads/2019/08/IMG_20190821_115845289.jpg',
     100.00, 50.00, 'PENDENTE', 2, 1),

(10, 'Maratona de Pernambuco',
     'Grande competicao de corrida na capital',
     '2026-08-05 07:00:00', 21, 4,
     'https://cdn.folhape.com.br/img/pc/1100/1/dn_arquivo/2025/08/whatsapp-image-2025-08-24-at-091700.jpeg',
     60.00, 30.00, 'PENDENTE', 2, 1);
