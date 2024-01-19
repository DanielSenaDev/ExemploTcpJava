/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300); //Aqui usa o IP e a PORTA para estabelecer a conexão ; sock é a interface de Entrada e Saida IN OUT
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg = "Olá, DCOMP!!!"; //Define uma mensagem String
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf); //o envio é interessado em enviar em bytes, por isso pega os bytes na linha 18 ; aqui é o SEND, por trás, o SO chama o SEND
            System.out.println("[OK] ]");
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}