//===============================================//
//Autores: Brendo, Adrian, Davi.                 //
//Versão: 1.0.0                                  //
//Ferramentas: Eclipse IDE, Mysql Workbench      //
//===============================================//


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

  public class acessomysql {
  private static final acessomysql banco = null;
  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultset = null;
  int verificar;

  public void conectar() {
    //Conectando ao banco de dados//
    String servidor = "";
    String usuario = "";
    String senha = "";

    try {

      this.connection = DriverManager.getConnection(servidor, usuario, senha);
      this.statement = this.connection.createStatement();
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }

  }

  public void estaConectado() {
    //mostrando o estado da conecção//
    if(this.connection != null) {
      System.out.println(" ========================================");
      System.out.println(" |         CONECTADO AO BANCO           |");
      System.out.println(" ========================================");
    } else {
      System.out.println(" ========================================");
      System.out.println(" |       NÃO CONECTADO AO BANCO         |");
      System.out.println(" ========================================");
    }
  }

  public void fecharconeccao() throws SQLException {
    //parametro para fechar o conecção do banco de dados//
    this.connection.close();
  }

  public void cadastro() {
    //cadastro de funcionaris//


    try {    
      System.out.println("=================");
      System.out.println("| NOME COMPLETO |");
      System.out.println("=================");
      String nomep;
      Scanner pnome = new Scanner(System.in);
      nomep = pnome.nextLine();

      System.out.println("================================");
      System.out.println("| DIGITE O ID DO DEPARTAMENTO  |"); // colocar aqui os departamentos existente
      System.out.println("================================");
      System.out.println("| RH            | ID = 1       |");
      System.out.println("| Diretoria     | ID = 10      |");
      System.out.println("| Administração | ID = 2       |");
      System.out.println("| TI            | ID = 3       |");
      System.out.println("| Estágio       | ID = 40      |");
      System.out.println("| Serviços Gera.| ID = 5       |");
      System.out.println("================================");

      int departamento = 0;
      Scanner dep = new Scanner(System.in);
      departamento = dep.nextInt();

      System.out.println("==========================");
      System.out.println("| SALARIO DO FUNCIONARIO |");
      System.out.println("==========================");
      float sala = 0;
      Scanner rio = new Scanner(System.in);
      sala = rio.nextFloat();					

      System.out.println("=========");
      System.out.println("| IDADE |");
      System.out.println("=========");
      int idade = 0;
      Scanner de = new Scanner(System.in);
      idade = de.nextInt();

      System.out.println("=======");
      System.out.println("| CPF |");
      System.out.println("=======");
      String cpf;
      Scanner fpc = new Scanner(System.in);
      cpf = fpc.nextLine();

      System.out.println("===================");
      System.out.println("| SENHA DE ACESSO |");
      System.out.println("===================");
      int senha;
      Scanner nha = new Scanner(System.in);
      senha = nha.nextInt();


      String sql = "INSERT INTO funcionario (nome , departamneto , salario, idade, cpf, senha) VALUES " + "(" + "'" + nomep + "'" + "," + "'" + departamento + "'"+"," + "'" + sala + "'" + ","+"'"+ idade + "'" + "," + "'" + cpf + "'" + "," + "'" + senha +"'"+ ")";

      PreparedStatement stmt = connection.prepareStatement(sql);







      stmt.execute(); //executa comando   
      stmt.close();    

    } catch (SQLException u) {    
      throw new RuntimeException(u);    
    }    
  }

  public void consulta() {
    //consultar funcionarios//

  for(;; ) {
    Statement s = null;


    try {
      System.out.println("================");
      System.out.println("| DIGITE O CPF |");
      System.out.println("================");

      String cpfop;
      Scanner ops = new Scanner(System.in);
      cpfop = ops.nextLine();

      s = (Statement) connection.createStatement();
      ResultSet r = null;
      r = s.executeQuery("Select * from funcionario WHERE cpf =" + " " + cpfop );



      if (!r.isBeforeFirst() ) {    
          System.out.println("======================");
          System.out.println("|   CPF INVALIDO     |");
          System.out.println("======================");
          System.out.println("| RETORNANDO AO MENU |");
          System.out.println("======================");
          break;
      }



      while (r.next()) {
        System.out.println("===============================================================================================================");
        System.out.println("|" + r.getString("nome") + " \n "+"CPF: " + r.getString("cpf") + " \n "+"DEPARTAMENTO: " + r.getString("departamneto") + " \n "+"SALARIO: " + r.getBigDecimal("salario")+" \n "+"IDADE: "+r.getInt("idade")+" \n "+"SENHA: "+r.getString("senha")+":");
        System.out.println("===============================================================================================================");
      }

      r.close();
      s.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("===============================");
    System.out.println("| DESEJA CONSULTAR OUTRO CPF? |");
    System.out.println("===============================");
    System.out.println("1 = SIM                       |");
    System.out.println("2 = NÂO                       |");
    System.out.println("===============================");
    int fim;
    Scanner fimfim = new Scanner(System.in);
    fim = fimfim.nextInt();

    if(fim == 1) {
      System.out.println("======================");
      System.out.println("| DIGITE UM NOVO CPF |");
      System.out.println("======================");
    }
    if (fim == 2) {
      break;
    }

    }


  }

  public void consulp() {
    //consultar produtos//
    for(;;) {
      System.out.println("=================");
      System.out.println("| ID DO PRODUTO |");
      System.out.println("=================");
      int idp;
      Scanner mp = new Scanner(System.in);
      idp = mp.nextInt();

      Statement s = null;

      try {
        s = (Statement) connection.createStatement();
        ResultSet r = null;
        r = s.executeQuery("Select * from produto WHERE idproduto =" + idp +  ";" );

        if (!r.isBeforeFirst() ) {    
            System.out.println("======================");
            System.out.println("|    ID INVALIDO     |");
            System.out.println("======================");

        } 


        while (r.next()) {
          System.out.println("===============================================================================================================");
          System.out.println("|" + "ID: " + r.getString("idproduto") + " : "+"NOME: " + r.getString("nomepp") + " : "+"PREÇO: " + r.getFloat("preco") + " : "+"FORNECEDOR: " + r.getString("fornecedor")+" : "+"MARCA: "+r.getString("MARCA") + " : " + "QUANTIDADE :" + r.getInt("quantidade"));
          System.out.println("===============================================================================================================");
        }

        r.close();
        s.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }






      System.out.println("======================");
      System.out.println("| 1 = CONSULTAR OUTRO|");
      System.out.println("| 2 = SAIR           |");
      System.out.println("======================");


      int opc;
      Scanner ip = new Scanner(System.in);
      opc = ip.nextInt();



      if (opc == 1) {
        System.out.println("=================");
        System.out.println("|  UM NOVO ID   |");
        System.out.println("=================");
      }
      if (opc == 2){
        break;
      }





    }

  }

  public void cadastroProduto() {
    //cadastro de produtos//
    try {

      System.out.println("=====================");	
      System.out.println("| CODIGO DO PRODUTO |");
      System.out.println("=====================");
      int codp;
      Scanner coding = new Scanner(System.in);
      codp = coding.nextInt();

      System.out.println("===================");
      System.out.println("| NOME DO PRODUTO |");
      System.out.println("===================");
      String nomep;
      Scanner noming = new Scanner(System.in);
      nomep = noming.nextLine();

      System.out.println("====================");
      System.out.println("| PREÇO DO PRODUTO |");
      System.out.println("====================");
      float precop;
      Scanner precin = new Scanner(System.in);
      precop = precin.nextFloat();
      
      System.out.println("=========================");
      System.out.println("| QUANTIDADE CADASTRADA |");
      System.out.println("=========================");
      int quantion;
      Scanner estoquin = new Scanner(System.in);
      quantion = estoquin.nextInt();

      System.out.println("=============");
      System.out.println("| DESCRIÇÃO |");
      System.out.println("=============");
      String descricon;
      Scanner descrin = new Scanner(System.in);
      descricon = descrin.nextLine();

      System.out.println("======================");
      System.out.println("| CNPJ do Fornecedor |");
      System.out.println("======================");
      int codigoFor;
      Scanner codingf = new Scanner(System.in);
      codigoFor = codingf.nextInt();

      System.out.println("=========");
      System.out.println("| MARCA |");
      System.out.println("=========");
      String marca;
      Scanner markin = new Scanner(System.in);
      marca = markin.nextLine();

      System.out.println("=======================");
      System.out.println("| CODIGO DA CATEGORIA |");
      System.out.println("=======================");
      String catecoding;
      Scanner insert = new Scanner(System.in);
      catecoding = insert.next();





      String sql = "INSERT INTO produto (idproduto , nomepp , preco, quantidade, descricao, fornecedor, marca, idcategoria) VALUES " + "(" + "'" + codp + "'" + "," + "'" + nomep + "'"+"," + "'" + precop + "'" + ","+ "'" + quantion + "'" + "," + "'"+ descricon + "'" + "," + "'" + codigoFor + "'" + "," + "'" + marca +"'"+" , " + "'" + catecoding + "'"+ ")";

      PreparedStatement stmt = connection.prepareStatement(sql);







      stmt.execute(); //executa comando   
      stmt.close();   //fechando conecção


    } catch (SQLException u) {    
      throw new RuntimeException(u);    
    }




  }

  public void consulcategoria() {
    //adicionando ou consultando categotia//
  for (;;) {  
    System.out.println("====================================");
    System.out.println("| ADICIONAR OU CONSULTAR CATEGORIA |");
    System.out.println("====================================");
    System.out.println("| 1 = CONSULTAR                    |");
    System.out.println("| 2 = ADICIONAR                    |");
    System.out.println("====================================");
    int edit;
    Scanner editon = new Scanner(System.in);
    edit = editon.nextInt();

    if (edit ==1) {



      Statement s = null;

      try {
        s = (Statement) connection.createStatement();
        ResultSet r = null;
        r = s.executeQuery("Select * from categoriaproduto ;");


        while (r.next()) {
          System.out.println("===============================================================================================================");
          System.out.println("|" + r.getString("idcategoria") + " : "+"NOME: " + r.getString("nomec") + " : "+"DETALHES: " + r.getString("detalhes") + " : "+"CODIGO PRODUTOS: " + r.getString("idprodutos"));
          System.out.println("===============================================================================================================");
        }

        r.close();
        s.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }


    } 
    if(edit == 2) {

      try {

      System.out.println("=======================");
      System.out.println("| CODIGO DA CATEGORIA |");
      System.out.println("=======================");
      int codcat;
      Scanner cadingc = new Scanner(System.in);
      codcat = cadingc.nextInt();

      System.out.println("========");
      System.out.println("| NOME |");
      System.out.println("=========");
      String nomescat;
      Scanner nomin = new Scanner(System.in);
      nomescat = nomin.next();

      System.out.println("============");
      System.out.println("| DETALHES |");
      System.out.println("============");
      String detalhes;
      Scanner delhes = new Scanner(System.in);
      detalhes = delhes.next();



      String sql = "INSERT INTO categoriaproduto (idcategoria , nomec , detalhes) VALUES " + "(" + "'" + codcat + "'" + "," + "'" + nomescat + "'"+"," + "'" + detalhes + "'" + ")";

      PreparedStatement stmt = connection.prepareStatement(sql);

     System.out.println("======================");
     System.out.println("| CRIADO COM SUCESSO |");
     System.out.println("======================");




      stmt.execute(); //executa comando   
      stmt.close();    


    } catch (SQLException u) {    
      throw new RuntimeException(u);    
    }

    }
    System.out.println("=========================");
    System.out.println("| DESEJA VOLTAR AO MENU |");
    System.out.println("|1 = SIM                |");
    System.out.println("|2 = NÃO                |");
    System.out.println("=========================");
    int menum;
    Scanner volrar = new Scanner(System.in);
    menum = volrar.nextInt();

    if(menum == 1) {
      System.out.println("====================");
      System.out.println("| VOLTANDO AO MENU |");
      System.out.println("====================");
      break;
    }
    if(menum == 2) {
      System.out.println("=======================");
      System.out.println("| SELECIONE UMA OPÇÃO |");
      System.out.println("=======================");
    }

  }
}

  public void vender() {
    //realizando a venda dos produtos//
    for(; ; ) {
        System.out.println("======================");
        System.out.println("| VENDA DOS PRODUTOS |");
        System.out.println("|     FAÇA O LOGIN   |");
        System.out.println("======================");

        System.out.println("===========");
        System.out.println("| SEU CPF |");
        System.out.println("===========");
        String cpflogin;
        Scanner loginv = new Scanner(System.in);
        cpflogin = loginv.next();

        System.out.println("==============");
        System.out.println("| SUA  SENHA |");
        System.out.println("==============");
        int senhal;
        Scanner senhalogin = new Scanner(System.in);
        senhal = senhalogin.nextInt();


        Statement s = null;
        try {

      s = (Statement) connection.createStatement();
      ResultSet r = null;

      r = s.executeQuery("Select * from funcionario WHERE cpf" + " = " + cpflogin + " && " + "senha" + " = " + senhal ); //espeficiar o tipo de consulta para o valor ser certo 






      if (!r.isBeforeFirst() ) {    
          System.out.println("======================");
          System.out.println("|  LOGIN INVALIDO    |");
          System.out.println("======================");
          System.out.println("| RETORNADO AO MENU  |");
          System.out.println("======================");
          break;
      } 

      while (r.next()) {
        System.out.println("=================================================================================================================");
        System.out.println("|                                LOGIN REALIZADO COM SUCESSO                                                    |");
        System.out.println("=================================================================================================================");
        System.out.println("|" + r.getString("nome") + " : "+"CPF: " + r.getString("cpf") + " : ");
        System.out.println("=================================================================================================================");
      }

      r.close();
      s.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

        for(; ;) {

        System.out.println("======================");
        System.out.println("| VENDA DOS PRODUTOS |");
        System.out.println("======================");

        System.out.println("=================");
        System.out.println("| ID DO PRODUTO |");
        System.out.println("=================");
        int idprodution;
        Scanner vender = new Scanner(System.in);
        idprodution = vender.nextInt();

        System.out.println("==============");
        System.out.println("| QUANTIDADE |");
        System.out.println("==============");
        int quanton = 1;
        Scanner qantin = new Scanner(System.in);
        quanton = qantin.nextInt();

        Statement s1 = null;
        try {

      s1 = (Statement) connection.createStatement();
      ResultSet r = null;

      r = s1.executeQuery("Select * from produto WHERE idproduto" + " = " + idprodution + ";"  ); //espeficiar o tipo de consulta para o valor ser certo 






      if (!r.isBeforeFirst() ) {    
          System.out.println("==============================");
          System.out.println("| NÂO EXISTE ESSE PRODUTO    |");
          System.out.println("==============================");
          System.out.println("| DIGITE UM CODIGO VALIDO    |");
          System.out.println("==============================");

      } 

      while (r.next()) {
      float total = r.getFloat("preco") * quanton;
        System.out.println("============================================================================================================");
        System.out.println("|                        ADICIONANDO AO CARRINHO DE VENDAS                                                 |");
        System.out.println("|                            CNPJ:11.331.464/0001-05                                                       |");
        System.out.println("============================================================================================================");
        System.out.println("|" + r.getString("nomepp") + " : "+"PREÇO: " + r.getFloat("preco") + " : ");
        System.out.println("============================================================================================================");
        System.out.println("TOTAL:" +  " " + total + ":" + " " + "QUANTIDADE: " + " " + quanton + " : ");
        System.out.println("============================================================================================================");
        System.out.println("\n");

        try {    

            String sql = "INSERT INTO resumovendas (nomes , precoss, idproduros, estado ) VALUES " + "(" + "'" + r.getString("nomepp") + "'" + "," + "'" + r.getFloat("preco") + "'" + "," + quanton  + "," + "'" + "pago" +"'" + ")";

            PreparedStatement stmt = connection.prepareStatement(sql);




            stmt.execute(); //executa comando   
            stmt.close();    

          } catch (SQLException u) {    
            throw new RuntimeException(u);    
          }        

        try {    

            String sql = "UPDATE produto SET quantidade = quantidade - " + quanton + " WHERE idproduto = " + r.getString("idproduto") ;

            PreparedStatement stmt = connection.prepareStatement(sql);




            stmt.execute(); //executa comando   
            stmt.close();    

          } catch (SQLException u) {    
            throw new RuntimeException(u);    
          }


      }



      r.close();
      s1.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
        System.out.println("=====================");
        System.out.println("| CONTINUAR A VENDA |");
        System.out.println("| 1 = SIM           |");
        System.out.println("| 2 = NÃO           |");
        System.out.println("=====================");

        int conte;
        Scanner ns = new Scanner(System.in);
        conte = ns.nextInt();



        if(conte == 2) {
          Statement s11 = null;





            try {

          s11 = (Statement) connection.createStatement();
          ResultSet r = null;

          System.out.println("==================");  
          System.out.println("| CPF DO CLIENTE |");
          System.out.println("==================");
          String cpfcliente = " ";
          Scanner clicpf = new Scanner(System.in);
          cpfcliente = clicpf.next();

          System.out.println("======================");
          System.out.println("| FORMA DE PAGAMENTO |");
          System.out.println("| 1 = CREDITO        |");
          System.out.println("| 2 = DEBITO         |");
          System.out.println("| 3 = DINHEIRO       |");
          System.out.println("| 4 = PIX            |");
          System.out.println("======================");
          int pagamento ;
          Scanner pagando = new Scanner(System.in);
          pagamento = pagando.nextInt();

          String status = "";
          if (pagamento == 1) {
            status = "Credito";
          }
          if (pagamento == 2) {
            status = "Debito";
          }
          if (pagamento == 3) {
            status = "Dinheiro";
          }
          if (pagamento == 4) {
            status = "PIX";
          }




          r = s11.executeQuery("Select * from resumovendas");
          System.out.println("=================================================================================================================");
          System.out.println("|                                  RESUMO DA VENDA                                                              |");
          System.out.println("|                              CNPJ:11.331.464/0001-05                                                          |");
          System.out.println("|                             CPF CLIENTE:" +cpfcliente+                                                       "|");
          System.out.println("|                            FORMA DE PAGAMENTO:"+status+                                                   "|");
          System.out.println("=================================================================================================================");
          while (r.next()) {  
          System.out.println("|" + r.getString("nomes") + " : "+"PREÇO: " + r.getFloat("precoss") + " : " + "Quantidade: " + r.getInt("idproduros"));
          System.out.println("=================================================================================================================");
            }
          try {
          Statement s12 = (Statement) connection.createStatement();
          ResultSet r1 = null;

          r1 = s12.executeQuery("Select sum(precoss * idproduros) from resumovendas");
          while(r1.next())
          System.out.println("| TOTAL: " + "R$:" + r1.getFloat("sum(precoss * idproduros)") + ":"+"    |");
          System.out.println("=================================================================================================================");

          r1.close();
          s12.close();


          } catch (SQLException e) {
            e.printStackTrace();
          }


            r.close();
            s11.close();


          } catch (SQLException e) {
            e.printStackTrace();
          }


          break;

        }else {
          System.out.println("=======================");
          System.out.println("| DIGITE OPÇÃO VALIDA |");
          System.out.println("=======================");


        }



        }
        break;
  }
}

  public void fornecedor() {
    //cadatro de fornecedor//
  try {

  System.out.println("========");
  System.out.println("| CNPJ |");
  System.out.println("========");
  String cnpj;
  Scanner pj = new Scanner(System.in);
  cnpj = pj.nextLine();

  System.out.println("========");
  System.out.println("| NOME |");
  System.out.println("========");
  String nomepj;
  Scanner pjnome = new Scanner(System.in);
  nomepj = pjnome.nextLine();

  System.out.println("============");
  System.out.println("| ENDEREÇO |");
  System.out.println("============");
  String edereco;
  Scanner reco = new Scanner(System.in);
  edereco = reco.nextLine();

  System.out.println("============");
  System.out.println("| TELEFONE |");
  System.out.println("============");
  String tele;
  Scanner lete = new Scanner(System.in);
  tele = lete.nextLine();

   String sql = "INSERT INTO fornecedor (cnpj , nomefn , endereco, telefone) VALUES " + "(" + "'" + cnpj + "'" + "," + "'" + nomepj + "'"+"," + "'" + edereco + "'" + ","+"'"+ tele + "'" + ")";

     PreparedStatement stmt = connection.prepareStatement(sql);







     stmt.execute(); //executa comando   
     stmt.close();




   } catch (SQLException u) {    
     throw new RuntimeException(u);    
   }

  System.out.println("=================================");
  System.out.println("| FORCENEDOR CRIADO COM SUCESSO |");
  System.out.println("=================================");

}

  public void cosultafornecedor() {
    //consultadno o forncedor//
  for (;;) {
  System.out.println("========");
  System.out.println("| CNPJ |");
  System.out.println("========");
  String cnpjoto;
  Scanner joto = new Scanner(System.in);
  cnpjoto = joto.nextLine();	

    Statement s = null;


    try {
      s = (Statement) connection.createStatement();
      ResultSet r = null;
      r = s.executeQuery("Select * from fornecedor,produto WHERE cnpj = " + cnpjoto + " AND " + "fornecedor = " + cnpjoto );



      if (!r.isBeforeFirst() ) {    
          System.out.println("==================================================");
          System.out.println("| NÃO EXISTE PRODUTO CADASTRATO NESSE FORNECEDOR |");
          System.out.println("| OU O MESMO NÃO EXISTE NA BASE DE DADOS         |");
          System.out.println("==================================================");  

      } 




      while (r.next()) {
        System.out.println("===========================================================================================================================");
        System.out.println("|" + r.getString("cnpj") + " : "+"NOME: " + r.getString("nomefn") + " : "+"TELEFONE: " + r.getString("telefone") + " : " + "ENDEREÇO: " + r.getString("endereco")+" : " + "CODIGO PRODUTOS: " + r.getString("idproduto")+" : "+ "NOME DO PRODUTO: " + r.getString("nomepp") + " : ");
        System.out.println("===========================================================================================================================");
      }

      r.close();
      s.close();


    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("===========================");
    System.out.println("| DESEJA CONSULTAR OUTRO? |");
    System.out.println("===========================");
    System.out.println("|1 = SIM                  |");
    System.out.println("|2 = NÃO                  |");
    System.out.println("===========================");
    int putros;
    Scanner outrin = new Scanner(System.in);
    putros = outrin.nextInt();

    if (putros == 1) {
      System.out.println("=====================");
      System.out.println("| DIGITE OUTRO CNPJ |");
      System.out.println("=====================");
    }
   if (putros == 2) {
     System.out.println("===================");
     System.out.println("| FIM DA CONSULTA |");
     System.out.println("===================");
     break;
   }


  }
}

  public void departamentoss() {
    //consultando o departamento//

  for (;;) {	  
  System.out.println("=============================");
  System.out.println("| CONSULTANDO DEPARTAMENTOS  ");
  System.out.println("=============================");

   try {
  Statement s = (Statement) connection.createStatement();
    ResultSet r = null;
    r = s.executeQuery("Select * from departamento ;");

    while (r.next()) {
        System.out.println("===============================================================================================================");
        System.out.println("|" + r.getString("nomedp") + " \n "+"CODIGO: " + r.getString("codigodp") + " \n "+"SALA: " + r.getString("sala") );
        System.out.println("===============================================================================================================");
      }

      r.close();
      s.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
   System.out.println("============================");
   System.out.println("|  DESEJA VOLTAR AO MENU?  |");
   System.out.println("============================");
   System.out.println("|1 = NÃO                   |");
   System.out.println("|2 = SIM                   |");
   System.out.println("============================");
   int opst;
   Scanner tis = new Scanner(System.in);
   opst = tis.nextInt();

   if(opst == 1) {
     System.out.println("=======================");
     System.out.println("|    CARREGANDO...    |");
     System.out.println("=======================");
   }
  if(opst == 2) {
    System.out.println("================");
    System.out.println("| FIM CONSULTA |");
    System.out.println("================");
    break;
  }

  }
}

  public void fimregistros() {
    //eliminando os registro de compras ma tabela ResumoVendas//

  try {
  String sql = "DELETE FROM resumovendas WHERE estado = 'pago' " ;

    PreparedStatement stmt = connection.prepareStatement(sql);







    stmt.execute(); //executa comando   
    stmt.close();    

  } catch (SQLException u) {    
    throw new RuntimeException(u);    
  }

}

 public void fimapresenta() {
   //Apresentação dos colaboradores//
  System.out.println("//=========================================================================================================//");
  System.out.println("//AUTORES: Brendo Garcia da Silva, Adryan Felipe Nascimento de Alburquerque, Davi Dionisio Carvalho Nunes. //");
  System.out.println("//                                                                                                         //");
  System.out.println("//VERSÃO: 1.0.0                                                                                            //");
  System.out.println("//                                                                                                         //");
  System.out.println("//FERRAMENTAS: Eclipse (IDE), Mysql Workbench(Cliente DB) e db4free.net(Servido do Banco de dados)         //");
  System.out.println("//=========================================================================================================//");
 }

 public void loginSistema() {
   //login no inicio do sistema
   for(;;) {
   System.out.println("===========================");
   System.out.println("| FAÇA O LOGIN NO SISTEMA |");
   System.out.println("===========================");
   System.out.println("===========================");
   System.out.println("|         SEU CPF         |");
   System.out.println("===========================");

   String cpflong;
   Scanner login = new Scanner(System.in);
   cpflong = login.next();

   System.out.println("===========================");
   System.out.println("|        SUA SENHA        |");
   System.out.println("===========================");

   String senhalogin;
   Scanner logon = new Scanner(System.in);
   senhalogin = logon.next();

   Statement s = null;
     try {

   s = (Statement) connection.createStatement();
   ResultSet r = null;

   r = s.executeQuery("Select * from funcionario WHERE cpf" + " = " + cpflong + " && " + "senha" + " = " + senhalogin ); //espeficiar o tipo de consulta para o valor ser certo 



   if (!r.isBeforeFirst() ) {    
       System.out.println("=====================================");
       System.out.println("|            LOGIN INVALIDO         |");
       System.out.println("=====================================");
       System.out.println("|   TENTE NOVAMENTE EM 5 SEGUNDOS   |");
       System.out.println("=====================================");
       acessomysql loginsistem = new acessomysql();
       loginsistem.conectar();
       loginsistem.loginSistema();
   }

   while (r.next()) {
     System.out.println("=================================================================================================================");
     System.out.println("|                                LOGIN REALIZADO COM SUCESSO                                                    |");
     System.out.println("=================================================================================================================");
     System.out.println("|" + r.getString("nome") + " : "+"CPF: " + r.getString("cpf") + " : ");
     System.out.println("=================================================================================================================");
     System.out.println("======================");
     System.out.println("| CARREGANDO SISTEMA |");
     System.out.println("======================");
   }

   r.close();
   s.close();


 } catch (SQLException e) {
   e.printStackTrace();
 }
     break;
   } 

 }

}
