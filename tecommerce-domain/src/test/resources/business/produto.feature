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
	
Cenário: Deve validar criacao de um produto invalido com campos obritorios nao informados
	Dado que nao informo os dados obrigatorios para a criacao de um produto
	Quando criar um produto
	Entao devo rececer a mensagem de erro "Campo Obrigatório." para "nome"	
	E devo rececer a mensagem de erro "Campo Obrigatório." para "descricao"
	E devo rececer a mensagem de erro "Campo Obrigatório." para "valor"

Cenário: Deve validar criacao de um produto invalido com tamanhos invalidos
	Dado que informo a descricao "Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum. Nulla non arcu lacinia neque faucibus fringilla. Nulla non lectus sed nisl molestie malesuada. Proin in tellus sit amet nibh dignissim sagittis. Vivamus luctus egestas leo. Maecenas sollicitudin. Nullam rhoncus aliquam metus. Etiam"
	E informo o nome "Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tem"
	E informo o valor de venda de "2099.83"
	Quando criar um produto
	Entao devo rececer a mensagem de erro "Informe no máximo 100 caracteres." para "nome"	
	E devo rececer a mensagem de erro "Informe no máximo 500 caracteres." para "descricao"
		
Cenário: Deve validar criacao de um produto invalido com valor do produto negativo	
	Dado que informo a descricao "Notebook Dell Vostro 14 polegadas, Processador Core I7, 8GB de memoria, 256 SSD."
	E informo o nome "Notebook Dell Vostro 14"
	E informo o valor de venda de "-15.78"
	Quando criar um produto
	Entao devo rececer a mensagem de erro "Informe um valor maior que zero." para "valor"