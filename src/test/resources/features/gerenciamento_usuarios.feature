Feature: Criar um tópico de discussão
	Eu, enquanto um usuário anônimo do fórum
	Devo conseguir criar um novo tópico de discussão
	De forma que eu possa tirar minhas dúvidas com a comunidade
	
	Scenario: Devo conseguir acessar a página de criação de novo tópico
		Given Estou na página inicial da minha aplicação
		When Eu clico no link "Criar novo tópico"
		Then Devo ser redirecionado para a página "Novo Tópico"
		
	Scenario: Devo conseguir criar um novo tópico
		Given Estou na página "Novo Tópico"
		When Eu preencho os dados de um novo tópico
		And Eu clico em "Salvar"
		Then Devo ser redirecionado para a página do tópico