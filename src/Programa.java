import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Programa {
    public static void main(String[] args) {
        ArrayList<SegmentoT> listaSegmentoT = new ArrayList<>();
        ArrayList<SegmentoU> listaSegmentoU = new ArrayList<>();

        try(BufferedReader bf = Files.newBufferedReader(Paths.get("temp/retorno.ret"))){
            while (bf.ready()){
                String line = bf.readLine();
                if (line.charAt(13) == 'T'){
                    String campo01 = line.substring(0, 3);
                    String campo02 = line.substring(3, 7);
                    String campo03 = line.substring(7, 8);
                    String campo04 = line.substring(8, 13);
                    String campo05 = line.substring(13, 14);
                    String campo06 = line.substring(14, 15);
                    String campo07 = line.substring(15, 17);
                    String campo08 = line.substring(17, 22);
                    String campo09 = line.substring(22, 23);
                    String campo10 = line.substring(23, 35);
                    String campo11 = line.substring(35, 36);
                    String campo12 = line.substring(36, 37);
                    String campo13 = line.substring(37, 57);
                    String campo14 = line.substring(57, 58);
                    String campo15 = line.substring(58, 73);
                    String campo16 = line.substring(73, 81);
                    Double campo17 = Double.parseDouble(line.substring(81, 96)) / 100;
                    String campo18 = line.substring(96, 99);
                    String campo19 = line.substring(99, 104);
                    String campo20 = line.substring(104, 105);
                    String campo21 = line.substring(105, 130);
                    String campo22 = line.substring(130, 132);
                    String campo23 = line.substring(132, 133);
                    String campo24 = line.substring(133, 148);
                    String campo25 = line.substring(148, 188);
                    String campo26 = line.substring(188, 198);
                    Double campo27 = Double.parseDouble(line.substring(198, 213)) / 100;
                    String campo28 = line.substring(213, 223);
                    String campo29 = line.substring(223, 240);

                    listaSegmentoT.add(new SegmentoT(campo01, campo02, campo03, campo04, campo05,
                            campo06, campo07, campo08, campo09, campo10, campo11, campo12, campo13,
                            campo14, campo15, campo16, campo17, campo18, campo19, campo20, campo21,
                            campo22, campo23, campo24, campo25, campo26, campo27, campo28, campo29));
                }else if(line.charAt(13) == 'U'){
                    String campo01 = line.substring(0, 3);
                    String campo02 = line.substring(3, 7);
                    String campo03 = line.substring(7, 8);
                    String campo04 = line.substring(8, 13);
                    String campo05 = line.substring(13, 14);
                    String campo06 = line.substring(14, 15);
                    String campo07 = line.substring(15, 17);
                    Double campo08 = Double.parseDouble(line.substring(17, 32)) / 100;
                    Double campo09 = Double.parseDouble(line.substring(32, 47)) / 100;
                    Double campo10 = Double.parseDouble(line.substring(47, 62)) / 100;
                    Double campo11 = Double.parseDouble(line.substring(62, 77)) / 100;
                    Double campo12 = Double.parseDouble(line.substring(77, 92)) / 100;
                    Double campo13 = Double.parseDouble(line.substring(92, 107)) / 100;
                    Double campo14 = Double.parseDouble(line.substring(107, 122)) / 100;
                    Double campo15 = Double.parseDouble(line.substring(122, 137)) / 100;
                    String campo16 = line.substring(137, 145);
                    String campo17 = line.substring(145, 153);
                    String campo18 = line.substring(153, 157);
                    String campo19 = line.substring(157, 165);
                    Double campo20 = Double.parseDouble(line.substring(165, 180)) / 100;
                    String campo21 = line.substring(180, 210);
                    String campo22 = line.substring(210, 213);
                    String campo23 = line.substring(213, 233);
                    String campo24 = line.substring(233, 240);

                    listaSegmentoU.add(new SegmentoU(campo01, campo02, campo03, campo04, campo05,
                            campo06, campo07, campo08, campo09, campo10, campo11, campo12, campo13,
                            campo14, campo15, campo16, campo17, campo18, campo19, campo20, campo21,
                            campo22, campo23, campo24));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(".\\temp\\segmentoT.csv"))){
            String conteudo = "Codigo do Banco na Compensacao" +
                    ";Lote de Servico" +
                    ";Tipo de Registro" +
                    ";Numero Sequencial Registro no Lote" +
                    ";Segmento do Registro Detalhe" +
                    ";Uso Exclusivo FEBRABAN/CNAB" +
                    ";Codigo de Movimento Retorno" +
                    ";Agencia Mantenedora da Conta" +
                    ";Digito Verificador da Agencia" +
                    ";Numero da Conta Corrente" +
                    ";Digito Verificador da Conta" +
                    ";Digito Verificador da Ag/Conta" +
                    ";Identificacao do Titulo" +
                    ";Codigo da Carteira" +
                    ";Numero do Documento de Cobranca" +
                    ";Data do Vencimento do Titulo" +
                    ";Valor Nominal do Titulo" +
                    ";Numero do Banco" +
                    ";Agencia Cobradora/Recebedora" +
                    ";Digito Verificador da Agencia" +
                    ";Identificacao do Titulo na Empresa" +
                    ";Codigo da Moeda" +
                    ";Tipo de Inscricao" +
                    ";Numero de Inscricao" +
                    ";Nome" +
                    ";N do Contr. da Operacao de Credito" +
                    ";Valor da Tarifa / Custas" +
                    ";Identificacao para Rejeicoes, Tarifas, Custas, Liquidacao e Baixas" +
                    ";Uso Exclusivo FEBRABAN/CNAB";

            for (SegmentoT segmentoT:
                 listaSegmentoT) {
                conteudo += "\n" +
                segmentoT.getCampo01() + ";"
                        + segmentoT.getCampo02() + ";"
                        + segmentoT.getCampo03() + ";"
                        + segmentoT.getCampo04() + ";"
                        + segmentoT.getCampo05() + ";"
                        + segmentoT.getCampo06() + ";"
                        + segmentoT.getCampo07() + ";"
                        + segmentoT.getCampo08() + ";"
                        + segmentoT.getCampo09() + ";"
                        + segmentoT.getCampo10() + ";"
                        + segmentoT.getCampo11() + ";"
                        + segmentoT.getCampo12() + ";"
                        + segmentoT.getCampo13() + ";"
                        + segmentoT.getCampo14() + ";"
                        + segmentoT.getCampo15() + ";"
                        + segmentoT.getCampo16() + ";"
                        + segmentoT.getCampo17() + ";"
                        + segmentoT.getCampo18() + ";"
                        + segmentoT.getCampo19() + ";"
                        + segmentoT.getCampo20() + ";"
                        + segmentoT.getCampo21() + ";"
                        + segmentoT.getCampo22() + ";"
                        + segmentoT.getCampo23() + ";"
                        + segmentoT.getCampo24() + ";"
                        + segmentoT.getCampo25() + ";"
                        + segmentoT.getCampo26() + ";"
                        + segmentoT.getCampo27() + ";"
                        + segmentoT.getCampo28() + ";"
                        + segmentoT.getCampo29();

            }

            bw.write(conteudo);

        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(".\\temp\\segmentoU.csv"))){
            String conteudo = "Código do Banco na Compensação" +
                    ";Lote de Servico" +
                    ";Tipo de Registro" +
                    ";N Sequencial do Registro no Lote" +
                    ";Cod. Segmento do Registro Detalhe" +
                    ";Uso Exclusivo FEBRABAN/CNAB" +
                    ";Codigo de Movimento Retorno" +
                    ";Juros / Multa / Encargos" +
                    ";Valor do Desconto Concedido" +
                    ";Valor do Abat. Concedido/Cancel." +
                    ";Valor do IOF Recolhido" +
                    ";Valor Pago pelo Pagador" +
                    ";Valor Liquido a ser Creditado" +
                    ";Valor de Outras Despesas" +
                    ";Valor de Outros Creditos" +
                    ";Data da Ocorrencia" +
                    ";Data da Efetivacao do Credito" +
                    ";Codigo da Ocorrencia" +
                    ";Data da Ocorrencia" +
                    ";Valor da Ocorrencia" +
                    ";Complem. da Ocorrencia" +
                    ";Cod. Banco Correspondente Compens." +
                    ";Nosso N Banco Correspondente" +
                    ";Uso Exclusivo FEBRABAN/CNAB";

            for (SegmentoU segmentoU:
                    listaSegmentoU) {
                conteudo += "\n" +
                        segmentoU.getCampo01() + ";"
                        + segmentoU.getCampo02() + ";"
                        + segmentoU.getCampo03() + ";"
                        + segmentoU.getCampo04() + ";"
                        + segmentoU.getCampo05() + ";"
                        + segmentoU.getCampo06() + ";"
                        + segmentoU.getCampo07() + ";"
                        + segmentoU.getCampo08() + ";"
                        + segmentoU.getCampo09() + ";"
                        + segmentoU.getCampo10() + ";"
                        + segmentoU.getCampo11() + ";"
                        + segmentoU.getCampo12() + ";"
                        + segmentoU.getCampo13() + ";"
                        + segmentoU.getCampo14() + ";"
                        + segmentoU.getCampo15() + ";"
                        + segmentoU.getCampo16() + ";"
                        + segmentoU.getCampo17() + ";"
                        + segmentoU.getCampo18() + ";"
                        + segmentoU.getCampo19() + ";"
                        + segmentoU.getCampo20() + ";"
                        + segmentoU.getCampo21() + ";"
                        + segmentoU.getCampo22() + ";"
                        + segmentoU.getCampo23() + ";"
                        + segmentoU.getCampo24();

            }

            bw.write(conteudo);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
