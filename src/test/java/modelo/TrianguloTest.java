package modelo;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.ExcepcionTrianguloNoCreado;

import org.junit.jupiter.api.BeforeAll;


public class TrianguloTest {

    static double ladoA, ladoB, ladoC; 
    static String tipoEsperado;
    static double areaEsperada; 

    static Triangulo triangulo;
    
    @BeforeAll
    public static void setUpClass() throws ExcepcionTrianguloNoCreado{
        ladoA = 3;
        ladoB = 4;
        ladoC = 5;
        triangulo = new Triangulo(ladoA, ladoB, ladoC);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach 
    public void tearDown() throws ExcepcionTrianguloNoCreado{
        ladoA = 3;
        ladoB = 4;
        ladoC = 5;
        triangulo = new Triangulo(ladoA, ladoB, ladoC);
    }


    // Pruebas del construcor


    // Pruebas del metodo calcularArea

    
    // Pruebas del metodo esTriangulo

    @Test 
    public void trianguloTresLadosIguales() throws ExcepcionTrianguloNoCreado{
        ladoA = ladoB = ladoC = 3;
        triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloDosLadosIgualesValido() throws ExcepcionTrianguloNoCreado{
        ladoA = ladoB = 5;
        ladoC = 2;
        triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloDosLadosIgualesError() throws ExcepcionTrianguloNoCreado{
        ladoA = ladoB = 2;
        ladoC = 5;
        triangulo = new Triangulo();
        assertFalse(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloLadosDiferentesValido() throws ExcepcionTrianguloNoCreado{
        triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloLadosDiferentesError() throws ExcepcionTrianguloNoCreado{
        ladoA = 1;
        ladoB = 2;
        ladoC = 3;
        triangulo = new Triangulo();
        assertFalse(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    // Pruebas del metodo identificarTipo

    @Test 
    public void trianguloEquilatero() throws ExcepcionTrianguloNoCreado{
        ladoA = ladoB = ladoC = 5;
        triangulo = new Triangulo(ladoA, ladoB, ladoC);
        tipoEsperado = "Equilátero";
        triangulo.identificarTipo();
        assertEquals(tipoEsperado, triangulo.getTipo());
    }

    @Test 
    public void trianguloIsosceles() throws ExcepcionTrianguloNoCreado{
        ladoA = ladoB = 5;
        ladoC = 3;
        triangulo = new Triangulo(ladoA, ladoB, ladoC);
        tipoEsperado = "Isósceles";
        triangulo.identificarTipo();
        assertEquals(tipoEsperado, triangulo.getTipo());
    }

    @Test 
    public void trianguloEscaleno() throws ExcepcionTrianguloNoCreado{
        triangulo = new Triangulo(ladoA, ladoB, ladoC);
        tipoEsperado = "Escaleno";
        triangulo.identificarTipo();
        assertEquals(tipoEsperado, triangulo.getTipo());
    }

    
}
