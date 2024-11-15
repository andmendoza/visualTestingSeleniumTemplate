package com.teon.exceptions;

public class NoValidBrowserException extends Exception{
	
	// Añadir serialVersionUID para evitar advertencias de serialización
    private static final long serialVersionUID = 1L;
	
	public NoValidBrowserException(String browser) {
		super("Invalid browser : '" + browser + "'");
	}

}
