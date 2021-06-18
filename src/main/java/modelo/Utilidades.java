/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author SergioCaballeroSáez
 */
public class Utilidades {

    public static ArrayList<String> llenarLista() {
        ArrayList<String> meses = new ArrayList();
        int item = 12;
        for (int i = 0; i < 15; i++) {
            meses.add(String.valueOf(item));
            item = item + 12;
        }
        return meses;
    }
    
    public static ArrayList<Cuota> generaListaCuotas(int numCuotas, double importeTotalPrestamo){
        ArrayList<Cuota> cuotas = new ArrayList();
        for (int i = 1; i <= numCuotas; i++) {
            Cuota tmp = new Cuota();
            tmp.setNumeroCuota(i);
            tmp.setImporteCuota(importeTotalPrestamo/numCuotas);
            tmp.setIntereses(tmp.getImporteCuota()-(tmp.getImporteCuota()*(i-1)/numCuotas));
            tmp.setCapital(tmp.getImporteCuota()-tmp.getIntereses());
            cuotas.add(tmp);
        }
        
        return cuotas;
    }

}
