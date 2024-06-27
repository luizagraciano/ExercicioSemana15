Feature: Login
    Scenario: Login com sucesso
    Given Usuario esteja na pagina de Login
    When Usuario preencher campo Username
    And Usuario preencher campo Password
    And Usuario clicar no botão Login
    Then Usuario deve ser redirecionado para pagina de Secure Area

    Scenario: Login com senha em branco
    Given Usuario esteja na pagina de Login
    When Usuario preencher campo Username
    And Usuario nao preencher campo Password
    And Usuario clicar no botão Login
    Then Usuario deve receber mensagem de senha invalida

    Scenario: Login com usuario em branco
    Given Usuario esteja na pagina de Login
    When Usuario nao preencher campo Username
    And Usuario preencher campo Password
    And Usuario clicar no botão Login
    Then Usuario deve receber mensagem de usuario invalido

    Scenario: Login com senha incorreta
    Given Usuario esteja na pagina de Login
    When Usuario preencher campo Username
    And Usuario preencher campo Password com senha incorreta
    And Usuario clicar no botão Login
    Then Usuario deve receber mensagem de senha invalida

    Scenario: Login com usuario incorreto
    Given Usuario esteja na pagina de Login
    When Usuario preencher campo Username com usuario incorreto
    And Usuario preencher campo Password
    And Usuario clicar no botão Login
    Then Usuario deve receber mensagem de usuario invalido