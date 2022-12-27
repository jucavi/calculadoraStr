/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estimado;

/**
 *
 * @author jcarv
 */
public class Estimado {
    
    private static String tomarDigStr(String numero, int index) {
        String dig;
        if (index >= 0) {
           dig = numero.substring(index);
        } else  {
            dig = "0";
        }
        
        return dig;
    }
    
    private static int sumar(int sumando1, int sumando2) {
            
        // convertimos a string los numeros enteros
        String sumando1Str = Integer.toString(sumando1);
        String sumando2Str = Integer.toString(sumando2);

        // sumando1 =   "24324";  42342  
        // sumando2 = "5346546"; 
        
        // Calculamos su longitud
        int longSum1 = sumando1Str.length() - 1;
        int longSum2 = sumando2Str.length() - 1;

        // Vemos el número máximo de iteraciones que tendremos que hacer
        int longMax = (longSum1 > longSum2) ? longSum1 : longSum2;
        
        int acarreo = 0;
        int sumatotal = 0;

        for (int i = 0; i <= longMax; i++) {
            
            String dig1Str;
            String dig2Str;
            int dig1;
            int dig2;

            int sumaparcial = 0;
            
            // obtenemos una serie de dígitos donde el primero a la derecha es el 
            // que necesitamos para trabajar 
            
            // porque lo sacamos a un método pero igual se puede hacer así
            /*
             if (longSum1 - i >= 0) {
                 dig = numero.substring(longSum1 - i);
              } else  {
                  dig = "0";
              }
            */
            dig1Str = tomarDigStr(sumando1Str, longSum1 - i);
            dig2Str = tomarDigStr(sumando2Str, longSum2 - i);
            
            
            // Cálculo de potencia de 10 -------------------
            int potencia = 1;

            for (int j = 0; j < i; j++) {
                potencia = potencia * 10;
            } 
            // ----- se puede sustituir por Math.pow -------

            // Pasamos de String a int y obtenemos el dígito de la serie de dígitos
            // Ej: i = 3, digitos = 6345: 3345 / 10^3 -> digito: 6
            dig1 = Integer.parseInt(dig1Str) / potencia;
            dig2 = Integer.parseInt(dig2Str) / potencia;
            
            // sumamos los dígitos obtenidos y el acarreo de la iteración anterior
            sumaparcial = dig1 + dig2 + acarreo;
            
            // el acarreo vuelve a cero despues de usarlo esta linea puede desaparecer
            // si añadimos un else al siguiente if
            acarreo = 0;
            
            // si la suma de ambos digitos es mayor que 9 conlleva acarreo
            if (sumaparcial > 9) {
                sumaparcial = sumaparcial - 10;
                acarreo = 1;
            } /* else {
                acarreo = 0;
            }
            */

            // se suma teniendo en cuenta las unidades a las que pertenece el dígito
            // centenas, decena, millarea (sumaparcial * 10^exponente)
            sumatotal = sumatotal + sumaparcial * potencia;

        }

       return sumatotal;
    }
    
    private static void noHaceNada() {}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(sumar(24324, 5346546));
    }
    
}
