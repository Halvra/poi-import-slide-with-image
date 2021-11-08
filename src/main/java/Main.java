import org.apache.commons.io.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    private static final String MODEL = "/model.pptx";

    public static void main(String[] args) throws IOException {
        XMLSlideShow slideShow = new XMLSlideShow();
        XSLFSlide modelSlide = loadTemplate(MODEL);
        slideShow.createSlide().importContent(modelSlide);
    }

    private static XSLFSlide loadTemplate(final String modelName) throws IOException {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(IOUtils.resourceToByteArray(modelName));
        final XMLSlideShow slideShowModel = new XMLSlideShow(inputStream);
        final XSLFSlide model = slideShowModel.getSlides().get(0);
        slideShowModel.close();
        inputStream.close();
        return model;
    }
}
