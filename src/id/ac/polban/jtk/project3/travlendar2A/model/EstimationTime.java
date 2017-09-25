package id.ac.polban.jtk.project3.travlendar2A.model;
import id.ac.polban.jtk.project3.travlendar2A.model.TransportationMode.Transport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class EstimationTime {
    private double distance;
    private double speed;
    private double eta; //eta merupakan singkatan dari estimation time arrival
   
    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
        
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance)    {
        this.distance = distance;
    }
 
    
    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double countEstimationTime(double speed, double distance){
        this.speed = speed; 
        this.distance = distance; 
        eta = distance/speed; //estimation time diisi nilai hasil bagi jarak/kecepatan
        return eta;
    }
    
    public void printDistance(double eta){
        this.eta = eta;
        int inteta = (int) eta; //casting double to int
        eta = eta % 1 * 60; //menghitung hasil mod untuk dijadikan menit
        if ((inteta/1)<1){
            System.out.printf("%.0f",eta);
            System.out.print(" minutes");
        } else {
            System.out.print(inteta/1+" hours"); //membagi var eta yang telah dikonversi ke int dan akan dijadikan jam
            System.out.printf(" %.0f",eta);
            System.out.print(" minutes");
        }
    }
    
    public static void main(String[] args) {
        double eta, eta1;
        DistanceMatrix dm = new DistanceMatrix();
        TransportationMode tm = new TransportationMode();
        EstimationTime et = new EstimationTime();
        et.setDistance(106.20);
        eta = et.countEstimationTime(tm.getSpeedKendaraan(Transport.MOBIL),et.getDistance());
        eta1 = et.countEstimationTime(tm.getSpeedKendaraan(Transport.MOTOR),et.getDistance());
        et.printDistance(eta);
    }
}