/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesproduct;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Chris
 */
public class SeriesProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String n = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        int a, b, c, d, e, f, g, h, j, l, o, p, q, r, s, t, u, v, w, x = 0, y = 0, z, aa, ab;
        int result;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < n.length() - 13; i++){
            String k = n.substring(i, i + 13);
            long m = Long.parseLong(k);
            x += (m % 1000000);
            a = (x % 100000);
            b = (x / 100000); //prod
            c = (a % 10000);
            d = (a / 10000); // prod
            e = (c % 1000);
            f = (c / 1000); //prod
            g = (e % 100);
            h = (e / 100); //prod
            j = (g % 10); //prod
            l = (g / 10); //prod
            
            
            y += (m / 1000000);
            o = (y % 1000000);
            p = (y / 1000000); //prod
            q = (o % 100000);
            r = (o / 100000); //prod
            s = (q % 10000);
            t = (q / 10000); //prod
            u = (s % 1000);
            v = (s / 1000); //prod
            w = (u % 100);
            z = (u / 100); //prod
            aa = (w % 10); //prod
            ab = (w / 10); //prod
            
            result = (b * d * f * h * j * l * p * r * t * v * z * aa * ab);
            arr.add(result);
        }
        
        Object obj = Collections.max(arr);
        System.out.println(obj);
        
    }
    
}
