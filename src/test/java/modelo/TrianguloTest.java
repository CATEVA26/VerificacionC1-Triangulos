package modelo;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.ExcepcionTrianguloNoCreado;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;


public class TrianguloTest {

    static int ladoA, ladoB, ladoC;
    static String tipoEsperado;
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
    
    @Test
    public void testConstructorConLadosValidos() throws ExcepcionTrianguloNoCreado {
        // CP 1
        ladoA =(int)3.0;
        ladoB =(int)4.0;
        ladoC =(int)5.0;

        triangulo = new Triangulo(ladoA, ladoB, ladoC);

        assertNotNull(triangulo);
        assertEquals(ladoA, triangulo.getLado1(), 0.01);
        assertEquals(ladoB, triangulo.getLadoB(), 0.01);
        assertEquals(ladoC, triangulo.getladoC(), 0.01);
    }

    @Test
    public void testConstructorConLadosInvalidos() throws ExcepcionTrianguloNoCreado {
        // CP 2
        ladoA =(int) 1.0;
        ladoB =(int) 2.0;
        ladoC =(int) 10.0;

        assertThrows(ExcepcionTrianguloNoCreado.class, () -> {
            triangulo = new Triangulo(ladoA, ladoB, ladoC);
        });
    }
    // Pruebas del metodo esTriangulo

    @Test 
    public void trianguloTresLadosIguales(){
        // CP 3
        ladoA = ladoB = ladoC = 3;
        triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloDosLadosIgualesValido(){
        // CP 4
        ladoA = ladoB = 5;
        ladoC = 2;
        triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloDosLadosIgualesError(){
        //CP 5
        ladoA = ladoB = 2;
        ladoC = 5;
        triangulo = new Triangulo();
        assertFalse(triangulo.esTriangulo(ladoA, ladoB, ladoC));
    }

    @Test 
    public void trianguloLadosDiferentesError(){
        //CP 6
        ladoB = 2;
        ladoC = 7;
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
    @Test
    public void trianguloLadoNegativo() throws ExcepcionTrianguloNoCreado{
        //CP 7
        assertThrows(ExcepcionTrianguloNoCreado.class, () -> {
            ladoA = -3;
            ladoB = 4;
            ladoC= 5;
            new Triangulo(ladoA,ladoB,ladoC);
        });
    }


    
}
