/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.ChevroletCarroFactory;
import fabricaautomoveis.FiatCarroFactory;
import fabricaautomoveis.VWCarroFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", new ChevroletCarroFactory());
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    alterarMarcaFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Alterar marca da franquia");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }
    /*
     * Método para alterar a marca da concessionaria
     */
    private void alterarMarcaFranquia() {
        System.out.println("Digite qual será a nova marca da franquia, 1: VW, 2: FIAT, 3: CHEVROLET");
        boolean deuCerto = false;        
        do {    
            try{
                Marca marca = Marca.peloID(Integer.parseInt(entrada.nextLine()));
                switch(marca){
                    case VW:
                        ppooVeiculos.alterarMarcaFranquia(new VWCarroFactory());
                        break;
                    case FIAT:
                        ppooVeiculos.alterarMarcaFranquia(new FiatCarroFactory());
                        break;
                    case CHEVROLET:
                        ppooVeiculos.alterarMarcaFranquia(new ChevroletCarroFactory());
                        break;
                }
                System.out.println("Marca da franquia alterada para " + marca);
                deuCerto = true;
            }catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Digite um valor válido. 1: VW, 2: FIAT, 3: CHEVROLET");
            }
        } while (!deuCerto);


    }

    private void esperarTecla() {
        entrada.nextLine();
    }
}

