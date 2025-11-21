# FiadoPay Simulator (Spring Boot + H2)

**Equipe:**
- **José Gabriel dos Santos Mota**
- **Alisson Luis Ribeiro Conceição**
- **Arthur do Amaral Mota**

## Contexto do Trabalho
Escolhido a opção 1 do trabalho, envolvendo a refatoração do backend de FiadoPay aplicando **Reflexão**.

## Decisões de Design
**Threads**

- Substituição do `ForkJoinPool` pelo `ExecutorService`.
- Implementação do bean `threadPool` na `ApiConfig` (Pool fixo de 10 Threads) Com o intuito de evitar o travamento da aplicação em momento de pico.

## Anotações
### `@AntiFraude`
- Tem como alvo **Metodos** e define que uma operação financeira precisa de validação.
- **Metadados**
	- `threshold` : Valor limite para ativação da regra.
		- `name` : Identificador da regra.	
		
### `@PaymentMethod`
-  Tem como alvo **Classes**, com o objetivo de classificar implementações de meio de pagamento
- **Metadados**
	- `type`: Define o tipo
	
## Evidencias
### Evidencia 1 - Inicialização
### Evidencia 2 - Sucesso
Pagamento de R$ 100,00 (Status 201)
### Evidencia 3 - Fraude
Pagamento de R$ 5.000,00 (Status 400) bloqueado pela anotação @AntiFraud(threshold=2000)

