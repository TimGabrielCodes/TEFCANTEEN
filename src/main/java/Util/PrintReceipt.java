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
    private Component printComponent;
    private String text;
    
    public static void printTextarea(JTextArea jTextArea, String text){
        new PrintReceipt(jTextArea, text).doPrint();
    }

    private PrintReceipt(JTextArea jTextArea, String text) {
        this.printComponent = jTextArea;
        this.text = text;
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex){
        if(pageIndex > 0){
            return (NO_SUCH_PAGE);
        }else{    
            Graphics2D g2d = (Graphics2D)g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
//            printComponent.setFont(new Font("Monospaced",Font.PLAIN,8));//Set the font
            
            disableDoubleBuffering(printComponent);
            
//            FontRenderContext frc = g2d.getFontRenderContext();
//            TextLayout tLayout = new TextLayout(text, new Font("Monospaced",Font.PLAIN,8), frc);
            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
            int idLength = metrics.stringWidth("000000");
            g2d.setFont(new Font("Monospaced",Font.PLAIN,8));
            
            String[] outputs = text.split("\n");
            int y = 20;
            for(int i = 0; i<outputs.length; i++){
                g2d.drawString(outputs[i], 5, y);
                y += 15;
                System.out.println(y);
            }
            
//            printComponent.paint(g2d);
            enableDoubleBuffering(printComponent);
            return PAGE_EXISTS;
        }
    }

    private void doPrint() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        if(printerJob.printDialog()){
            try{
                printerJob.print();
//                printComponent.setFont(new Font("Arial",Font.PLAIN, 13));//Reset the receipt view after printing
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
