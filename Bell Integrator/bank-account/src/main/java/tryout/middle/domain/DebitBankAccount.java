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
        //TODO: ����� ��� �������� � ��������� �� ������������ ����� �� ����� � �������� ����� �� ����. 
    	//�.�. debit - ���������� � ������������� ����� ����� �� ����� ��� �������.    	
    	//if (isValidSum(sum) && isValidAmmount(sum))
    	if (isValidSum(sum))
            operate(sum);
    }

    @Override
    public void credit(BigDecimal sum) {
    	//TODO: ����� ��� �������� �.�. ��������� �� ������������ ����� �� ����� � ����������� ����� ����. 
    	//�.�. credit - �������� � ������������� ����� ����� �� ����� ����� (�.�. ������ ��������� � �����).    	
    	//if (isValidSum(sum))
    	if (isValidSum(sum) && isValidAmmount(sum))
            operate(sum.negate());
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        //TODO: ���� �� ����� ����� ���������� ��� ��������
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
