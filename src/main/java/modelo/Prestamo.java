    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author SergioCaballeroSáez
 */
public class Prestamo {
    private double capital,interes;
    private int tiempo;
    private double importePrestamo;

    public Prestamo() {
    }

    public Prestamo(double capital, double interes, int tiempo) {
        this.capital = capital;
        this.interes = interes;
        this.tiempo = tiempo;
        
        this.importePrestamo = ((capital*interes*tiempo)/1200) + capital;
        
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getImportePrestamo() {
        return importePrestamo;
    }

    public void setImportePrestamo(double importePrestamo) {
        this.importePrestamo = importePrestamo;
    }
    
    
    
    
}
