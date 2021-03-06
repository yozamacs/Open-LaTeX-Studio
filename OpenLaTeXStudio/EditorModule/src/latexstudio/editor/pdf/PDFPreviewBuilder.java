/* 
 * Copyright (c) 2015 Sebastian Brudzinski
 * 
 * See the file LICENSE for copying permission.
 */
package latexstudio.editor.pdf;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPage;
import org.openide.util.Exceptions;

/**
 * A class responsible for building PDF preview.
 * @author Sebastian
 */
public class PDFPreviewBuilder {
    
    private static final double SCALE_FACTOR = 0.4;
    private static final int SCALE_TYPE = Image.SCALE_SMOOTH;

    public static Image buildPDFPreview(PDPage pdfPage) {
        if (pdfPage == null) {
            return null;
        }
         
        BufferedImage pageImage = null;
        try {
            pageImage = pdfPage.convertToImage();
            int width = (int) (SCALE_FACTOR * pageImage.getWidth());
            int height = (int) (SCALE_FACTOR * pageImage.getHeight());
            int type = pageImage.getType();
            
            return pageImage.getScaledInstance(width, height, SCALE_TYPE);
            
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return null;
    }
}
