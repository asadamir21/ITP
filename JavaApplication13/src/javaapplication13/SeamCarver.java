/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeamCarver{
    Picture picture;
    private double[][] energy;
    
    public SeamCarver(Picture picture){ 
        this.picture = picture;
        this.energy = new double[height()][width()];
        
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                energy[i][j] = energy(i, j);
            }
        }
    }
    public Picture picture(){ 
        return picture;
    }
    public int width(){ 
        return this.picture.width();
    }
     
    public int height(){ 
        return this.picture.height();
    }

    public double energy(int y, int x) {// energy of pixel at column x and row y
        if (x >= width() || y >= height() || x < 0 || y < 0){
            System.out.println("Boundaries out of Range");
            System.exit(0);
        }
        else if(isBorder(x,y)){
            if(x == 0 && y == 0){
                Color up = new Color(picture.get(x, height() - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);
            
                Color left = new Color(picture.get(width() - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(x == width() - 1 || y == height() - 1){
                Color up = new Color(picture.get(x, height() - 1).getRGB());
                Color down = new Color(picture.get(x, 0).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);
            
                Color left = new Color(picture.get(width() - 1, y).getRGB());
                Color right = new Color(picture.get(0, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(x == width() - 1 || y == 0){
                Color up = new Color(picture.get(x, height() - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);
            
                Color left = new Color(picture.get(x - 1, y).getRGB());
                Color right = new Color(picture.get(0, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(x == 0 || y == height() - 1){
                Color up = new Color(picture.get(x, y - 1).getRGB());
                Color down = new Color(picture.get(0, y - 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);
            
                Color left = new Color(picture.get(width() - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(x == 0){
                Color up = new Color(picture.get(x, y - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);
            
                Color left = new Color(picture.get(width() - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(y == 0){
                Color up = new Color(picture.get(x, height() - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);

                Color left = new Color(picture.get(x - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);

                return Math.sqrt(deltaX + deltaY);
            }
            else if(x == width() - 1){
                Color up = new Color(picture.get(x, y - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);

                Color left = new Color(picture.get(x - 1, y).getRGB());
                Color right = new Color(picture.get(0, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);
            
                return Math.sqrt(deltaX + deltaY);
            }
            else if(y == height() - 1){
                Color up = new Color(picture.get(x, y - 1).getRGB());
                Color down = new Color(picture.get(x, 0).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);

                Color left = new Color(picture.get(x - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);

                return Math.sqrt(deltaX + deltaY);
            }
        }
        else{
            if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1)
                return (double) 1000;
            
            else{
                Color up = new Color(picture.get(x, y - 1).getRGB());
                Color down = new Color(picture.get(x, y + 1).getRGB());
                double deltaX = Math.pow(up.getRed() - down.getRed(), 2) + Math.pow(up.getBlue()- down.getBlue(), 2) + Math.pow(up.getGreen()- down.getGreen(), 2);

                Color left = new Color(picture.get(x - 1, y).getRGB());
                Color right = new Color(picture.get(x + 1, y).getRGB());
                double deltaY = Math.pow(left.getRed() - right.getRed() , 2) + Math.pow(left.getBlue()- right.getBlue(), 2) + Math.pow(left.getGreen()- right.getGreen(), 2);

                return Math.sqrt(deltaX + deltaY);
            }
        }
        return -1;
    }
    
    public boolean isBorder(int x, int y){
        if(x == 0 || x == width() - 1 || y == 0 || y == height() - 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int[] findHorizontalSeam() {// sequence of indices for horizontal seam
        double seam[][] = new double[height()][2];
        
        for (int j = 0; j < height(); j++) {
            double colsum = 0;
            for(int i = width() - 1; i > 0; i--){
                if(j == 0){
                    colsum += energy[j][i] + Math.min(energy[j][i-1], energy[j+1][i-1]);
                }
                else if(j == height() - 1){
                    colsum += energy[j][i] + Math.min(energy[j][i-1], energy[j-1][i-1]);
                }
                else{
                    colsum += energy[j][i] + Math.min(energy[j+1][i-1], Math.min(energy[j][i-1], energy[j-1][i-1]));
                }
            }
            seam[j][0] = colsum;
            seam[j][1] = j;  
        }
        
        double min = Double.POSITIVE_INFINITY;
        int index = 0;
       
        for (int i = 0; i < seam.length; i++) {
            if(min > seam[i][0]){
                min = seam[i][0];
                index = (int) seam[i][1];
            }
        } 
        int arr[] = new int[width()];
        int arrcount = width() - 1;
        arr[arrcount] = index;
        arrcount--;
       
        
        for(int i = width() - 1; i > 0; i--){
            if(index == 0){
                double a = Math.min(energy[index][i-1], energy[index+1][i-1]);
                if(a == energy[index][i-1]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index + 1;
                    arrcount--;
                    index = index + 1;
                }
            }
            else if(index == height() - 1){
                double a = Math.min(energy[index][i-1], energy[index-1][i-1]);
                if(a == energy[index][i-1]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index - 1;
                    arrcount--;
                    index = index + 1;
                }
            }
            else{
                double a = Math.min(energy[index+1][i-1], Math.min(energy[index][i-1], energy[index-1][i-1]));
                if(a == energy[index-1][i-1]){
                    arr[arrcount] = index - 1;
                    arrcount--;
                    index = index - 1;
                }
                else if(a == energy[index][i-1]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index + 1;
                    arrcount--;
                    index = index + 1;
                }
            }
        }
        return arr;
    }
     
    public int[] findVerticalSeam(){ 
        double seam[][] = new double[width()][2];
        
        for (int j = 0; j < width(); j++) {
            double colsum = 0;
            for(int i = height() - 1; i > 0; i--){
                if(j == 0){
                    colsum += energy[i][j] + Math.min(energy[i-1][j], energy[i-1][j+1]);
                }
                else if(j == width() - 1){
                    colsum += energy[i][j] + Math.min(energy[i-1][j-1], energy[i-1][j]);
                }
                else{
                    colsum += energy[i][j] + Math.min(energy[i-1][j-1], Math.min(energy[i-1][j], energy[i-1][j+1]));
                }
            }
            seam[j][0] = colsum;
            seam[j][1] = j;  
        }
        
        double min = Double.POSITIVE_INFINITY;
        int index = 0;
        
        for (int i = 0; i < seam.length; i++) {
            if(min > seam[i][0]){
                min = seam[i][0];
                index = (int) seam[i][1];
            }
        } 
        
        int arr[] = new int[height()];
        int arrcount = height() - 1;
        arr[height() - 1] = index;
        arrcount--;
        
        
        for(int i = height() - 1; i > 0; i--){
            if(index == 0){
                double a = Math.min(energy[i-1][index], energy[i-1][index+1]);
                if(a == energy[i-1][index]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index + 1;
                    arrcount--;
                    index = index + 1;
                }
            }
            else if(index == width() - 1){
                double a = Math.min(energy[i-1][index], energy[i-1][index-1]);
                if(a == energy[i-1][index]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index - 1;
                    arrcount--;
                    index = index + 1;
                }
            }
            else{
                double a = Math.min(energy[i-1][index-1], Math.min(energy[i-1][index], energy[i-1][index+1]));
                if(a == energy[i-1][index-1]){
                    arr[arrcount] = index - 1;
                    arrcount--;
                    index = index - 1;
                }
                else if(a == energy[i-1][index]){
                    arr[arrcount] = index;
                    arrcount--;
                }
                else{
                    arr[arrcount] = index + 1;
                    arrcount--;
                    index = index + 1;
                }
            }
        }
        return arr;
    }
    
    public void removeHorizontalSeam(int[] seam){ 
        Picture newpicture = new Picture(width(), height() - 1);
        
        for (int i = 0; i < width(); i++) {      
            for (int j = 0; j < seam[i]; j++) {
                newpicture.set(i, j, new Color (picture.get(i, j).getRGB()));
            }
            for (int j = seam[i]; j < height()-1; j++) {
                newpicture.set(i, j, new Color (picture.get(i, j+1).getRGB()));
            }
	}
        this.picture = newpicture;
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                energy[i][j] = energy(i, j);
            }
        }
    }
     
    public void removeVerticalSeam(int[] seam){ 
        Picture newpicture = new Picture(width() - 1, height());
        
        for (int i = 0; i < height(); i++) {      
            for (int j = 0; j < seam[i]; j++) {
                newpicture.set(j, i, new Color (picture.get(j, i).getRGB()));
            }
            for (int j = seam[i]; j < width()-1; j++) {
                newpicture.set(j, i, new Color (picture.get(j+1, i).getRGB()));
            }
	}
        this.picture = newpicture;
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                energy[i][j] = energy(i, j);
            }
        }
    }
     
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Picture picture = new Picture("C:\\Users\\Asad\\Desktop\\DAA\\Question 1\\HJoceanSmall.png");
        SeamCarver seamcar = new SeamCarver(picture);
        
//        seamcar.picture.show();
//        
//        for (int i = 0; i < 100; i++) {
//            seamcar.removeVerticalSeam(seamcar.findVerticalSeam());
//        }
//
        seamcar.picture.show();  
        
        for (int i = 0; i < 250; i++) {
            seamcar.removeHorizontalSeam(seamcar.findHorizontalSeam());
        }
        seamcar.picture.show(); 
    }
}