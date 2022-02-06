/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTextArea;
import javax.swing.RepaintManager;

/**
 *
 * @author FUJITSU
 */
public class PrintReceipt implements Printable {
    private String text;
    
    public static void printTextarea(String text){
        new PrintReceipt(text).doPrint();
    }

    private PrintReceipt(String text) {
        this.text = text;
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex){
        if(pageIndex > 0){
            return (NO_SUCH_PAGE);
        }else{    
            Graphics2D g2d = (Graphics2D)g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
            Font defaultFont = new Font("Times",Font.PLAIN,7);
            g2d.setFont(defaultFont);
            
            String[] outputs = text.split("\n");
            int y = 20;
            for(int i = 0; i<outputs.length; i++){
                if(outputs[i].contains("TEF CANTEEN RECEIPT")){
                    g2d.setFont(new Font("Arial",Font.BOLD, 10));
                }
                g2d.drawString(outputs[i], 5, y);
                y += 15;
                System.out.println(y);
                
                g2d.setFont(defaultFont);
            }
            
            return PAGE_EXISTS;
        }
    }

    private void doPrint() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        if(printerJob.printDialog()){
            try{
                printerJob.print();
            }catch(PrinterException e){
                System.out.println("Util.PrintReceipt.doPrint()"+e.toString()+"\n"+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void disableDoubleBuffering(Component printComponent) {
        RepaintManager currentManager =RepaintManager.currentManager(printComponent);
        currentManager.setDoubleBufferingEnabled(false);
    }

    private void enableDoubleBuffering(Component printComponent) {
        RepaintManager currentManager = RepaintManager.currentManager(printComponent);
        currentManager.setDoubleBufferingEnabled(true);
    }
    
}
