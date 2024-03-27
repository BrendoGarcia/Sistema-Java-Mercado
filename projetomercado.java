


import java.sql.SQLException;
import java.util.Scanner;

public class projetomercado {


  private static final String testconec = null;

  public static void main(String[] args)throws InterruptedException, SQLException {

	  acessomysql banco1 = new acessomysql();
	  banco1.conectar();
	  banco1.loginSistema();
	  for (;;) {
      acessomysql banco = new acessomysql();
      banco.conectar();
      banco.estaConectado();
      

      System.out.println("\n");

      System.out.println(" =========================================");
      System.out.println(" |    MENU DE SELEÇÃO DE OPÇÕES          |");
      System.out.println(" |        MERCADO SOL e MAR              |");
      System.out.println(" |      CNPJ:11.331.464/0001-05          |");
      System.out.println(" |=======================================|");
      System.out.println(" | 1 = CADASTRAR NOVO FUNCIONARIO        |");
      System.out.println(" | 2 = CADASTRAR NOVO PRODUTO            |");
      System.out.println(" | 3 = CONSULTAR FUNCIONARIO             |");
      System.out.println(" | 4 = CONSULTAR PRODUTO                 |");
      System.out.println(" | 5 = ADICIONAR OU CONSULTAR CATEGORIA  |");
      System.out.println(" | 6 = VENDER PRODUTOS                   |");
      System.out.println(" | 7 = SOLICITAR PRODUTO AO FORNECEDOR   |");
      System.out.println(" | 8 = CADASTRO DE FORNECEDOR            |");
      System.out.println(" | 9 = CONSULTAR DEPARTAMENTOS           |");
      System.out.println(" | 0 = SAIR                              |");
      System.out.println(" =========================================");
      int op;
      Scanner s = new Scanner(System.in);
      op = s.nextInt();

      switch(op) {

      case  1: {
        banco.cadastro();
        banco.fecharconeccao();

        System.out.println("=================================================");
        System.out.println("|       CADASTRO REALIZADO COM SUCESSO          |");
        System.out.println("|AGUARDE 2 SEGUNDOS PARA VOLTAR AO MENU INICIAL |");
        System.out.println("=================================================");

        Thread.sleep(2000);

        System.out.println("\n");
        System.out.println("\n");
        break;


      }



      case 2: {
        banco.cadastroProduto();
        banco.fecharconeccao();


        System.out.println("==============================");
        System.out.println("| PRODUTO CRIADO COM SUCESSO |");
        System.out.println("==============================");

        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;
      }
      case 3: {
        banco.consulta();
        banco.fecharconeccao();

        System.out.println("===================");
        System.out.println("| FIM DA CONSULTA |");
        System.out.println("===================");
        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;
      }
      case 4: {
        banco.consulp();
        banco.fecharconeccao();
        System.out.println("=====================");
        System.out.println("|   FIM DA CONSULTA |");
        System.out.println("=====================");
        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;


      }
      case 5:{ 
        banco.consulcategoria();
        banco.fecharconeccao();



        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;
      }
      case 6: { 
      banco.vender();
      banco.fimregistros();
      banco.fecharconeccao();

        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;
      }

      case 7:{
      banco.cosultafornecedor();
      banco.fecharconeccao();


        Thread.sleep(2000);
        System.out.println("\n");
        System.out.println("\n");
        break;
      }


      case 0:{	
      banco.fecharconeccao();
      banco.fimapresenta();
        System.out.println("===================================");
        System.out.println("| FECHANDO PROGRAMA EM 2 SEGUNDOS |");
        System.out.println("===================================");
        Thread.sleep(2000);
        System.exit(0);
        break;



      }

      case 8:{
        banco.fornecedor();
        banco.fecharconeccao();
        break;

      }

      case 9:{ 
        banco.departamentoss();
        banco.fecharconeccao();
        break;

      }

      default:{
        System.out.println("==================================");
        System.out.println("| SELECIONE UMA OPERAÇÃO CORRETA |");
        System.out.println("==================================");
        Thread.sleep(2000);
        break;
      }  

      }	



    }
  }

  }

