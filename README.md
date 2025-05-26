# 🧠 Teste Automatizado: Autocomplete na Amazon Brasil

## 🧠 Resumo em alto nível

Implementei um teste automatizado com Selenium em Java para validar o comportamento da funcionalidade de **autocomplete** na barra de busca da **Amazon Brasil**.  
O objetivo era garantir que as sugestões aparecessem corretamente após digitar um termo, o que está diretamente relacionado à **experiência do usuário** e à **conversão da plataforma**.

---

## 💡 Por que eu escolhi esse teste

A **busca é uma funcionalidade crítica** em e-commerces. Se o autocomplete estiver com falhas, o usuário pode abandonar a sessão.  
Por isso, validei se as sugestões aparecem corretamente ao digitar um termo genérico, como **"livro"**.

---

## 🔧 Tecnologias utilizadas

- **Linguagem:** Java  
- **Framework de testes:** JUnit 5  
- **Automação web:** Selenium WebDriver  
- **BDD:** Cucumber  
- **Page Object Model:** Abstraí a Home em uma classe `HomePage`  
- **Estrutura modular:** Separação de setup, teste e teardown  
- **Sincronização inteligente:** Uso de `WebDriverWait` com `ExpectedConditions` para garantir robustez  

---

## ⚙️ O que o teste faz exatamente

1. Abre o navegador **Chrome**  
2. Navega até a **Amazon Brasil**  
3. Digita o termo **“livro”** na barra de pesquisa  
4. Aguarda a renderização das sugestões (`.s-suggestion`)  
5. Valida se **ao menos uma sugestão** é exibida  

---

## 🎯 Execução com Cucumber + Hooks

O projeto utiliza **Cucumber Hooks** para realizar o setup e teardown do navegador de forma automatizada:

```java
@Before
public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}

@After
public void tearDown() {
    driver.quit();
}
```

A feature do teste é escrita no formato Gherkin, por exemplo:

```gherkin
Funcionalidade: Autocomplete da Amazon

  Cenário: Exibir sugestões ao digitar um termo válido
    Dado que o usuário acessa a página inicial da Amazon
    Quando ele digita "livro" na barra de busca
    Então uma lista de sugestões deve ser exibida
```

---

## 🛠️ Instalação e execução

### ✅ Pré-requisitos

- Java JDK 11+
- Maven ou Gradle
- Google Chrome instalado
- ChromeDriver compatível com a versão do navegador

### 💻 Clonando o projeto

```bash
git clone https://github.com/seu-usuario/amazon-autocomplete-test.git
cd amazon-autocomplete-test
```

### ⚙️ Executando os testes com Maven

```bash
mvn clean test
```

### 📊 Gerando relatório do Cucumber (opcional)

```bash
mvn verify
# O relatório será gerado na pasta target/cucumber-reports/
```

---

## 📈 Valor do teste para o negócio

Esse tipo de automação é essencial em **testes de regressão**.  
Imagine uma mudança no frontend que quebre o autocomplete — com esse teste, o time de QA é notificado **antes** que o problema afete os usuários finais.

---

## 🧩 Desafios e soluções

Um dos desafios enfrentados foi o **bloqueio por automação da Amazon**, que exibe CAPTCHA.  
Para contornar isso em testes reais, criei uma versão **simulada da página de busca** localmente, com **dados mockados** — e isso me permitiu validar a **lógica do autocomplete** sem obstáculos externos.

---

## 📌 Dicas para reforçar na entrevista

- Destaque que você pensou na **experiência do usuário**  
- Mencione que a automação cobre **cenários funcionais e não-felizes** (ex: sem sugestões)  
- Mostre que você domina **boas práticas de sincronização**  
- Reforce o uso do **Page Object Model** para manter o código limpo e reutilizável  
- Demonstre conhecimento na **estrutura do Cucumber**, com Hooks e Gherkin  

---

> **Autor:** Weverson  
