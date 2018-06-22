package tryout.middle.api.visitors;

import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public interface InformationVisitor {

	void visit(BankAccount bankAccount);
	
	void visit(DebitBankAccount bankAccount);
	
	void visit(CreditBankAccount bankAccount);
	
}
