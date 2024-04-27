package modelo;

import excepciones.ExcepcionTrianguloNoCreado;

/**
 *
 * @author Grupo 5
 */
public class Triangulo {

    private int ladoA, ladoB, ladoC;
    private String tipo;

    public Triangulo(){
        
    }

    public Triangulo(int ladoA,int  ladoB, int ladoC) throws ExcepcionTrianguloNoCreado {
        if (esTriangulo(ladoA, ladoB, ladoC)) {
            this.ladoA = ladoA;
            this.ladoB = ladoB;
            this.ladoC = ladoC;
            identificarTipo();
            System.out.println(tipo);
        } else{
            throw new ExcepcionTrianguloNoCreado("Error: no se creó el triángulo. Los lados proporcionados no pueden formar un triángulo.");
        }
    }


    public void identificarTipo() {
        if (this.ladoA == this.ladoB && this.ladoB == this.ladoC && this.ladoA == this.ladoC) {
            this.tipo = "Equilátero";
        } else if (this.ladoA == this.ladoB || this.ladoB == this.ladoC || this.ladoA == this.ladoC) {
            this.tipo = "Isósceles";
        } else {
            this.tipo = "Escaleno";
        }
    }

    public boolean esTriangulo(double ladoA, double ladoB, double ladoC){
        if(ladoA + ladoB > ladoC && ladoA + ladoC > ladoB && ladoB + ladoC > ladoA){
             return true;
        }else{
            return false;
        }
    }

    public double getLado1() {
        return ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public double getladoC() {
        return ladoC;
    }

    public String getTipo() {
        return tipo;
    }

    public void setLado1(int ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    public void setladoC(int ladoC) {
        this.ladoC = ladoC;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
