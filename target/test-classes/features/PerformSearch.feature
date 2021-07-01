  #Author: Ilona Shabelnyk
  #Team: EPAM TA Basic_Kyiv_2021 Q2 [DEP]

  Feature: As a user I want to get ability to perform search so that I can find required book and buy it

    @test
    Scenario: Validation that the search is performed / search results are not empty (more than 0)
      Given Bookdepository website is opened on the main page
      When searchable term is entered into search input field
      When not searchable term is entered into search input field
      And Search button is clicked by guest
      And GO button is clicked by signed-in user
      Then search is performed and search results are not empty
      Then search is not performed and search results are empty