package tryout.middle.api;

import java.math.BigDecimal;

import tryout.middle.domain.BankAccount;

public class BonusBankAccountDecorator extends BankAccountDecorator {

	public BonusBankAccountDecorator(BankAccount bankAccount) {
		super(bankAccount);
	}

	@Override
	public void debit(BigDecimal sum) {
		bankAccount.debit(sum.add(new BigDecimal(100)));
	}
	
}
