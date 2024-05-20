package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.PropietarioRepository;
import trabajoInmobiliaria.DatabaseConnection;
import trabajoInmobiliaria.Propietario;

public class PropietarioControlador implements PropietarioRepository {

	
	 private final Connection connection;

	    public PropietarioControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }
	    
	    
	    @Override
	    public List<Propietario>  getAllPropietario() {
	        List<Propietario> propietarios = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente ");
	            ResultSet resultSet = statement.executeQuery();
	       
	           while (resultSet.next()) {
	        
	       
	        
	            	Propietario propietario = new Propietario(resultSet.getString("nombre"), resultSet.getInt("id_cliente"), resultSet.getString("apellido"), resultSet.getString("correo"), resultSet.getInt("telefono"), resultSet.getDate("fecha_nac").toLocalDate(), resultSet.getInt("dni"), resultSet.getInt("id_propietario"));
	               propietarios.add(propietario);
	            }
	       } catch (SQLException e) {
	            e.printStackTrace();
	      }
	   
	        return propietarios;
	    }

	    @Override
	    public Propietario getPropietarioById(int id) {
	        Propietario propietario = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	            	
	                propietario = new Propietario(resultSet.getString("nombre"), resultSet.getInt("id_cliente"), resultSet.getString("apellido"), resultSet.getString("correo"), resultSet.getInt("telefono"), resultSet.getDate("fecha_nac").toLocalDate(), resultSet.getInt("dni"), resultSet.getInt("id_propietario")); 
	            
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return propietario;
	    }

		@Override
	    public void addPropietario(Propietario propietario) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (nombre, id_cliente, apellido, correo, telefono, fecha_nac, dni, id_propietario) VALUES (?, null, ?, ?, ?, ?, ?, ?)");
	            statement.setString(1, propietario.getNombre());
	            statement.setInt(2, propietario.getId_cliente());
	            statement.setString(3, propietario.getApellido());
	            statement.setString(4, propietario.getCorreo());
	            statement.setInt(5, propietario.getTelefono());
	            
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Usuario insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
	    public void updatePropietario(Propietario propietario) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, apellido = ? WHERE id = ?");
	          statement.setString(1, propietario.getNombre());
	            statement.setString(2, propietario.getApellido());
	            statement.setInt(3, propietario.getId_cliente());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Usuario actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deletePropietario(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Usuario eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
	
}
	
	
	
	
	
	
	
	
	
	
}
