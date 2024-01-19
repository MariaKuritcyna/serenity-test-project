Feature: API

  Scenario: GET запрос
    Given URL "https://reqres.in" path "/api/users"
    When Я дергаю метод GET с параметром "?page=2"
    Then Возвращается Status code 200
    And В ответе в объекте data есть "first_name" со значением "Lindsay"
    And В ответе есть "page" со значением 2

  Scenario: POST запрос
    Given URL "https://reqres.in" path "/api/users"
    When Я дергаю метод POST c request body (name:рандомно сгенерированное значение, job:рандомно сгенерированное значение)
    Then Возвращается Status code 201
    And В ответе есть "name" с рандомно сгенерированным значением
    And В ответе есть "job" с рандомно сгенерированным значением