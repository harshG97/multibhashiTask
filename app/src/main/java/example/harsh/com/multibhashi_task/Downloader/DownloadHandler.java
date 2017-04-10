package example.harsh.com.multibhashi_task.Downloader;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Harsh on 10-04-2017.
 */

public class DownloadHandler {
    private String urlDownloadLink ;
    String audioNum;

    public DownloadHandler(String url, String num){
        urlDownloadLink = url;
        audioNum = num;
    }
    public void downloadAudio(){


        String filename = "multibhashiAudio" + audioNum + ".aac";
        String containerFile = "voices";

        String downloadAudioPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File audioVoice = new File(downloadAudioPath + File.separator + containerFile);
        if(!audioVoice.exists()){
            audioVoice.mkdir();
        }
        downloadAudioPath = downloadAudioPath + File.separator + containerFile + File.separator + filename;
        DownloadFile downloadAudioFile = new DownloadFile();
        downloadAudioFile.execute(urlDownloadLink, downloadAudioPath);
    }

    private class DownloadFile extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... urlParams) {
            int count;

            try {
                URL urls = new URL(urlParams[0]);
                URLConnection connection = urls.openConnection();
                connection.connect();

                InputStream input = new BufferedInputStream(urls.openStream());
                OutputStream output = new FileOutputStream(urlParams[1]);


                byte data[] = new byte[1024];



                while ((count = input.read(data)) != -1) {

                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
            }
            return null;
        }



    }
}
