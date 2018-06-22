package tryout.middle.api;

import java.math.BigDecimal;

import tryout.middle.api.visitors.CapitaliseVisitor;
import tryout.middle.api.visitors.InformationVisitor;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.IBankAccount;

public abstract class BankAccountDecorator implements IBankAccount {
	
	BankAccount bankAccount;
	
	public BankAccountDecorator(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void debit(BigDecimal sum) {
		bankAccount.debit(sum);
	}

	@Override
	public void credit(BigDecimal sum) {
		bankAccount.credit(sum);
	}

	@Override
	public void accept(InformationVisitor visitor) {
		bankAccount.accept(visitor);
	}

	@Override
	public void accept(CapitaliseVisitor visitor) {
		bankAccount.accept(visitor);
	}
	
	
}
