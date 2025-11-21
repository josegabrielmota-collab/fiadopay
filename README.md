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
## Comandos para testar
### Inicializar
`./mvnw spring-boot:run`
ou
`mvnw.cmd spring-boot:run`

### Criação
`curl -X POST http://localhost:8080/fiadopay/admin/merchants -H "Content-Type: application/json" -d "{\"name\":\"teste\",\"webhookUrl\":\"http://localhost:8081\"}"`

### Teste de Pagamento Valido
`curl -X POST http://localhost:8080/fiadopay/gateway/payments -H "Authorization: Bearer FAKE-1" -H "Content-Type: application/json" -d "{\"amount\":100.00,\"currency\":\"BRL\",\"method\":\"PIX\"}"`

### Teste de Pagamento Invalido
`curl -X POST http://localhost:8080/fiadopay/gateway/payments -H "Authorization: Bearer FAKE-1" -H "Content-Type: application/json" -d "{\"amount\":5000.00,\"currency\":\"BRL\",\"method\":\"PIX\"}"`

## Evidencias
### Evidencia 1 - Inicialização
<img width="1279" height="509" alt="EvidenciaA" src="https://github.com/user-attachments/assets/51f6ea2f-6c8e-424c-8447-69f71025a6b6" />

### Evidencia 2 - Sucesso
<img width="1165" height="533" alt="EvidenciaB" src="https://github.com/user-attachments/assets/c9b00637-17e6-4925-a2b1-589a0ff85300" />
Pagamento de R$ 100,00 (Status 201)

### Evidencia 3 - Fraude
<img width="1173" height="624" alt="EvidenciaC" src="https://github.com/user-attachments/assets/779e5b5b-d13d-4a07-b96a-f876901e554a" />
Pagamento de R$ 5.000,00 (Status 400) bloqueado pela anotação @AntiFraude(threshold=2000)

