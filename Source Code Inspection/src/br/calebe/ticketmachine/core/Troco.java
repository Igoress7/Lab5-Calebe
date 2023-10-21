package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        
        int count = 0;
        int resto = 0;

        if(valor / 100 != 0){ //Corrigido
            if(valor % 100 != 0){
                resto = valor % 100;
                valor = valor - resto;
            }
            count = valor / 100;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        
        count = 0;
        valor = resto;
        
        if(valor / 50 != 0){ //Corrigido
            if(valor % 50 != 0){
                resto = valor % 50;
                valor = valor - resto;
            }
            count = valor / 50;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        
        count = 0;
        valor = resto;

        if(valor / 20 != 0){ //Corrigido
            if(valor % 20 != 0){
                resto = valor % 20;
                valor = valor - resto;
            }
            count = valor / 20;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        
        count = 0;
        valor = resto;

        if(valor / 10 != 0){ //Corrigido
            if(valor % 10 != 0){
                resto = valor % 10;
                valor = valor - resto;
            }
            count = valor / 10;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        
        count = 0;
        valor = resto;

        if(valor / 5 != 0){ //Corrigido
            if(valor % 5 != 0){
                resto = valor % 5;
                valor = valor - resto;
            }
            count = valor / 5;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        
        count = 0;
        valor = resto;

        if(valor / 100 != 0){ //Corrigido
            if(valor % 100 != 0){
                resto = valor % 100;
                valor = valor - resto;
            }
            count = valor / 100;
        }  
        papeisMoeda[0] = new PapelMoeda(2, count);//Corrigido
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 0; i < 6; i++) {//Corrigido
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 0; i < 6 && ret == null; i++) {//Corrigido Issue Ret e Loop Infinito
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
