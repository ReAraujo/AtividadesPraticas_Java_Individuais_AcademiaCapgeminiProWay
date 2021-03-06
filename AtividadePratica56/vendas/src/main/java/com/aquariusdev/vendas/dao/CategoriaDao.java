package com.aquariusdev.vendas.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aquariusdev.vendas.models.Categoria;

public class CategoriaDao {
    // CRUD
    // CREATE:
    public int insert(Categoria model) {  
        int idGerado = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "INSERT INTO Categoria (nome, descricao) values (?, ?)";
        
            PreparedStatement prepStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, model.getNome());  
            prepStatement.setString(2, model.getDescricao());  

            prepStatement.execute();
            ResultSet retornoIDs = prepStatement.getGeneratedKeys();
        
            while (retornoIDs.next()) { 
                idGerado = retornoIDs.getInt("id");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return idGerado;
    }
    // READ:
    public ArrayList<Categoria> read() {
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try(Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM Categoria";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.execute();

            ResultSet result = prepStatement.getResultSet();

            while (result.next()) { 
                Categoria model = new Categoria();
                model.setId(result.getInt("id"));
                model.setNome(result.getString("nome"));
                model.setDescricao(result.getString("descricao"));
                lista.add(model);       
            }  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    // UPDATE: 
    public int update(Categoria model) {
        int linhasAfetadas = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "UPDATE Categoria SET nome = ? where id = ?"; 

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, model.getNome());
            prepStatement.setInt(2, model.getId());
            prepStatement.execute();
            
            linhasAfetadas = prepStatement.getUpdateCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
    // DELETE: 
    public int delete(Categoria model) {            
        int linhasAfetadas = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "DELETE FROM Categoria WHERE id = ? ";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setInt(1, model.getId());
            prepStatement.execute();
                   
            linhasAfetadas = prepStatement.getUpdateCount();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}    




