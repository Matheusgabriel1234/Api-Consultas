package matheus.desafios.API_Consultas.exceptions;

public class DocumenteAlreadyRegistred extends RuntimeException {

	/**
	 * 
	 */
private static final long serialVersionUID = 1L;

public DocumenteAlreadyRegistred(String message) {
	super(message);
}

}
