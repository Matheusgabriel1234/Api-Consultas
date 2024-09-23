package matheus.desafios.API_Consultas.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import matheus.desafios.API_Consultas.exceptions.CrmAlreadyRegistred;
import matheus.desafios.API_Consultas.exceptions.DataConflictException;
import matheus.desafios.API_Consultas.exceptions.DocumenteAlreadyRegistred;
import matheus.desafios.API_Consultas.exceptions.EmailAlreadyExistsException;
import matheus.desafios.API_Consultas.exceptions.IdNotFoundException;
import matheus.desafios.API_Consultas.exceptions.InvalidDateException;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<?> handleEmailAlreadyExistsException(EmailAlreadyExistsException e , WebRequest request){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),request.getDescription(false));
return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(DocumenteAlreadyRegistred.class)
public ResponseEntity<?> handleDocumentAlreadyRegistredException(DocumenteAlreadyRegistred e, WebRequest req){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),req.getDescription(false));
return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(CrmAlreadyRegistred.class)
public ResponseEntity<?> handleCrmAlreadyRegistredException(CrmAlreadyRegistred e, WebRequest req){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),req.getDescription(false));
return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<?> handleIdNotFoundException(IdNotFoundException e,WebRequest req){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),req.getDescription(false));
return new ResponseEntity<> (details,HttpStatus.BAD_REQUEST);
	
}

@ExceptionHandler(InvalidDateException.class)
public ResponseEntity<?> handleInvalidDateException(InvalidDateException e,WebRequest req){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),req.getDescription(false));
return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(DataConflictException.class)
public ResponseEntity<?> handleDataConflictException(DataConflictException e,WebRequest req){
ErrorDetails details = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),req.getDescription(false));
return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
}

}
