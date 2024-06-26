Feature: Login
    Scenario: Login com sucesso
    Given Usuario esteja na pagina de Login
    When Usuario preencher campo Username
    And Usuario preencher campo Password
    And Usuario clicar no botão Login
    Then Usuario deve ser redirecionado para pagina de Secure Area