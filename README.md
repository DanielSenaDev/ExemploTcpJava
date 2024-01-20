# ExemploTcpJava
Exemplo simples de sockets TCP em Java

# Instruções  iniciais

- USA `mvn compile` na pasta do projeto
- `java -cp target/classes/ br.ufs.dcomp.ExemploTcpJava.TCPServer`
- Abre um novo Terminal e entra na pasta do projeto
- `java -cp target/classes/ br.ufs.dcomp.ExemploTcpJava.TCPClient`

-  Após, o cliente irá enviar a mensagem e encerrar; O servidor irá receber a mensagem, imprimir e finalizar

## Incrementos
- 01 - SERVIDOR ENVIAR MENSAGEM DE RETORNO
    - Fazer com que o servidor após receber mensagem e imprimir, ele irá enviar uma mensagem de Resposta para o cliente e o cliente imprimi
     
- 02 - Implementar um pequeno chat tipo rádio amador, as mensagems serão capturadas via entrada padrão, que é o teclado, e que seja ciclico, tipo ping pong. 
    - Half-duplex, em ambas as vias mas não ao mesmo tempo. 1° um dos lados envia, o lado que enviou fica esperando a resposta e não pode enviar mensagem. 
    - Ou você está no modo de envio ou no modo de recepção. 
    - Para capturar o teclado, poderá usar o `Scanner sc = new Scanner(System.in)`. 
    - Após isntanciar o scanner Para capturar string usaremos: `String msg = sc.nextLine()`.
    - 
    - `java -cp target/classes/ br.ufs.dcomp.ExemploTcpJavaRadioLocal.TCPServerRadioLocal`
    - `java -cp target/classes/ br.ufs.dcomp.ExemploTcpJavaRadioLocal.TCPClientRadioLocal`
    
- 03 - Pegar um dos lados e fazer interação entre cliente e servidor de IPs públicos, de outros colegas
    - Por enquanto é feito de forma local 
    - Tem que configurar a maquina virtual do Cloud9
    - Temos que liberar a porta 3300