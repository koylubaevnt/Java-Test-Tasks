package tryout.middle.domain;

import java.math.BigDecimal;

import tryout.middle.api.visitors.CapitaliseVisitor;
import tryout.middle.api.visitors.InformationVisitor;

public interface IBankAccount {

    void debit(BigDecimal sum);
    void credit(BigDecimal sum);

    void accept(InformationVisitor visitor);	//����� ���������� � ���������� ��������
    void accept(CapitaliseVisitor visitor);	//������������� ����������� ��������
}
