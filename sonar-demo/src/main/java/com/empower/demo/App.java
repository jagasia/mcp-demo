package com.empower.demo;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */

class Employee{
	String name;
}

//this program is a good program
public class App 
{
	
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
    		
//        System.out.println( "Hello World!" );		//syso should be replaced by logger entries
    			LOGGER.info("Hello world!");
        Employee raja=null;				//not initialized
        raja.name="Raja";			//null pointer exception
        int []arr= {};
        
//        System.out.println(arr[0]); 		//ArrayIndexOutOfBoundsException
        LOGGER.info(arr[0]+"");
        
    }
}
