package fr.eni.tpServlets.bll;

public class BLLException extends Exception {
	//Constructeurs
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	//Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}	
}
