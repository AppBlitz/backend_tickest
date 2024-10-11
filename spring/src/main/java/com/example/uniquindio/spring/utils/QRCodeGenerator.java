package com.example.uniquindio.spring.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for generating QR codes.
 */
@Service
public class QRCodeGenerator {

    /**
     * Generates a QR code image as a byte array.
     *
     * @param text the text to encode in the QR code
     * @param width the width of the generated QR code image
     * @param height the height of the generated QR code image
     * @return a byte array representing the generated QR code image in PNG format
     * @throws Exception if an error occurs during QR code generation
     */
    public byte[] generateQRCodeImage(String text, int width, int height) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter(); // Create an instance of QRCodeWriter
        Map<EncodeHintType, Object> hints = new HashMap<>(); // Create a map for encoding hints
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // Set the character set for the QR code

        // Encode the text into a BitMatrix representation of the QR code
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream(); // Create an output stream for the PNG image
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream); // Write the BitMatrix to the output stream as a PNG
        return pngOutputStream.toByteArray(); // Return the byte array of the PNG image
    }
}
