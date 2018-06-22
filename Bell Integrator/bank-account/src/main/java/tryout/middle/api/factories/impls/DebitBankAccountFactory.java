package tryout.middle.api.factories.impls;

import java.math.BigDecimal;
import java.time.LocalDate;

import tryout.middle.domain.BankAccount;
import tryout.middle.domain.DebitBankAccount;

public class DebitBankAccountFactory extends AbstractBankAccountFactory {

	@Override
	public BankAccount createBankAccount() {
		DebitBankAccount debit = new DebitBankAccount();
		debit.setAmount(new BigDecimal(0));
		debit.setOpen(LocalDate.now());
		return debit;
	}

}
