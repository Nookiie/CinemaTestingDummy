Feature: Projection seat reservation feature
  Отговаря за резервация на дадено място за дадена прожекция

  Scenario: Потребителят резервира място за дадена прожекция успешно
    Given Потребителят отваря началната стравица
    And натиска върху бутона за избор на прожекция
    And появява се форма за избор на прожекции
    And избира си прожекция от графика
    And се проверява дали е възможно да се направи резервация
    When кликне на бутона за създаване на резервация
    And визуализира се форма за резервация на дадени места за прожекцията
    And кликне на местата, които ще резервира
    And кликне на бутона за плащане на резервацията
    And се появява форма за плащане на резервацията
    And си въведе името
    And си въведе детайлите на кредитната карта
    And натисне бутона за създаване на резервация
    And се проверява кредитната карта
    And се осъществява банков превод по кредитната карта
    Then вижда съобщение за резервацията "Reservation Successful!"
    
   Scenario: Потребителят резервира място за дадена прожекция, но е един час или по-малко преди започването на прожекцията
    Given Потребителят отваря началната стравица
    And натиска върху бутона за избор на прожекция
    And избира си прожекция от графика, която започва до един час
    And се проверява дали е възможно да се направи неправилна резервация
    Then вижда съобщение за резервацията "Reservation could not be made! Too late!"
    
   Scenario: Потребителят резервира място за дадена прожекция, но няма свободни места
   	Given Потребителят отваря началната стравица
   	And натиска върху бутона за избор на прожекция
    And избира си прожекция от графика, която няма свободни места
    And се проверява дали е възможно да се направи неправилна резервация
    Then вижда съобщение за резервацията "Reservation could not be made! No vacant seats!"
    
    Scenario: Потребителят резервира място за дадена прожекция, но то вече е заето
    	Given Потребителят отваря началната стравица
    	And натиска върху бутона за избор на прожекция
    	And избира си прожекция от графика
    	And се проверява дали е възможно да се направи резервация
    	When кликне на бутона за създаване на резервация
    	And визуализира се форма за резервация на дадени места за прожекцията
    	And кликне на местата, които ще резервира, които вече са заети
    	And кликне на бутона за плащане на резервацията
    	Then вижда съобщение за резервацията "Reservation could not be made! Seat is reserved!"
    	
    Scenario: Потребителят резервира място за дадена прожекция, но не е избрал място
    	Given Потребителят отваря началната стравица
    	And натиска върху бутона за избор на прожекция
    	And избира си прожекция от графика
    	And се проверява дали е възможно да се направи резервация
    	When кликне на бутона за създаване на резервация
    	And визуализира се форма за резервация на дадени места за прожекцията
    	And не избира място за резервация
    	And кликне на бутона за плащане на резервацията
    	Then вижда съобщение за резервацията "Reservation could not be made! No selected seats!"
    	
    #Scenario: Потребителят резервира място за дадена прожекция, но не си е въвел информация за кредитната карта
    #Scenario: Потребителят резервира място за дадена прожекция, но не си е въвел името
    #Scenario: Потребителят резервира място за дадена прожекция, но e резервирал едно и също място два пъти