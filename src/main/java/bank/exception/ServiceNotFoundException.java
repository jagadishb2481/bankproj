package bank.exception;

public class ServiceNotFoundException extends Exception{

	public ServiceNotFoundException (String s){
		super(s.toString());
	}
	
}
