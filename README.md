# EVTEST

# Project Title

Running Test cases for ss.com


### Prerequisites

We need to have install these below


1) maven

2) jdk1.8




 

## Running the tests


mvn clean test

Note:- Test has support to run for chrome and Firefox browser



2) Once test are run report are present in below path in project

/target/surefire-reports/index.html






## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [testng](http://testng.org/) - testing framework
* [Selenium](http://www.seleniumhq.org/)-UI testing framework

## Test Flow Included

1. Open the browser and maximize it.
2. Open  ss.com
3. switch to Russian language.
4. Go to the section “Электротехника”, open search ('Поиск') and in Search enter the search phrase (eg. 'Computer') and select a different search parameters.
5. Click Search
6. Sort the results by price and select option 'Продажа' in "Тип сделки" dropdown.
7. Open “Расширенный поиск”. (advanced search)
8. Enter search option price between 160 and 300.
9. Choose at least 3 random ads.
10. Press “Добавить выбранные в закладки” ( = add to memo)
11. Open “Закладки” and check that the ads on the page match the previously selected
12. Close the browser.


