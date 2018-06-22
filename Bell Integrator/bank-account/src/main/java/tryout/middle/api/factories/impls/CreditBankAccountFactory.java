package tryout.middle.api.factories.impls;

import java.math.BigDecimal;
import java.time.LocalDate;

import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;

public class CreditBankAccountFactory extends AbstractBankAccountFactory {

	@Override
	public BankAccount createBankAccount() {
		CreditBankAccount credit = new CreditBankAccount();
		credit.setAmount(new BigDecimal(0));
		credit.setMinAmount(new BigDecimal(0));
		credit.setOpen(LocalDate.now());
		return credit;
	}

}
