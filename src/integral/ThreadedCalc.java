/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral;

/**
 * @author Ringo
 */
public class ThreadedCalc extends Thread {
    double result = 0;
    double a, b, n;
    Fnc fnc;
    Integrator integrator;

    public ThreadedCalc(double a, double b, double n, Fnc fnc, Integrator integrator) {
        super();
        this.a = a;
        this.b = b;
        this.n = n;
        this.fnc = fnc;
        this.integrator = integrator;
        synchronized (integrator) {
            integrator.activeTreadCount++;
        }
    }

    public void run() {
        result = Middlerectangles.integral(a, b, n, fnc);
        synchronized (integrator) {
            integrator.notify();
            integrator.result += result;
            integrator.activeTreadCount--;
        }
    }
}

