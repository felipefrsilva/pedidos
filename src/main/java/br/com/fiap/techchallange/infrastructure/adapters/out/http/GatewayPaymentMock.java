package br.com.fiap.techchallange.infrastructure.adapters.out.http;

import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GatewayPaymentMock implements IGatewayPayment {
    @Override
    public String getCodeReading(float value) throws IOException, WriterException {
        return generateQRCode(String.valueOf(value),200,200);
    }

    private String generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(qrImage, "PNG", outputStream);

        byte[] qrBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(qrBytes);
    }

}
