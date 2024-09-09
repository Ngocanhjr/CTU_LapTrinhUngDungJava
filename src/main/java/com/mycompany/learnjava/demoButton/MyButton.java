/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnjava.demoButton;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ASUS
 */
public class MyButton extends JButton{
    
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getBorderColer() {
        return borderColer;
    }

    public void setBorderColer(Color borderColer) {
        this.borderColer = borderColer;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
     public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClickl) {
        this.colorClick = colorClickl;
    }
    
    public MyButton (){
        //init color
        setColor(Color.WHITE);//30, 136, 56
        colorOver = new Color(179,250,160);
        colorClick = new Color(152, 184, 144);
        borderColer = new Color(225,111,41,255);
        setContentAreaFilled(false);
        //Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered (MouseEvent e){
                setBackground(colorOver);
                over = false;
            }
            
            @Override
            public void mouseExited (MouseEvent e){
                setBackground(color);
                over = false;
            }
            
            @Override
            public void mousePressed (MouseEvent e){
                setBackground(colorClick);
            }
            
            @Override
            public void mouseReleased (MouseEvent e){
                if(over){
                    setBackground(colorOver);
                } else{
                    setBackground(color);
                }
            }
        });
    }
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColer;
    private int radius = 0;
    
    @Override
    protected void paintComponent (Graphics grphcs){
    Graphics2D gp = (Graphics2D) grphcs;
    gp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //paint border 
    gp.setColor(borderColer);
    gp.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    gp.setColor(getBackground());
    //Border set 2 Pix
    gp.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
    super.paintComponent(grphcs);
    }
}
