Feature: Sample feature
  As part of test

  @selenium
  Scenario: demo blaze
    Given open url https://www.demoblaze.com/index.html
    And login to page

  Scenario: rest
    Given get method for https://api.coindesk.com/v1/bpi/currentprice.json is called
    Then retrieve bpi.GBP.rate from response

  @selenium
  Scenario: Katalon 2nd UI scenario
    Given open url https://katalon-demo-cura.herokuapp.com/profile.php#login
    And login to katalon page


  Scenario: rest scenario 2
    Given get method for http://universities.hipolabs.com/search?country=South+Africa is called
    Then retrieve find{it.name=='University of Witwatersrand'}.state-province from response