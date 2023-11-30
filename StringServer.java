import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {

    ArrayList<String> strngs = new ArrayList<String>();   
    String out1 = "";

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    strngs.add(parameters[1]);
                    out1 = "";
                     for (int i = 0; i < strngs.size();i++){
                        out1 += (String.format("%d. %s\n",i+1, strngs.get(i)));
                    }
                return out1;                                    
                }
            }
            return "404 Not Found!";
    }
}


class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
};

