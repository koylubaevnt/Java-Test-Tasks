# bank-account
Test Task for job offer (Bank Account) [06.10.2016]

## Модель данных

    IBankAccount
    BankAccount
    CreditBankAccount
    DebitBankAccount
    
    void debit(BigDecimal sum); //пополнение счета
    void credit(BigDecimal sum); //списание со счета
    
* Необходиом создать **Hibernate Entity** использовать **Inheritance**

* Использую паттерн **Visitor** разработать интерефес вывода информации о BankAccount
    * Для **BankAccount** выводить номер счета
    * Для **DebitBankAccount** - выводить amount и признак, что счет debit
    * Для **CreditBankAccount** - выводить minAmount и признак, что счет credit
    
* Использую паттерн **Visitor** разработать интерефес капитализации счета    
    * Для **DebitBankAccount** - пополнять счет на 10 единиц
    * Для **CreditBankAccount** -уменьшать счет на 10 единиц    

* Использую паттерн **Decorator** разработать интерфейс пополнения
    * **BonusBankAccountDecorator** - при пополнении счета начислять бонус 100 единиц
    * **SuperBonusBankAccountDecorator** - при пополнении счета увеличить сумму в два раза
    
* Использую паттерн **Abstract Factory** разработать фабрики создания **BankAccount**
    * **AbstractBankAccountFactory**
    * **CreditBankAccountFactory** - для создания **CreditBankAccount**
    * **DebitBankAccountFactory** - для создания **DebitBankAccount**
    
* Для создания **BankAccount** использовать паттерн **Prototype**