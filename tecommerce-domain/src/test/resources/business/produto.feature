# language: pt
# encoding: UTF-8

Funcionalidade: Descrever os cenarios de criacao de um produto
				No contexto de venda e compra do tecommerce 

Cenário: Criar um produto valido
	Dado que informo a descricao "Notebook Dell Vostro 14 polegadas, Processador Core I7, 8GB de memoria, 256 SSD."
	E informo o nome "Notebook Dell Vostro 14"
	E informo o valor de venda de "2099.83"
	Quando criar um produto
	Entao devo ter o mesmo criado