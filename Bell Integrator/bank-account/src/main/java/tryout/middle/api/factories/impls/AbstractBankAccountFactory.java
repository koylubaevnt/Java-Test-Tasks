package tryout.middle.api.factories.impls;

import tryout.middle.api.factories.IBanckAccountFactory;
import tryout.middle.domain.BankAccount;

public abstract class AbstractBankAccountFactory implements IBanckAccountFactory {

	public abstract BankAccount createBankAccount();

}
