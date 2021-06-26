import java.applet.Applet;
import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// $FF: renamed from: f
public class JagLoader {
    // $FF: renamed from: a java.awt.Component
    public static Component fleasComponent;
    // $FF: renamed from: b java.applet.Applet
    public static Applet fleasApplet;
    // $FF: renamed from: c boolean
    public static boolean unusedBoolean = false;

    // $FF: renamed from: a (java.lang.String, int, byte[]) byte[]
    public static byte[] extractBzippedFile(String filename, int additionalDataLength, byte[] fileData) {
        int dataItemsLength = fileData[0] * 256 + fileData[1];
        int calculatedCheckSum = 0;
        filename = filename.toUpperCase();

        int itemIdx;
        for(itemIdx = 0; itemIdx < filename.length(); ++itemIdx) {
            calculatedCheckSum = calculatedCheckSum * 61 + filename.charAt(itemIdx) - 32;
        }

        itemIdx = 2 + dataItemsLength * 10;

        for(int i = 0; i < dataItemsLength; ++i) {
            int checksum = (fileData[i * 10 + 2] & 255) * 16777216 + (fileData[i * 10 + 3] & 255) * 65536 + (fileData[i * 10 + 4] & 255) * 256 + (fileData[i * 10 + 5] & 255);
            int decompressedSize = (fileData[i * 10 + 6] & 255) * 65536 + (fileData[i * 10 + 7] & 255) * 256 + (fileData[i * 10 + 8] & 255);
            int availIn = (fileData[i * 10 + 9] & 255) * 65536 + (fileData[i * 10 + 10] & 255) * 256 + (fileData[i * 10 + 11] & 255);
            if (checksum == calculatedCheckSum) {
                byte[] loadedFileData = new byte[decompressedSize + additionalDataLength];
                if (decompressedSize != availIn) {
                    BZLib.readFileData(loadedFileData, decompressedSize, fileData, availIn, itemIdx);
                } else {
                    for(int j = 0; j < decompressedSize; ++j) {
                        loadedFileData[j] = fileData[itemIdx + j];
                    }
                }

                return loadedFileData;
            }

            itemIdx += availIn;
        }

        System.out.println("Warning file not found: " + filename);
        return null;
    }

    // $FF: renamed from: a (java.lang.String) java.awt.Image
    public static Image getImage(String imageName) {
        Image curImage;
        if (fleasApplet == null) {
            curImage = Toolkit.getDefaultToolkit().getImage(imageName);
        } else {
            curImage = fleasApplet.getImage(fleasApplet.getCodeBase(), imageName);
        }

        MediaTracker mediaTracker = new MediaTracker(fleasComponent);
        mediaTracker.addImage(curImage, 0);

        try {
            mediaTracker.waitForID(0);
        } catch (InterruptedException ex) {
            System.out.println("Error!");
        }

        if (mediaTracker.isErrorID(0) || curImage == null) {
            curImage = null;
            System.out.println("Warning couldn't load: " + imageName);
        }

        return curImage;
    }

    // $FF: renamed from: b (java.lang.String) byte[]
    public static byte[] readFully(String filename) throws IOException {
        InputStream is = openInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        byte[] lengths = new byte[6];
        dis.readFully(lengths, 0, 6);
        int decompressedSize = ((lengths[0] & 255) << 16) + ((lengths[1] & 255) << 8) + (lengths[2] & 255);
        int dataLength = ((lengths[3] & 255) << 16) + ((lengths[4] & 255) << 8) + (lengths[5] & 255);
        byte[] fileData = new byte[dataLength];
        dis.readFully(fileData, 0, dataLength);
        dis.close();
        if (dataLength != decompressedSize) {
            byte[] doubleFileData = new byte[decompressedSize];
            BZLib.readFileData(doubleFileData, decompressedSize, fileData, dataLength, 0);
            return doubleFileData;
        } else {
            return fileData;
        }
    }

    // $FF: renamed from: a (java.awt.Component, boolean) void
    public static void setApplet(Component component, boolean isAppletMode) {
        fleasComponent = component;
        if (isAppletMode) {
            fleasApplet = (Applet)component;
        } else {
            fleasApplet = null;
        }

    }

    // $FF: renamed from: c (java.lang.String) java.io.InputStream
    public static InputStream openInputStream(String filename) throws IOException {
        Object fis;
        if (fleasApplet == null) {
            fis = new FileInputStream(filename);
        } else {
            URL url = new URL(fleasApplet.getCodeBase(), filename);
            fis = url.openStream();
        }

        return (InputStream)fis;
    }
}
