package com.ads.projetoa3.app.repositories;

import com.ads.projetoa3.app.database.db;
import com.ads.projetoa3.app.enums.EnumTipoUsuario;
import com.ads.projetoa3.app.models.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    protected static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void saveAluno(Aluno aluno, String senha) {
        String sqlUsuario = "INSERT INTO usuarios (nome, email, tipo_usuario, senha) VALUES (?, ?, ?, ?)";
        String sqlAluno = "INSERT INTO alunos (usuario_id, matricula, curso) VALUES (?, ?, ?)";

        Connection conexao = null;
        PreparedStatement stmtUsuario = null;
        PreparedStatement stmtAluno = null;
        ResultSet generatedKeys = null;

        try {
            conexao = db.getConnection();
            conexao.setAutoCommit(false);

            stmtUsuario = conexao.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, aluno.getNome());
            stmtUsuario.setString(2, aluno.getEmail());
            stmtUsuario.setString(3, "ALUNO");
            stmtUsuario.setString(4, senha);

            int affectedRows = stmtUsuario.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao criar usuário, nenhuma linha afetada.");
            }

            generatedKeys = stmtUsuario.getGeneratedKeys();
            int usuarioId;

            if (generatedKeys.next()) {
                usuarioId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao obter ID do usuário criado.");
            }

            stmtAluno = conexao.prepareStatement(sqlAluno);
            stmtAluno.setInt(1, usuarioId);
            stmtAluno.setString(2, aluno.getMatricula());
            stmtAluno.setString(3, aluno.getCurso());

            stmtAluno.executeUpdate();

            conexao.commit();


        } catch (SQLException e) {

            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new RuntimeException("Erro ao salvar aluno: " + e.getMessage(), e);
        } finally {

            try {
                if (generatedKeys != null) generatedKeys.close();
                if (stmtUsuario != null) stmtUsuario.close();
                if (stmtAluno != null) stmtAluno.close();
                if (conexao != null) {
                    conexao.setAutoCommit(true);
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Aluno> getAlunos() {
        String sql = "SELECT u.nome, u.email, a.matricula, a.curso " +
                "FROM usuarios u " +
                "JOIN alunos a ON u.id = a.usuario_id " +
                "WHERE u.tipo_usuario = 'ALUNO'";

        List<Aluno> alunos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = db.getConnection();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setCurso(rs.getString("curso"));

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar alunos: " + e.getMessage(), e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return alunos;
    }
}
