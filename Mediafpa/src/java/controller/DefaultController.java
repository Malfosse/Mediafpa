/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoDocument;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Document;

@Named
@ViewScoped
public class DefaultController implements Serializable {
	
	@Inject
	DaoDocument daoDocument;
	
	public DefaultController() {
		
	}
	
	public void DaoTest() {
		Document document = daoDocument.findByKey(1);
		
		System.out.println(document.getTitre());
	}
	
}
