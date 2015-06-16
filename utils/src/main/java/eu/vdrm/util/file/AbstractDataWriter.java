package eu.vdrm.util.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public abstract class AbstractDataWriter implements DataWriter{
        
    protected String fileName;
    protected File outFile;
    protected boolean stopped = false;
    protected PrintWriter writer;
    
    public void setFileName(String path) throws IOException{
        this.fileName = path;
        outFile = new File(path);
        setFile(outFile);
    }

    /**
     * deletes any existing file
     */
    public void setFile(File file) throws IOException{
        this.fileName = file.getCanonicalPath();
        outFile = file;
        if (outFile.isDirectory()){
            throw new IllegalStateException("File \"" + fileName + "\" is a directory!");
        }
        if (outFile.exists()){
            outFile.delete();
        }
        if (! outFile.createNewFile()){
            throw new IllegalStateException("File \"" + fileName + "\" cannot be created!");
        }
        if (! outFile.canWrite()){
            throw new IllegalStateException("Cannot write to File \"" + fileName + "\"!");
        }
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
    }
   
    public File getFile(){
        return outFile;
    }
  
    public void end()  throws IOException {
        writer.close();
    }
}
