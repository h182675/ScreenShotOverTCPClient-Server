package controllers;

import service.tcp.Client;
import service.tcp.Server;

public class UiController {
    private Server server = new Server();
    private Client client = new Client();


    public enum intervalTimer {
        SHORT(30000),
        MEDIUM(60000),
        LONG(120000);

        intervalTimer(int i) {
            this.time = i;
        }

        private int time;

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString().toLowerCase());
            sb.replace(0,1, sb.substring(0,1).toUpperCase());
            sb.append("(").append(time/1000).append("s)");

            return sb.toString();
        }
    }

    public void startServer(intervalTimer intervalTimer) {
        server.start(intervalTimer.getTime());
    }

    public void startClient(intervalTimer intervalTimer) {
        client.start(intervalTimer.getTime());
    }

    public String getClientHostAddress() {
        return client.getHostAddress();
    }

    public boolean setClientHostAddress(String address) {
        return client.setHostAddress(address);
    }
}
