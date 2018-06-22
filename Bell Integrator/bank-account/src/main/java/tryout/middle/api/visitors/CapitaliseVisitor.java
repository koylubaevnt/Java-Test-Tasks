package tryout.middle.api.visitors;

import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public interface CapitaliseVisitor {

	void visit(DebitBankAccount bankAccount);
	
	void visit(CreditBankAccount bankAccount);
	
}
