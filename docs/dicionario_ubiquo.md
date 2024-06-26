Abaixo uma lista com os termos comuns utilizados no projeto e suas definições:

- **Cliente:** Pessoa que fez pedido para a lanchonete.
- **Cadastro do cliente:** Ação de registro de um cliente no banco de dados do sistema. Durante o cadastro o CPF, email e nome do cliente devem ser fornecídos.
- **Identificador do cliente:** Os clientes cadastrados no sistema são identificados através de seu CPF.
- **Menu | Cardápio:** Lista de items oferecidos pela lanchonete para compra dos clientes
- **Produto | Item:** Produto oferecido para compra dos clientes no menu da lanchonete, desde comidas e bebidas até condimentos adicionais. Cada produto deve estar classificado em uma única categoria:
- **Categoria de Produto:**
    - **Lanche:** Lanches são os principais produtos oferecidos pela lanchonete. São sempre produtos comestíveis (não líquidos), salgados e tendem a representar maior parte da porção do combo. Exemplos: Hamburguers
    - **Acompanhamento:** Produtos adicionais que podem ser incluídos em um combo. Podem ser produtos diretamente comestíveis ou condimentos. Exemplos: Batata-frita, molho extra
    - **Bebida:** Produtos líquidos que podem ser pedidos adicionalmente em um combo. Exemplo: Refrigerante, água
    - **Sobremesa:** Produtos doces oferecidos como opção complementar do combo. Exemplo: Sorvete
- **Pedido | Combo:** Grupo de items escolhidos pelo cliente durante efetuação da compra.
- **Status do pedido:** Situação de preparo em que um pedido do cliente se encontra após aprovação do pagamento.
    - **Recebido:** O pedido foi enviado para a cozinha
    - **Em preparação:** Funcionários da cozinha iniciaram a preparação do pedido
    - **Pronto:** O pedido foi finalizado pela cozinha e está aguardando a retirada pelo cliente
    - **Finalizado:** O pedido foi retirado pelo cliente e totalmente finalizado
- **Usuário:** Pessoa que interage de alguma forma com o sistema, pode ser um cliente ou funcionário da lanchonete.
- **Cozinha:** Área responsável pela preparação dos pedidos
- **Cadastro do item:** Ação de registro ou edição de um item no banco de dados do sistema.
- **Gateway de Pagamento**: Serviço externo disponibilizado pelo parceiro para processamento do pagamento
- **Mercado Pago:** Parceiro que disponibiliza o sistema para processar de pagamento.
- **Pagamento via QR Code:** Após confirmação do pedido pelo cliente, um código QR é disponibilizado para pagamento pelo cliente.
- **QR Code:** Código disponibilizado pelo sistema do Mercado Pago para realização do pagamento de um pedido.
- **Pagamento:** Transação monetária pelo cliente para a lanchonete permitindo a venda do combo.
- **Portal Administrativo:** Portal interno que permite aos funcionários executar a gestão dos produtos e pedidos
    - **Gestão de produtos:** Fluxo que permite adicionar, excluir e editar produtos do menu
    - **Gestão de pedidos:** Fluxo que permite acompanhar os pedidos solicitados, verificar detalhes sobre um deles ou atualizar suas informações.
- **Lista de produtos:** Listagem dos produtos cadastrados no menu da lanchonete
- **Lista de pedidos:** Listagem dos pedidos solicitados pelos clientes
- **Funcionário:** Funcionário da lanchonete
- **Monitor de acompanhamento:** Televisão que exibe os status dos pedidos para o cliente no ambiente físico da lanchonete.