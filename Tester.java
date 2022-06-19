import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class Tester extends JFrame implements ChangeListener, ActionListener{
    JSlider sliderOpacity;
    JSlider sliderRed,sliderGreen,sliderBlue;
    JLabel labelO,labelR,labelG,labelB;
    JLabel labelOStatus,labelRStatus,labelGStatus,labelBStatus;
    JLabel label1, label2;
    JPanel p;
    ImageIcon icon1,icon2;
    JComboBox<String> mode;
    JButton button;
    int out;

    enum layerType{
	NORMAL,DARKEN,MULTIPLY,COLOR_BURN,LINEAR_BURN,SUBTRACT,
	LIGHTEN,SCREEN,COLOR_DODGE,GLOW_DODGE,ADD,ADD_GLOW,
	OVERLAY,SOFT_LIGHT,HARD_LIGHT,DEFFERENCE,VIVID_LIGHT,
	LINEAR_LIGHT,PIN_LIGHT,HARDMIX,EXCLUSION,DARKER_COLOR,LIGHTER_COLOR,
	DIVIDE,HUE,SATURATION,COLOR,LUMINOSITY

    }
    layerType lp;
    
    public static void main(String args[]){
	Tester frame = new Tester();
	frame.setVisible(true);
	frame.setTitle("Tester");
	frame.setBounds(100,100,1200,1000);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    Tester(){

	out = 0;
	
	sliderOpacity = new JSlider();
	sliderRed     = new JSlider(0,255);
	sliderGreen   = new JSlider(0,255);
	sliderBlue    = new JSlider(0,255);
	sliderOpacity.addChangeListener(this);
	sliderRed.addChangeListener(this);
	sliderGreen.addChangeListener(this);
	sliderBlue.addChangeListener(this);	
	String[] mode_data = {"通常","比較(暗)","乗算","焼き込みカラー",
			      "焼き込み(リニア)","減算","比較(明)","スクリーン",
			      "覆い焼きカラー","覆い焼き(発光)(※未実装)","加算","加算(発光)(※未実装)",
			      "オーバーレイ","ソフトライト(※未実装)","ハードライト",
			      "差の絶対値","ビビッドライト(※未実装)","リニアライト(※未実装)",
			      "ピンライト(※未実装)","ハードミックス","除外","カラー比較(暗)",
			      "カラー比較(明)","除算","色相(※未実装)","彩度(※未実装)",
			      "カラー(※未実装)","輝度(※未実装)"};
	mode = new JComboBox<String>(mode_data);

	icon1 = new ImageIcon("./sample.jpg");
	icon2 = new ImageIcon("./sample.jpg");
	
	labelOStatus = new JLabel();
	labelOStatus.setText("不透明度 : " + sliderOpacity.getValue());
	labelRStatus = new JLabel();
	labelRStatus.setText("R : " + sliderRed.getValue());
	labelGStatus = new JLabel();
	labelGStatus.setText("G : " + sliderGreen.getValue());
	labelBStatus = new JLabel();
	labelBStatus.setText("B : " + sliderBlue.getValue());      
	
	label1 = new JLabel(icon1);
        label2 = new JLabel(icon2);
	
	labelO = new JLabel();
	labelO.setText("不透明度");

	button = new JButton("done");
	button.addActionListener(this);

	JPanel p = new JPanel();
	
	p.add(label1);
	p.add(sliderOpacity);
	p.add(labelOStatus);
	p.add(sliderRed);
	p.add(labelRStatus);
	p.add(sliderGreen);
	p.add(labelGStatus);
	p.add(sliderBlue);
	p.add(labelBStatus);
	p.add(mode);
	p.add(label2);
	p.add(button);

	Container contentPane = getContentPane();
	contentPane.add(p, BorderLayout.CENTER);
    }
    public void stateChanged(ChangeEvent e1){
	labelOStatus.setText("不透明度 : " + sliderOpacity.getValue());
	labelRStatus.setText("R : " + sliderRed.getValue());
	labelGStatus.setText("G : " + sliderGreen.getValue());
	labelBStatus.setText("B : " + sliderBlue.getValue());
    }

    
    public void actionPerformed(ActionEvent ev){
	File f = new File("./sample.jpg");       
	BufferedImage read = new BufferedImage(1,1,1);
	
	try{
	    read = ImageIO.read(f);
	}catch(IOException e2){
	    System.err.println(e2.getMessage());
	}
	
	int w = read.getWidth(),h=read.getHeight();
	BufferedImage write =
	    new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

	String mode_select = (String)mode.getSelectedItem();
	if(mode_select.equals("通常")){
	    lp = layerType.NORMAL;
	}else if(mode_select.equals("比較(暗)")){
	    lp = layerType.DARKEN;
	}else if(mode_select.equals("乗算")){
	    lp = layerType.MULTIPLY;
	}else if(mode_select.equals("焼き込みカラー")){
	    lp = layerType.COLOR_BURN;
	}else if(mode_select.equals("焼き込み(リニア)")){
	    lp = layerType.LINEAR_BURN;
	}else if(mode_select.equals("減算")){
	    lp = layerType.SUBTRACT;
	}else if(mode_select.equals("比較(明)")){
	    lp = layerType.LIGHTEN;
	}else if(mode_select.equals("スクリーン")){
	    lp = layerType.SCREEN;
	}else if(mode_select.equals("覆い焼きカラー")){
	    lp = layerType.COLOR_DODGE;
	}else if(mode_select.equals("覆い焼き(発光)(※未実装)")){
	    lp = layerType.GLOW_DODGE;
	}else if(mode_select.equals("加算")){
	    lp = layerType.ADD;
	}else if(mode_select.equals("加算(発光)(※未実装)")){
	    lp = layerType.ADD_GLOW;
	}else if(mode_select.equals("オーバーレイ")){
	    lp = layerType.OVERLAY;
	}else if(mode_select.equals("ソフトライト(※未実装)")){
	    lp = layerType.SOFT_LIGHT;
	}else if(mode_select.equals("ハードライト")){
	    lp = layerType.HARD_LIGHT;
	}else if(mode_select.equals("差の絶対値")){
	    lp = layerType.DEFFERENCE;
	}else if(mode_select.equals("ビビッドライト(※未実装)")){
	    lp = layerType.VIVID_LIGHT;
	}else if(mode_select.equals("リニアライト(※未実装)")){
	    lp = layerType.LINEAR_LIGHT;
	}else if(mode_select.equals("ピンライト(※未実装)")){
	    lp = layerType.PIN_LIGHT;
	}else if(mode_select.equals("ハードミックス")){
	    lp = layerType.HARDMIX;
	}else if(mode_select.equals("除外")){
	    lp = layerType.EXCLUSION;
	}else if(mode_select.equals("カラー比較(暗)")){
	    lp = layerType.DARKER_COLOR;
	}else if(mode_select.equals("カラー比較(明)")){
	    lp = layerType.LIGHTER_COLOR;
	}else if(mode_select.equals("除算")){
	    lp = layerType.DIVIDE;
	}else if(mode_select.equals("色相(※未実装)")){
	    lp = layerType.HUE;
	}else if(mode_select.equals("彩度(※未実装)")){
	    lp = layerType.SATURATION;
	}else if(mode_select.equals("カラー(※未実装)")){
	    lp = layerType.COLOR;
	}else if(mode_select.equals("輝度(※未実装)")){
	    lp = layerType.LUMINOSITY;
	}
	

	for(int y = 0;y<h;y++){
	    for(int x = 0;x<w;x++){		
		int c = read.getRGB(x,y);

		int a = sliderOpacity.getValue();
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();

		int rgb = 0;
		
		if(lp == layerType.NORMAL){
		    rgb = CalcColor.normal(c,a,r,g,b);
		}else if(lp == layerType.DARKEN){
		    rgb = CalcColor.darken(c,a,r,g,b);
		}else if(lp == layerType.MULTIPLY){
		    rgb = CalcColor.multiply(c,a,r,g,b);
		}else if(lp == layerType.COLOR_BURN){
		    rgb = CalcColor.colorBurn(c,a,r,g,b);
		}else if(lp == layerType.LINEAR_BURN){
		    rgb = CalcColor.linearBurn(c,a,r,g,b);
		}else if(lp == layerType.SUBTRACT){
		    rgb = CalcColor.subtract(c,a,r,g,b);
		}else if(lp == layerType.LIGHTEN){
		    rgb = CalcColor.lighten(c,a,r,g,b);
		}else if(lp == layerType.SCREEN){
		    rgb = CalcColor.screen(c,a,r,g,b);
		}else if(lp == layerType.COLOR_DODGE){
		    rgb = CalcColor.colorDodge(c,a,r,g,b);
		}else if(lp == layerType.GLOW_DODGE){
		    rgb = CalcColor.glowDodge(c,a,r,g,b);
		}else if(lp == layerType.ADD){
		    rgb = CalcColor.add(c,a,r,g,b);
		}else if(lp == layerType.ADD_GLOW){
		    rgb = CalcColor.addGlow(c,a,r,g,b);
		}else if(lp == layerType.OVERLAY){
		    rgb = CalcColor.overlay(c,a,r,g,b);
		}else if(lp == layerType.SOFT_LIGHT){
		    rgb = CalcColor.softLight(c,a,r,g,b);
		}else if(lp == layerType.HARD_LIGHT){
		    rgb = CalcColor.hardLight(c,a,r,g,b);
		}else if(lp == layerType.DEFFERENCE){
		    rgb = CalcColor.difference(c,a,r,g,b);
		}else if(lp == layerType.VIVID_LIGHT){
		    rgb = CalcColor.vividLight(c,a,r,g,b);
		}else if(lp == layerType.LINEAR_LIGHT){
		    rgb = CalcColor.linearLight(c,a,r,g,b);
		}else if(lp == layerType.PIN_LIGHT){
		    rgb = CalcColor.pinLight(c,a,r,g,b);
		}else if(lp == layerType.HARDMIX){
		    rgb = CalcColor.hardmix(c,a,r,g,b); 
		}else if(lp == layerType.EXCLUSION){
		    rgb = CalcColor.exclusion(c,a,r,g,b);
		}else if(lp == layerType.DARKER_COLOR){
		    rgb = CalcColor.darkerColor(c,a,r,g,b);
		}else if(lp == layerType.LIGHTER_COLOR){
		    rgb = CalcColor.lighterColor(c,a,r,g,b);
		}else if(lp == layerType.DIVIDE){
		    rgb = CalcColor.divide(c,a,r,g,b);
		}else if(lp == layerType.HUE){
		    rgb = CalcColor.hue(c,a,r,g,b);
		}else if(lp == layerType.SATURATION){
		    rgb = CalcColor.saturation(c,a,r,g,b);
		}else if(lp == layerType.COLOR){
		    rgb = CalcColor.color(c,a,r,g,b);
		}else if(lp == layerType.LUMINOSITY){
		    rgb = CalcColor.luminosity(c,a,r,g,b);
		}
		write.setRGB(x,y,rgb);
	    }
	}

	File f2 = new File("after" + out + ".jpg");
	try{
	    ImageIO.write(write,"jpg",f2);
	}catch(IOException e3){
	    System.out.println(e3.getMessage());
	}
	icon2 = new ImageIcon("after"+out+".jpg");
	out = (out > 5) ? 0 : out+1;
	label2.setIcon(null);
	label2.setIcon(icon2);

    }
}
