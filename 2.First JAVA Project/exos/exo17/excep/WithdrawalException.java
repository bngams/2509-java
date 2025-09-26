package excep;

//exception contr�l�e doit �tre g�r�e ou d�clar�e
public class WithdrawalException extends Exception{

    public static final CODE = 510;

	public WithdrawalException(){
		super(); //facultatif
	}
	
	public WithdrawalException(String message){
		super(message); 
	}

}