package com.teon.exceptions;

public class NoSuchPropertyFileException extends Exception {
	
	// Añadir serialVersionUID para evitar advertencias de serialización
    private static final long serialVersionUID = 1L;
	
	public NoSuchPropertyFileException(String fileName) {
		super("Property file not found: '" + fileName + "'");
	}

}
