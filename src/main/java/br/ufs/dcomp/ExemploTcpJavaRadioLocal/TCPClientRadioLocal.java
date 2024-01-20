/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJavaRadioLocal;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TCPClientRadioLocal{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300); //Aqui usa o IP e a PORTA para estabelecer a conexão ; sock é a interface de Entrada e Saida IN OUT
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            //INCREMENTO #02
            //String msg = "Olá, DCOMP!!!"; //Define uma mensagem String
            System.out.print("|  Escreva sua mensagem: \n> ");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            
            
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf); //o envio é interessado em enviar em bytes, por isso pega os bytes na linha 18 ; aqui é o SEND, por trás, o SO chama o SEND
            System.out.println("[OK] ]");
            
            //Incremento #01 - SERVIDOR ENVIAR MENSAGEM DE RETORNO
            //Recebimento do cliente pela mensagem do servidor
            byte[] bufReceiver = new byte[20]; // buffer de recepção //Define buffer interno de 20 bytes, define o numero de vezes que irá coletar os dados - se tem 200bytes disponíveis no SO e com buffer de 20, será feito o processo 10 vezes
            
            System.out.print("[ Aguardando receber mensagem de retorno   ..........  ");
            is.read(bufReceiver); // Operação bloqueante (aguardando chegada de dados) //Aqui é o RECEIVE
            System.out.println("[OK] ]");
            
            String msgReceiver = new String(bufReceiver); // Mapeando vetor de bytes recebido para String //Aqui mapea para String pois conhece que P1 enviou em String, dai P2 está mapeando para String
            
            System.out.println("|  Mensagem recebida: "+ msgReceiver);
            
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}