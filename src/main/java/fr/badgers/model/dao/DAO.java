package fr.badgers.model.dao;

import java.util.List;

public interface DAO<T, ID> {

/**
* Permet la suppression d'un tuple de la base
*
* @param obj
*/
public boolean delete(T obj);

/**
* Permet de r�cup�rer tous les objets d'une table
*
* @return
*/
public List<T> FindAll();

/**
* Permet de r�cup�rer un objet via son ID
*
* @param id
* @return
*/
public T getById(ID id);

/**
* Permet de cr�er une entr�e dans la base de donn�es par rapport � un objet
*
* @param obj
*/
public T insert(T obj);

/**
* Permet de mettre � jour les donn�es d'un tuple dans la base � partir d'un
* objet pass� en param�tre
*
* @param obj
*/
public boolean update(T obj);

}