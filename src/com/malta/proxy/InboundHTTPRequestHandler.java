package com.malta.proxy;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Http web server handler implementation. Deserializer of inbound request
 */
public class InboundHTTPRequestHandler implements Runnable {

    private static final Logger LOGGER;
    private static final String DEFAULT_RESPONSE;

    private Socket socket = null;

    static {
        LOGGER = Logger.getLogger(InboundHTTPRequestHandler.class.getName());
        LOGGER.setLevel(Level.WARNING);
        DEFAULT_RESPONSE = "HTTP/1.1 200 OK\r\n\r\n";
    }

    public InboundHTTPRequestHandler setSocket(Socket socket) {
        this.socket = socket;
        return this;
    }

    @Override
    public void run() {

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            // read the headers
            String headerLine;
            do {
                headerLine = reader.readLine();
            } while(headerLine.length() != 0);

            // read the body
            StringBuilder payload = new StringBuilder();
            while(reader.ready()){
                payload.append((char) reader.read());
            }
            // push handled request to the queue
            CacheQueue.getInstance().add(new InboundHTTPRequestEntity(
                socket.getInetAddress().toString(), payload.toString(), Thread.currentThread().getName()));
            writer.write(DEFAULT_RESPONSE + new Date());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
    }

}
