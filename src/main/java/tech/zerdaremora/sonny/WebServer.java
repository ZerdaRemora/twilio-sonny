package tech.zerdaremora.sonny;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Play;

import java.util.Random;

import static spark.Spark.*;

public class WebServer {
    public static void main(String[] args)
    {
        String[] soundUrls = new String[]{"https://dl.dropboxusercontent.com/s/pud9pxqskkfkf8u/call1.wav",
                "https://dl.dropboxusercontent.com/s/aw1dln5qqogp0se/call2.wav",
                "https://dl.dropboxusercontent.com/s/rhfhagsigv66iql/call3.wav"};

        post("/", (req, res) -> {
            Random r = new Random();
            String url = soundUrls[r.nextInt(soundUrls.length)];
            Play play = new Play.Builder(url).build();


            VoiceResponse response = new VoiceResponse.Builder().play(play).build();
            return response.toXml();
        });
    }
}
