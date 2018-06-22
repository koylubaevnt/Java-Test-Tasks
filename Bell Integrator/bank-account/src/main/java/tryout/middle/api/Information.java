package tryout.middle.api;

import tryout.middle.api.visitors.InformationVisitor;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public class Information implements InformationVisitor {

	@Override
	public void visit(BankAccount bankAccount) {
		System.out.print("Bank account num: " + bankAccount.getNum());
	}

	@Override
	public void visit(DebitBankAccount bankAccount) {
		System.out.println("Amount: " + bankAccount.getAmount() 
				+ ", Type: DEBIT, " + bankAccount.getDiscriminatorValue());

	}

	@Override
	public void visit(CreditBankAccount bankAccount) {
		System.out.println("Min. Amount: " + bankAccount.getMinAmount()
				+ ", Type: CREDIT, " + bankAccount.getDiscriminatorValue());

	}

}
