-- Endereços
INSERT INTO address (postal_code, region_code, administrative_area, locality, sublocality, address_line)
VALUES ('90000-000', 'RS', 'Rio Grande do Sul', 'Porto Alegre', 'Centro Histórico', 'Rua da Esperança, 123'),
       ('90010-000', 'RS', 'Rio Grande do Sul', 'Porto Alegre', 'Menino Deus', 'Av. das Águas, 456'),
       ('88000-000', 'SC', 'Santa Catarina', 'Florianópolis', 'Trindade', 'Rua do Sol, 789'),
       ('11000-000', 'SP', 'São Paulo', 'Santos', 'Gonzaga', 'Rua Oceânica, 321'),
       ('70000-000', 'DF', 'Distrito Federal', 'Brasília', 'Asa Norte', 'SQN 204 Bloco D');

-- Eventos
INSERT INTO event (name, description, date, address_id)
VALUES ('Enchente Porto Alegre', 'Cheia histórica do Rio Guaíba.', '2025-05-15', 1),
       ('Tempestade Florianópolis', 'Ventos acima de 100 km/h e alagamentos em bairros centrais.', '2025-04-20', 3),
       ('Deslizamento em Santos', 'Morro desabou após chuvas intensas.', '2025-03-30', 4),
       ('Incêndio no Cerrado', 'Incêndio florestal atingindo zona rural de Brasília.', '2025-05-10', 5),
       ('Granizo em Porto Alegre', 'Granizo destrutivo em bairros do sul da cidade.', '2025-05-25', 2);

-- Usuários
INSERT INTO app_user (name, cpf, phone)
VALUES ('Ana Silva', '123.456.789-00', '(51) 91234-5678'),
       ('Carlos Souza', '987.654.321-00', '(48) 99876-5432'),
       ('Mariana Lopes', '321.654.987-00', '(51) 99999-1111'),
       ('Fernando Lima', '456.123.789-00', '(11) 98888-0000'),
       ('Jéssica Ramos', '654.789.123-00', '(61) 93333-4444'),
       ('Lucas Ferreira', '111.222.333-44', '(48) 94444-2222'),
       ('Patrícia Nunes', '222.333.444-55', '(51) 95555-6666');

-- Profissionais
INSERT INTO professional (name, phone, specialty)
VALUES ('Dra. Marina Costa', '(51) 98888-1122', 'Psicologia Clínica'),
       ('Dr. Felipe Duarte', '(48) 97777-3344', 'Traumas e Desastres'),
       ('Dra. Roberta Vasconcelos', '(11) 96666-7777', 'Psicologia Comunitária'),
       ('Dr. André Moura', '(61) 98888-9999', 'Psicoterapia Breve'),
       ('Dra. Lúcia Fernandes', '(51) 91111-2222', 'Primeiros Socorros Psicológicos');

-- Sessões
INSERT INTO session (datetime, status, method, link_web, link_phone, user_id, professional_id, event_id)
VALUES ('2025-06-01 14:30:00', 'agendada', 'videochamada', 'https://acolhe.org.br/sessao/abc123', 'tel:+5551988881122',
        1, 1, 1),
-- Updates

UPDATE session
SET status = 'concluída'
WHERE session_id = 2;

UPDATE professional
SET phone = '(48) 98888-0001'
WHERE professional_id = 2;

UPDATE app_user
SET name = 'Carlos de Souza'
WHERE user_id = 2;

UPDATE event
SET description = 'Cheia histórica do Rio Guaíba em Porto Alegre (POA).'
WHERE event_id = 1;