public class PixelColor{
    public static int getR(int c){
	return c>>16&0xff;
    }
    public static int getG(int c){
	return c>>8&0xff;
    }
    public static int getB(int c){
	return c&0xff;
    }
    public static int getColor(int r,int g,int b){
	return 0xff000000 | r<<16 | g<<8 | b;
    }
}
