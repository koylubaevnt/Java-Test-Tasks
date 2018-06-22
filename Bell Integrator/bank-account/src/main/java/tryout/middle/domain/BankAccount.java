package tryout.middle.domain;

import lombok.Data;
import lombok.Getter;
import tryout.middle.api.visitors.InformationVisitor;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bankAccountType", discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount implements IBankAccount{

    private Long id;
    private String num;
    private BigDecimal amount;
    private LocalDate open;
    private LocalDate close;
    private LocalDate end;
    
    protected final void operate(BigDecimal sum){
        amount = amount.add(sum);
    }

    public abstract boolean isValidAmmount(BigDecimal sum);

    public static boolean isValidSum(BigDecimal sum){
        
		//TODO: Думаю тут ошиблись и работать надо с положительными суммами. т.к. debit - пополнение, а credit - списание, то сами операции несут в себе знак
    	//поэтому считаю, что правильно надо проверять, что передали в операцию "правильное" число, а это положительное.
    	//return sum.signum()==-1;
    	return sum.signum() != -1;
    }

	@Override
	public void accept(InformationVisitor visitor) {
		visitor.visit(this);
	}
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);

	    return val == null ? null : val.value();
	}
    
}

