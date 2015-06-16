package eu.vdrm.util.file;

import java.io.File;
import java.io.IOException;


public interface DataWriter {
    public void setFileName(String path) throws IOException, IllegalStateException;
    public void setFile(File file) throws IOException, IllegalStateException;
    public File getFile();
    public void writeHeader(Object[] parms) throws IOException;
    public void addData(Object[] data) throws IOException;
    public void end()  throws IOException;
}
