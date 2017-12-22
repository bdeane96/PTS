import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class PortraitClassifier {

	public void classify() {

		nu.pattern.OpenCV.loadShared();

		//haarcascade_frontalface_alt2 is best at determining portraits
		
		ClassLoader classLoader =getClass().getClassLoader();
		File lbpClassifier = new File (classLoader.getResource("lbpcascade_frontalface.xml").getFile());
		File haarClassifier = new File (classLoader.getResource("haarcascade_frontalface_alt2.xml").getFile());

		String imageName = "portrait2.jpg";
		
		int lbpFaces = getNumberOfFaces(imageName, lbpClassifier);
		int haarFaces = getNumberOfFaces(imageName, haarClassifier);
		if (lbpFaces > 1 && haarFaces > 1) {
			System.out.println("Group Shot");
		} else if (lbpFaces ==1 || haarFaces == 1){
			System.out.println("Portrait");			
		} else {
			System.out.println("Landscape");
		}
	}
	
	private int getNumberOfFaces(String imageName, File classifier) {
		ClassLoader classLoader =getClass().getClassLoader();
		CascadeClassifier faceDetector = new CascadeClassifier(classifier.getAbsolutePath());
		faceDetector.load(classifier.getAbsolutePath());
		if(faceDetector.empty()) {
			System.out.println("Classifier did not load correctly");
		}
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(classLoader.getResource(imageName).getFile()));
		} catch (IOException e) {
			System.out.println("Error reading image from file");
			e.printStackTrace();
		}

		byte[] imagePixels = ((DataBufferByte) img.getRaster().getDataBuffer())
                .getData();
        Mat image = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
        image.put(0, 0, imagePixels);
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGRA2GRAY);
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);

		return (faceDetections.toArray().length);
	}
}
