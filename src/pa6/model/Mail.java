/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.model;

/**
 *
 * @author Marcos
 */
public class Mail {
    private final Integer id;
    private final String mail;
    
    public Mail(Integer id, String mail){
        this.mail = mail;
        this.id = id;
    }
    
    public Integer getId(){
        return id;
    }
    
    public String getMail(){
        return mail;
    }
}