import excep.*;

class Client{

	public static void main(String[] args){
	  
	  Account acc = new Account();
	  
	  try{
		
		acc.withdraw(60);
		acc.withdraw(50);
	  
	  }catch(WithdrawalException we){ //le type peut être le super-type Exception
			we.printStackTrace();
			try{
			acc.withdraw(acc.getBalance());//l'invocation de withdraw() doit être gérée ou déclarée
			}catch (Exception e){
				e.printStackTrace();
			}
	  }finally{//attention finally correspond au premier bloc try ...catch
		System.out.println("la somme restant sur le compte est de "+acc.getBalance());
	  }
	
	}


}