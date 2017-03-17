/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral;


/**
 * @author Ringo
 */
public class Middlerectangles {
    public Middlerectangles() {
    }

    public static double integral(double a, double b, double n, Fnc fnc) {
        double r = 0.;
        double h = (b - a) / n;
        //step=h*nForThread;
        for (int i = 0; i < n; i++)
            r += fnc.f(a + i * h + h / 2);
        return r * h;
    }
}
