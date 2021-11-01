/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
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
    
    public static void printTextarea(JTextArea jTextArea){
        new PrintReceipt(jTextArea).doPrint();
    }

    private PrintReceipt(JTextArea jTextArea) {
        this.printComponent = jTextArea;
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex){
        if(pageIndex > 0){
            return (NO_SUCH_PAGE);
        }else{
            Graphics2D g2d = (Graphics2D)g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            disableDoubleBuffering(printComponent);
            printComponent.paint(g2d);
            enableDoubleBuffering(printComponent);
            return (PAGE_EXISTS);
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
