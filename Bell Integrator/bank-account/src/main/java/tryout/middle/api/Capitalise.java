package tryout.middle.api;

import java.math.BigDecimal;

import tryout.middle.api.visitors.CapitaliseVisitor;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public class Capitalise implements CapitaliseVisitor{

	public static final BigDecimal ten = new BigDecimal("10");
	
	@Override
	public void visit(DebitBankAccount bankAccount) {
		bankAccount.debit(ten);
	}

	@Override
	public void visit(CreditBankAccount bankAccount) {
		bankAccount.credit(ten);
	}
	
	
}
