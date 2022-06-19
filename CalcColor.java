public class CalcColor{
    public static int normal(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+(int)((r-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+(int)((g-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+(int)((b-PixelColor.getB(c))*percent);
	return PixelColor.getColor(red,green,blue);
    }
    
    public static int darken(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	if(PixelColor.getR(c) < r){
	    red = PixelColor.getR(c);
	}else {
	    red = PixelColor.getR(c)-(int)((PixelColor.getR(c)-r)*percent);
	}
	if(PixelColor.getG(c) < g){
	    green = PixelColor.getG(c);
	}else {
	    green = PixelColor.getG(c)-(int)((PixelColor.getG(c)-g)*percent);
	}
	if(pixel_color.get_b(c) < b){
	    blue = PixelColor.getB(c);
	}else {
	    blue = PixelColor.getB(c)-(int)((PixelColor.getB(c)-b)*percent);
	}
	return PixelColor.getColor(red,green,blue);
    }
    
    public static int multiply(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)-
	    (int)((PixelColor.getR(c)-PixelColor.getR(c)*r/255)*percent);
	int green = PixelColor.getG(c)-
	    (int)((PixelColor.getG(c)-PixelColor.getG(c)*g/255)*percent);
	int blue = PixelColor.getB(c)-
	    (int)((PixelColor.getB(c)-PixelColor.getB(c)*b/255)*percent);
	red = red < 0 ? 0 : red;
	green = green < 0 ? 0 : green;
	blue = blue < 0 ? 0 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    
    public static int colorBurn(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+
	    (int)(((255-(255-PixelColor.getR(c))*255/r)-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+
	    (int)(((255-(255-PixelColor.getG(c))*255/g)-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+
	    (int)(((255-(255-PixelColor.getB(c))*255/b)-PixelColor.getB(c))*percent);
	red = red < 0 ? 0 : red;
	green = green < 0 ? 0 : green;
	blue = blue < 0 ? 0 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int linearBurn(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+
	    (int)(((255-((255-PixelColor.getR(c))+(255-r)))-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+
	    (int)(((255-((255-PixelColor.getG(c))+(255-g)))-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+
	    (int)(((255-((255-PixelColor.getB(c))+(255-b)))-PixelColor.getB(c))*percent);
	red = red < 0 ? 0 : red;
	green = green < 0 ? 0 : green;
	blue = blue < 0 ? 0 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int subtract(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+
	    (int)(((PixelColor.getR(c)-r)-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+
	    (int)(((PixelColor.getG(c)-g)-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+
	    (int)(((PixelColor.getB(c)-b)-PixelColor.getB(c))*percent);
	red = red < 0 ? 0 : red;
	green = green < 0 ? 0 : green;
	blue = blue < 0 ? 0 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int lighten(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	if(PixelColor.getR(c) > r){
	    red = PixelColor.getR(c);
	}else {
	    red = PixelColor.getR(c)+
		(int)((r-PixelColor.getR(c))*percent);
	}
	if(PixelColor.getG(c) > g){
	    green = PixelColor.getG(c);
	}else {
	    green = PixelColor.getG(c)+
		(int)((g-PixelColor.getG(c))*percent);
	}
	if(PixelColor.getB(c) > b){
	    blue = PixelColor.getB(c);
	}else {
	    blue = PixelColor.getB(c)+
		(int)((b-PixelColor.getB(c))*percent);
	}
	return PixelColor.getColor(red,green,blue);
    }
    public static int screen(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+(int)
	    (((PixelColor.getR(c)+r-PixelColor.getR(c)*r/255)-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+(int)
	    (((PixelColor.getG(c)+g-PixelColor.getG(c)*g/255)-PixelColor.getG(c))*percent);	
	int blue = PixelColor.getB(c)+(int)
	    (((PixelColor.getB(c)+b-PixelColor.getB(c)*b/255)-PixelColor.getB(c))*percent);
	red = red > 255 ? 255 : red;
	green = green > 255 ? 255 : green;
	blue = blue > 255 ? 255 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int colorDodge(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	if(r==255)r=254;
	if(g==255)g=254;
	if(b==255)b=254;
	int red = PixelColor.getR(c)+(int)
	    (((PixelColor.getR(c)*255/(255-r))-PixelColor.getR(c))*percent);	
	int green = PixelColor.getG(c)+(int)
	    (((PixelColor.getG(c)*255/(255-g))-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+(int)
	    (((PixelColor.getB(c)*255/(255-b))-PixelColor.getB(c))*percent);
	red = red > 255 ? 255 : red;
	green = green > 255 ? 255 : green;
	blue = blue > 255 ? 255 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int glowDodge(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int add(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)+
	    (int)(((PixelColor.getR(c)+r)-PixelColor.getR(c))*percent);
	int green = PixelColor.getG(c)+
	    (int)(((PixelColor.getG(c)+g)-PixelColor.getG(c))*percent);
	int blue = PixelColor.getB(c)+
	    (int)(((PixelColor.getB(c)+b)-PixelColor.getB(c))*percent);
	red = red > 255 ? 255 : red;
	green = green > 255 ? 255 : green;
	blue = blue > 255 ? 255 : blue;
	return PixelColor.getColor(red,green,blue);
    }
    public static int addGlow(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int overlay(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	if(PixelColor.getR(c)<128){
	    red = PixelColor.getR(c)-
	    (int)((PixelColor.getR(c)-PixelColor.getR(c)*r*2/255)*percent);
	}else {
	    red = PixelColor.getR(c)+(int)
		(((2*(PixelColor.getR(c)+r-PixelColor.getR(c)*r/255)-255)
		  -PixelColor.getR(c))*percent);	    
	}
	if(PixelColor.getG(c)<128){
	    green = PixelColor.getG(c)-
	    (int)((PixelColor.getG(c)-PixelColor.getG(c)*g*2/255)*percent);
	}else {
	    green = PixelColor.getG(c)+(int)
		(((2*(PixelColor.getG(c)+g-PixelColor.getG(c)*g/255)-255)
		  -PixelColor.getG(c))*percent);
	}
	if(PixelColor.getB(c)<128){
	    blue = PixelColor.getB(c)-
	    (int)((PixelColor.getB(c)-PixelColor.getB(c)*b*2/255)*percent);
	}else {
	    blue = PixelColor.getB(c)+(int)
		(((2*(PixelColor.getB(c)+b-PixelColor.getB(c)*b/255)-255)
		  -PixelColor.getB(c))*percent);
	}
	return PixelColor.getColor(red,green,blue);
    }
    public static int softLight(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int hardLight(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	if(r<128){
	    red = PixelColor.getR(c)-
	    (int)((PixelColor.getR(c)-PixelColor.getR(c)*r*2/255)*percent);
	}else {
	    red = PixelColor.getR(c)+(int)
		(((2*(PixelColor.getR(c)+r-PixelColor.getR(c)*r/255)-255)
		  -PixelColor.getR(c))*percent);
	}
	if(g<128){
	    green = PixelColor.getG(c)-
	    (int)((PixelColor.getG(c)-PixelColor.getG(c)*g*2/255)*percent);
	}else {
	    green = PixelColor.getG(c)+(int)
		(((2*(PixelColor.getG(c)+g-PixelColor.getG(c)*g/255)-255)
		  -PixelColor.getG(c))*percent);	   
	}
	if(b<128){
	    blue = PixelColor.getB(c)-
	    (int)((PixelColor.getB(c)-PixelColor.getB(c)*b*2/255)*percent);
	}else {
	    blue = PixelColor.getB(c)+(int)
		(((2*(PixelColor.getB(c)+b-PixelColor.getB(c)*b/255)-255)
		  -PixelColor.getB(c))*percent);
	}
	return PixelColor.getColor(red,green,blue);
    }
    public static int difference(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)-r;
	int green = PixelColor.getG(c)-g;
	int blue = PixelColor.getB(c)-b;
	
	red = red < 0 ? -red : red;
	green = green < 0 ? -green : green;
	blue = blue < 0 ? -blue : blue;
	
	red = PixelColor.getR(c)-(int)
	    ((PixelColor.getR(c)-red)*percent);
	green = PixelColor.getG(c)-(int)
	    ((PixelColor.getG(c)-green)*percent);
	blue = PixelColor.getB(c)-(int)
	    ((PixelColor.getB(c)-blue)*percent);
	return PixelColor.getColor(red,green,blue);
    }    
    public static int vividLight(int c,int a,int r,int g,int b){
        double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int linearLight(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int pinLight(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int hardmix(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	red = (PixelColor.getR(c)+r) > 255 ? 255 : 0;
	green = (PixelColor.getG(c)+g) > 255 ? 255 : 0;
	blue = (PixelColor.getB(c)+b) > 255 ? 255 : 0;

	if(red == 255){
	    red = PixelColor.getR(c)-(int)((PixelColor.getR(c)-red)*percent);
	}else {
	    red = PixelColor.getR(c)-(int)(PixelColor.getR(c)*percent);	    
	}
	if(green == 255){
	    green = PixelColor.getG(c)-(int)((PixelColor.getG(c)-green)*percent);
	}else {
	    green = PixelColor.getG(c)-(int)(PixelColor.getG(c)*percent);
	}	
	if(blue == 255){
	    blue = PixelColor.getB(c)-(int)((PixelColor.getB(c)-blue)*percent);
	}else {
	    blue = PixelColor.getB(c)-(int)(PixelColor.getB(c)*percent);
	}
	
	return PixelColor.getColor(red,green,blue);
    }
    public static int exclusion(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c)-(int)
	    ((PixelColor.getR(c)-(PixelColor.getR(c)+r-2*PixelColor.getR(c)*r/255))*percent);	
	int green = PixelColor.getG(c)-(int)
	    ((PixelColor.getG(c)-(PixelColor.getG(c)+g-2*PixelColor.getG(c)*g/255))*percent);
	int blue = PixelColor.getB(c)-(int)
	    ((PixelColor.getB(c)-(PixelColor.getB(c)+b-2*PixelColor.getB(c)*b/255))*percent);
	return PixelColor.getColor(red,green,blue);
    }
    public static int darkerColor(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	int baseSum = PixelColor.getR(c)+PixelColor.getG(c)+PixelColor.getB(c);
	int mixSum = r+g+b;
	if(mixSum < baseSum){
	    red = PixelColor.getR(c)+(int)((r-PixelColor.getR(c))*percent);
	    green = PixelColor.getG(c)+(int)((g-PixelColor.getG(c))*percent);
	    blue = PixelColor.getB(c)+(int)((b-PixelColor.getB(c))*percent);   
	}else {
	    red = PixelColor.getR(c);
	    green = PixelColor.getG(c);
	    blue = PixelColor.getB(c);
	}
	return PixelColor.getColor(red,green,blue);
    }
    public static int lighterColor(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red,green,blue;
	int baseSum = PixelColor.getR(c)+PixelColor.getG(c)+PixelColor.getB(c);
	int mixSum = r+g+b;
	if(mixSum > baseSum){
	    red = PixelColor.getR(c)+(int)((r-PixelColor.getR(c))*percent);
	    green = PixelColor.getG(c)+(int)((g-PixelColor.getG(c))*percent);
	    blue = PixelColor.getB(c)+(int)((b-PixelColor.getB(c))*percent);   
	}else {
	    red = PixelColor.getR(c);
	    green = PixelColor.getG(c);
	    blue = PixelColor.getB(c);
	}
	return PixelColor.getColor(red,green,blue);
    }
    public static int divide(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	if(r==0)r=1;
	if(g==0)g=1;
	if(b==0)b=1;
	int red = PixelColor.getR(c)/r*255;
	int green = PixelColor.getG(c)/g*255;
	int blue = PixelColor.getB(c)/b*255;
	
	red = red > 255 ? 255 : red;
	green = green > 255 ? 255 : green;
	blue = blue > 255 ? 255 : blue;

	red = PixelColor.getR(c)+(int)
	    ((red-PixelColor.getR(c))*percent);
	green = PixelColor.getG(c)+(int)
	    ((green-PixelColor.getG(c))*percent);
	blue = PixelColor.getB(c)+(int)
	    ((blue-PixelColor.getB(c))*percent);
	
	return PixelColor.getColor(red,green,blue);
    }
    public static int hue(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int saturation(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int color(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
    public static int luminosity(int c,int a,int r,int g,int b){
	double percent = a * 0.01;
	int red = PixelColor.getR(c);
	int green = PixelColor.getG(c);	
	int blue = PixelColor.getB(c);
	return PixelColor.getColor(red,green,blue);
    }
}
