package unisa.dse.a2.students;

public class UntradedCompanyException extends Exception{
	
	public UntradedCompanyException(String companyCode){
		System.out.print(companyCode + " is not a listed company on this exchange");
	}
}
