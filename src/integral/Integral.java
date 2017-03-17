/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral;

/**
 * @author Ringo
 */
public class Integral {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        double a = -1.;
        double b = 1.;
        int n = 100000000;
        Integrator integrator = new Integrator();
        Fnc fnc = new Fnc();
        double aForThread, bForThread, h, step;
        int nForThread, threadCount;
        threadCount = 4;
        //n = Integer.parseInt(jTextField4.getText());
        nForThread = n / threadCount;
        System.out.println(nForThread + " intervals for 1 thread");
        h = (b - a) / n;
        step = h * nForThread;
        System.out.println(n + " intervals total");
        ThreadedCalc[] threads = new ThreadedCalc[threadCount];
        ThreadedCalc tread;
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            aForThread = a + i * step;
            bForThread = aForThread + step;
            tread = new ThreadedCalc(aForThread, bForThread, nForThread, fnc, integrator);
            threads[i] = tread;
            threads[i].run();
        }
        long t1 = System.currentTimeMillis() - t0;
        System.out.println(integrator.result);
        System.out.println(t1);
    }

}





