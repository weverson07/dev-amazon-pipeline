Feature: Pesquisa de produtos

  Scenario: Pesquisar por um produto válido
    Given que eu estou na página inicial
    When eu pesquiso por "Livro"
    Then eu vejo resultados relacionados ao clicar