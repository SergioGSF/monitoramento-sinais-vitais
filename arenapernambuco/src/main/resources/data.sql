-- =============================================
-- POPULAÇÃO AUTOMÁTICA DO BANCO arena_pernambuco
-- Este arquivo é executado pelo Spring Boot ao iniciar
-- =============================================

-- 1. INSERIR CATEGORIAS (se não existirem)
INSERT IGNORE INTO categories (id, name, description) VALUES
(2, 'Teatro', 'Peças teatrais e apresentações culturais'),
(19, 'Música', 'Shows e festivais musicais'),
(20, 'Festival', 'Eventos de grande porte com múltiplas atrações'),
(21, 'Esporte', 'Competições e eventos esportivos'),
(22, 'Comédia', 'Shows de stand-up e humor'),
(23, 'Exposição', 'Exposições de arte e cultura'),
(24, 'Tecnologia', 'Conferências e feiras de tecnologia');

-- 2. INSERIR SETORES (se não existirem)
INSERT IGNORE INTO sectors (id, name, capacity) VALUES
(1, 'Pista', 5000),
(2, 'Arquibancada', 3000),
(3, 'Camarote', 500),
(4, 'Área Externa', 2000);

-- 3. INSERIR USUÁRIO ADMIN (se não existir)
-- Senha: "admin123" codificada em BCrypt
INSERT IGNORE INTO users (id, name, email, password, role, created_at, updated_at) VALUES
(1, 'Admin Sistema', 'admin@arena.com', '$2a$10$NkM7pG.EGqH9tX9W9Y9Y9u9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y9Y', 'admin', NOW(), NOW());

-- 4. INSERIR EVENTOS (se não existirem)
INSERT IGNORE INTO events (id, title, description, date, category_id, sector_id, image_url, full_price, half_price, status, created_by) VALUES
(1, 'Show de Sabrina Carpenter', 'Grande show com a maior popstar do mundo em Pernambuco', '2026-05-15 20:00:00', 19, 1, 'https://rollingstone.com.br/wp-content/uploads/2024/10/formato-foto-do-site-rolling-14.jpg', 150.00, 75.00, 'active', 1),
(2, 'Festival de Verão', 'Festival com múltiplos artistas e muita música', '2026-06-10 18:00:00', 20, 1, 'https://culture.com.br/wp-content/uploads/2018/10/38136066_1942137959143005_7139338499064332288_n.jpg', 120.00, 60.00, 'active', 1),
(3, 'Campeonato de Futsal', 'Competição estadual de futsal masculino', '2026-05-20 19:00:00', 21, 2, 'https://img.lance.com.br/cdn-cgi/image/width=950,quality=75,fit=pad,format=webp/uploads/2025/03/Captura-de-tela-2025-03-30-204127-aspect-ratio-512-320.png', 50.00, 25.00, 'active', 1),
(4, 'Stand-up de Rodrigo Marques', 'Noite de comédia com Rodrigo Marques', '2026-07-01 20:00:00', 22, 2, 'https://soubh.uai.com.br/wp-content/uploads/2024/12/Rodrigo-Marques.jpg', 80.00, 40.00, 'active', 1),
(5, 'Exposição de Arte Pernambucana', 'Mostra de artistas locais de Pernambuco', '2026-05-25 10:00:00', 23, 3, 'https://www.cultura.pe.gov.br/wp-content/uploads/2015/01/4768147970_4151b21681_b.jpg', 30.00, 15.00, 'active', 1),
(6, 'ExpoTech Brasil', 'Conferência de tecnologia e inovação', '2026-06-15 09:00:00', 24, 3, 'https://i0.wp.com/blog.portaleducacao.com.br/wp-content/uploads/2022/02/365-O-que-e-tecnologia_.jpg', 200.00, 100.00, 'active', 1),
(7, 'Romeu e Julieta - Teatro Clássico', 'Adaptação clássica de Shakespeare com elenco renomado', '2026-06-20 19:30:00', 2, 2, 'https://static.wixstatic.com/media/20653c_05d5976ca27042a2b5dc3091f285040f~mv2.jpeg/v1/fill/w_1000_h_562_al_c_q_85_usm_0_66_1_00_0_01/20653c_05d5976ca27042a2b5dc3091f285040f~mv2.jpeg', 90.00, 45.00, 'active', 1),
(8, 'Show de Encerramento Verão 2026', 'Grande show encerrando a temporada de verão', '2026-07-15 21:00:00', 19, 1, 'https://billboard-com-br.s3.amazonaws.com/wp-content/uploads/2025/06/25090926/Joao-Gomes-se-apresenta-no-Sao-Joao-de-CaruaruLeo-Franco-_AgNews.jpg', 180.00, 90.00, 'active', 1),
(9, 'Festival Gastronômico', 'Festival com comida, música e diversão', '2026-07-20 12:00:00', 20, 1, 'https://www.pe.senac.br/wp-content/uploads/2019/08/IMG_20190821_115845289.jpg', 100.00, 50.00, 'active', 1),
(10, 'Maratona de Pernambuco', 'Grande competição de corrida na capital', '2026-08-05 07:00:00', 21, 4, 'https://cdn.folhape.com.br/img/pc/1100/1/dn_arquivo/2025/08/whatsapp-image-2025-08-24-at-091700.jpeg', 60.00, 30.00, 'active', 1);