# language: pt
# encoding: UTF-8

Funcionalidade: Descrever os cenarios de criacao de um cliente
				No contexto de venda

Cenário: Criar um cliente valido
	Dado que informo o nome "Daniele"
	E informo a data de nascimento "10/09/1990"
	E informo o CPF "01569957002"
	Quando criar um cliente
	Entao devo ter um cliente valido
	
Cenário: Deve validar a criação de um cliente com CPF inválido

	Dado que informo o nome "Daniele"
	E informo a data de nascimento "10/09/1990"
	E informo o CPF "12569874123"
	Quando criar um cliente
	Entao devo rececer a mensagem de erro "Informe um CPF válido." para "cpf"
	
	