package tryout.middle.api;

import java.math.BigDecimal;

import tryout.middle.domain.BankAccount;

public class SuperBonusBankAccountDecorator extends BankAccountDecorator {

	public SuperBonusBankAccountDecorator(BankAccount bankAccount) {
		super(bankAccount);
	}

	@Override
	public void debit(BigDecimal sum) {
		bankAccount.debit(sum.multiply(new BigDecimal(2)));
	}
	
	
}
