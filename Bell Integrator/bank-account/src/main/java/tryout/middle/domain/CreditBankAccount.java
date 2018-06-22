package tryout.middle.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tryout.middle.api.visitors.CapitaliseVisitor;
import tryout.middle.api.visitors.InformationVisitor;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "Credit")
@Scope("prototype")
@Configuration
public class CreditBankAccount extends BankAccount{

    private BigDecimal minAmount;

    @Override
    public void debit(BigDecimal sum) {
        if (isValidSum(sum))
            operate(sum);
    }

    @Override
    public void credit(BigDecimal sum) {
        if (isValidSum(sum) && isValidAmmount(sum))
            operate(sum.negate());
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
    	//TODO: Не ясно что такое minAmount. Я подумал, что это сумма возможного кредита (ЛИМИТ), если нет, то мое утверждение неверно. Т.к. счет credit - то баланс может уйти в минус. 
    	//Если это сумма кредита, то определить можно ли дать клиенту еще денег если сумма находится в пределах лимита
    	//return getAmount().add(sum).compareTo(minAmount)!=-1;
    	return getAmount().add(minAmount).compareTo(sum)!=-1;
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
