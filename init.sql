
CREATE TABLE IF NOT EXISTS usuarios (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    tipo_usuario ENUM('ALUNO', 'PROFESSOR', 'ADMIN') NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS disciplinas (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           codigo VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    carga_horaria VARCHAR(20) NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS alunos (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      usuario_id INT NOT NULL,
                                      matricula VARCHAR(20) NOT NULL UNIQUE,
    curso VARCHAR(100) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS professores (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           usuario_id INT NOT NULL,
                                           disciplina_id INT,
                                           FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id) ON DELETE SET NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS turmas (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nome VARCHAR(100) NOT NULL,
    periodo VARCHAR(50) NOT NULL,
    disciplina_id INT NOT NULL,
    professor_id INT,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id) ON DELETE CASCADE,
    FOREIGN KEY (professor_id) REFERENCES professores(id) ON DELETE SET NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS alunos_turmas (
                                             aluno_id INT NOT NULL,
                                             turma_id INT NOT NULL,
                                             PRIMARY KEY (aluno_id, turma_id),
    FOREIGN KEY (aluno_id) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (turma_id) REFERENCES turmas(id) ON DELETE CASCADE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS faltas (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      aluno_id INT NOT NULL,
                                      disciplina_id INT NOT NULL,
                                      quantidade INT NOT NULL,
                                      data_falta DATE NOT NULL,
                                      FOREIGN KEY (aluno_id) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id) ON DELETE CASCADE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS notas (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     aluno_id INT NOT NULL,
                                     disciplina_id INT NOT NULL,
                                     valor DECIMAL(5,2) NOT NULL,
    data_nota DATE NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id) ON DELETE CASCADE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB;


INSERT IGNORE INTO usuarios (nome, email, tipo_usuario, senha)
VALUES ('Administrador Master', 'admin@master.com', 'ADMIN', '$2a$10$N9qo8uLOickgx2ZMRZoMy.MrYI5ozY2Qb9.e2dD6b1vq9FH7nzQ1K');