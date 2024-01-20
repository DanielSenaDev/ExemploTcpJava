/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJavaRadioLocal;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TCPServerRadioLocal{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1")); //Essa linha representa as opreçãoes SOCKET, BIND e LISTEN; 3300 é a porta; 5 é o tamanho da lista de acesso; 3° parametro é o IP
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão) //Representa o ACCEPT - Aceite o proximo pedido de opração, essa ação é BLOQUEANTE, esperando o pedido de conexão | Apos aceitar a conexao, essa interface Socket representa o IN e o OUT
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados //sock representa a conexao
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            byte[] buf = new byte[20]; // buffer de recepção //Define buffer interno de 20 bytes, define o numero de vezes que irá coletar os dados - se tem 200bytes disponíveis no SO e com buffer de 20, será feito o processo 10 vezes

            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(buf); // Operação bloqueante (aguardando chegada de dados) //Aqui é o RECEIVE
            System.out.println("[OK] ]");
            
            String msg = new String(buf); // Mapeando vetor de bytes recebido para String //Aqui mapea para String pois conhece que P1 enviou em String, dai P2 está mapeando para String
            
            System.out.println("|  Mensagem recebida: "+ msg);
            
            
            //Incremento #02
            System.out.print("|  Escreva sua mensagem: \n> ");
            Scanner sc = new Scanner(System.in);
            String msgSend = sc.nextLine();
            
            byte[] bufSend = msgSend.getBytes(); // Obtendo a respresentação em bytes da mensagem
            
            System.out.print("[ Enviando mensagem de Resposta    ..................  ");
            os.write(bufSend); //o envio é interessado em enviar em bytes, por isso pega os bytes; aqui é o SEND, por trás, o SO chama o SEND
            System.out.println("[OK] ]");
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}