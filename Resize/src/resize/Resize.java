
package resize;

import java.awt.Color;

public class Resize {
    Picture picture;
    Picture picture2;
    int Resize;
    
    public Resize(Picture picture, int resize){
        this.picture = picture;
        this.Resize = resize;
        
        picture2 = new Picture(width() * this.Resize, height() * this.Resize);
        
        set();
    }
    
    public int height(){
        return this.picture.height();
    }
    
    public int width(){
        return this.picture.width();
    }
    
    public void set(){
        int k = 0;
        int l = 0;
        int count2 = 0;
        
        for (int i = 0; i < picture2.height(); i++) {
            count2++;
            int count = 0;
            for (int j = 0; j < picture2.width(); j++) {
                count++;
                picture2.set(j, i, picture.get(l,k));
                if(count == this.Resize){
                    count = 0;
                    l++;
                }
            }
            l = 0;
            if(count2 == this.Resize){
                count2 = 0;
                k++;
            }
        }
    }
    
    public static void main(String[] args) {
        Picture pic = new Picture("C:\\Users\\Asad\\Desktop\\DAA\\Question 1\\HJoceanSmall.png");
        
        pic.show();
        Resize r = new Resize(pic, 4);
        r.picture2.show();
    }
    
}
