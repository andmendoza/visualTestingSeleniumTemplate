package com.teon.exceptions;

public class MissingPropertyException extends Exception {
	
	// Añadir serialVersionUID para evitar advertencias de serialización
    private static final long serialVersionUID = 1L;
	
	public MissingPropertyException(String parName) {
		super("Property param not found: '" + parName + "'");
	}

}
