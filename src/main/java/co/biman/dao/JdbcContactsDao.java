package co.biman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.biman.entrity.Contact;
import co.biman.util.DbUtil;

public class JdbcContactsDao implements ContactsDao {

	@Override
	public Contact addContact(Contact contact) throws DaoException {
		String sql = "insert into contacts (name gender email phone city country) values (?,?,?,?,?,?)";
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
				){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getGender());
			stmt.setString(3, contact.getEmail());
			stmt.setString(4, contact.getPhone());
			stmt.setString(5, contact.getCity());
			stmt.setString(6, contact.getCountry());
			
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			contact.setId(keys.getInt(1));
			
			return contact;
			
			
		}catch(Exception ex){
			throw new DaoException(ex);
			
		}
	

	}

	@Override
	public Contact finfById(Integer id) throws DaoException {
		String sql = "select * from contacts where id = ?";
		try(Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getNString("city"));
				c.setCountry(rs.getString("country"));
				rs.close();
				return c;
			}
			rs.close();
		}catch(Exception ex){
			throw new DaoException(ex);
		}
		
		return null;
	}

	@Override
	public Contact updateContact(Contact contact) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact deleteContact(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findAll() throws DaoException {
    String sql = "select * from contact";
    List<Contact> list = new ArrayList<>();
	try(
		Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			){
		
		while(rs.next()){
			Contact c = new Contact();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setGender(rs.getString("gender"));
			c.setEmail(rs.getString("email"));
			c.setPhone(rs.getString("phone"));
			c.setCity(rs.getNString("city"));
			c.setCountry(rs.getString("country"));
			rs.close();
			
			
		}
		
		
	}catch(Exception ex){
		throw new DaoException(ex);
	}
		return list;
	}

	@Override
	public List<Contact> findByCity(Contact city) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
