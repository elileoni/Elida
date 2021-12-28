package services;

import java.sql.SQLException;
import java.util.List;

import model.Producto;
import model.Usuario;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class HistorialService {
	
	public List<Producto> list(Usuario user) throws SQLException {
		UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
		AtraccionDAOImpl atrDAO = new AtraccionDAOImpl();
		return userDAO.filtrarProductos(user);
	
	}

	}
