package co.biman.dao;

import java.util.List;

import co.biman.entrity.Contact;

public interface ContactsDao {
	
	//Crud Operations 
	
	public Contact addContact(Contact contact) throws DaoException;
	public Contact finfById(Integer id) throws DaoException;
	public Contact updateContact(Contact contact) throws DaoException;
	public Contact deleteContact(Integer id) throws DaoException;
	
	//Query
	
	public List<Contact> findAll() throws DaoException;
    public List<Contact> findByCity(Contact city) throws DaoException;
}
