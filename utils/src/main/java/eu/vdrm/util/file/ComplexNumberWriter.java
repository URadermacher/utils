package eu.vdrm.util.file;

import java.io.IOException;

import org.apache.commons.math3.complex.Complex;

/**
 * writes complex numbers in 3 cols
 * 1 = index
 * 2 = real
 * 3 = imaginary
 * 
 * in gnuplot use to display (x, y  and filename as example ):
 * 
gnuplot> set yrange [-2:2]
gnuplot> set xrange [0:7]   
gnuplot> plot 'sdk_0.txt' using 1:2 title "real"  with lines, 'sdk_0.txt' using 1:3 title "imaginary" with lines
 * 
 * @author ura03640
 *
 */
public class ComplexNumberWriter extends AbstractDataWriter{
    
    
    /* line counter */
    private int count = 0;
    /**
     * we expect an array of Complex numbers.
     * We write  real part and imaginary part as a long
     */
    public void addData(Object[] data) throws IOException {
        Complex[] myData = (Complex[])data;
        for (int i = 0; i < myData.length; i++){
            writer.write(""+ count++ + " " + myData[i].getReal()+  " " + myData[i].getImaginary() + "\n");
        }
    }
    public void writeHeader(Object[] parms) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (Object o : parms) {
            sb.append(" ").append(o.toString());
        }
        
    }
    
}
