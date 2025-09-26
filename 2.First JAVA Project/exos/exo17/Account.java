import excep.WithdrawalException;

public class Account{
	private int balance = 100;
	
	public void withdraw(int amount)throws WithdrawalException{
		if(amount > balance) throw new WithdrawalException("balance insuffisante");
		balance -= amount; //<=> balance = balance - amount
		System.out.println("retrait de "+amount+" termine avec succes ");
	}
	
	public int getBalance(){
		return balance;
	}

}