/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RouteFinding;

/**
 *
 * @author Alireza
 */
public class Routing {
    public String findRoute(String [][] routes){
        
        String rt = "";
        boolean first = true;
        String temp = "";
        
        for(int i = 0; i < routes.length && first; i++){
            
            temp = routes[i][0];
            for(int j = 0; j< routes.length && first; j++){
                if(routes[j][1].equals(temp)){
                    first =  false;
                }
            }  
            if(first){
                rt = temp;
                //first = false;
            }
            first = true;
        }
        temp = rt;
        System.out.println(temp);
        for(int i = 0; i < routes.length - 1; i++){
            //temp = routes[i][0];
            for(int j = 0; j< routes.length; j++){
                if(routes[j][0].equals(temp)){
                    rt = rt + ", "+routes[j][1];
                    temp = routes[j][1];
                    System.out.println(temp);
                }
            }   
        }
            
        return rt;
    }
}
