package hello;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesseractController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    public static ITesseract instance;
    private static String datapath = "src/main/java";
    private static String testResourcesDataPath = "src/main/java/hello";

    @RequestMapping("/tesseractwithdefaultimage")
    public Image tesseractWithDefaultImage(@RequestParam(value="name", defaultValue="test") String content) throws IOException, TesseractException {
        
        
        instance = new Tesseract1();
        instance.setDatapath(new File(datapath).getPath());
         
        File imageFile = new File(testResourcesDataPath, "id6.jpg");
        //String result = instance.doOCR(imageFile);
       
        BufferedImage bi = ImageIO.read(imageFile);
        
        //extraction
        String result = instance.doOCR(bi);
        
        return new Image(1,result);
    }
    
    
    @RequestMapping("/tesseractwithdefaulturl")
    public Image tesseractWithUrlImage(@RequestParam(value="url", defaultValue="http://afrinnov.xyz/id6.jpg") String urlsource) throws IOException, TesseractException {
        
        
        instance = new Tesseract1();
        instance.setDatapath(new File(datapath).getPath());

        URL url = new URL(urlsource);
       
        BufferedImage bi = ImageIO.read(url);
        
        //extraction
        String result = instance.doOCR(bi);
        
        return new Image(1,result);
    }
    
    
    @RequestMapping(value = "/tesseractwithimageencodetostring", method = RequestMethod.POST)
    public Image tesseractWithImageEncodeToString(@RequestBody Image image) throws IOException, TesseractException {
        
        instance = new Tesseract1();
        instance.setDatapath(new File(datapath).getPath());

        String path = "C:\\server\\idtest.jpg";
        UtilBase64Image.decoder(image.getContent(), path);
        
        File imageFile = new File("C:\\server\\idtest.jpg");
        //extraction
        String result = instance.doOCR(imageFile);
       
    
        
        return new Image(1,result);
    }
}
