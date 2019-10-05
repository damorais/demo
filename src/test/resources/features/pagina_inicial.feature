Feature: A aplicação deve possuir uma página inicial de boas vindas
	Eu enquanto usuário da aplicação
	Quando eu acessar a página inicial devo receber uma mensagem de boas vindas
	Para que eu tenha uma página adequada para começar a usar a aplicação
	
	Scenario: Devo ter uma página inicial com uma mensagem de boas vindas
		When Acesso a home page da aplicação
		Then Eu devo ver uma mensagem de boas vindas dizendo "Olá, Cucumber"