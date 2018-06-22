package tryout.middle.domain;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tryout.middle.api.visitors.CapitaliseVisitor;
import tryout.middle.api.visitors.InformationVisitor;

@Entity
@DiscriminatorValue(value = "Debit")
@Scope("prototype")
@Configuration
public class DebitBankAccount extends BankAccount {

    @Override
    public void debit(BigDecimal sum) {
        //TODO: Думаю тут ошиблись и проверять на корректность суммы на счете и вносимой суммы не надо. 
    	//Т.к. debit - пополнение и следовательно какая сумма на счету без разницы.    	
    	//if (isValidSum(sum) && isValidAmmount(sum))
    	if (isValidSum(sum))
            operate(sum);
    }

    @Override
    public void credit(BigDecimal sum) {
    	//TODO: Думаю тут ошиблись т.к. проверять на корректность суммы на счете и извлекаемой суммы надо. 
    	//Т.к. credit - списание и следовательно какая сумма на счету важно (т.к. нельзя списывать в минус).    	
    	//if (isValidSum(sum))
    	if (isValidSum(sum) && isValidAmmount(sum))
            operate(sum.negate());
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        //TODO: Если на счете денег достаточно для списания
    	//return getAmount().compareTo(sum)==-1;
    	return getAmount().compareTo(sum) != -1;
    }
    
    @Override
	public void accept(InformationVisitor visitor) {
		visitor.visit(this);
	}
    
	@Override
	public void accept(CapitaliseVisitor visitor) {
		visitor.visit(this);
	}
}
