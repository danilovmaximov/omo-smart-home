package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.SensorsStation;

import java.util.Random;
import java.util.Scanner;

public class TestingGround {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            s.nextLine();
            System.out.println(r.nextInt(20));
        }
    }
}
