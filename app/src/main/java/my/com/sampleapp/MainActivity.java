package my.com.sampleapp;

import android.app.Activity;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypedArray arrayString = getResources().obtainTypedArray(R.array.continents);
        arrayString.getString(0);
        String string = getResources().getString(R.string.hello_world);
        TextView textView = (TextView) findViewById(R.id.text_sample);
        textView.setText(string + "   " + arrayString.getString(0));



        /*Raw*/
        Button audioButton = (Button) findViewById(R.id.btn_1);
        Button videoButton = (Button) findViewById(R.id.btn_2);

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });

        /*Assets*/
        fetchCsv();
    }

    private void playVideo() {
        VideoView video;
        MediaController controller;
        video = (VideoView) findViewById(R.id.videoView1);
        controller = new MediaController(MainActivity.this);

        video.setMediaController(controller);
        video.setVideoURI(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.video));

        video.requestFocus();
        video.start();

    }

    private void playAudio() {
        MediaPlayer media = MediaPlayer.create(getBaseContext(), R.raw.audio);
        if (!media.isPlaying()) {
            media.start();
        }

        boolean play = media.isPlaying();

        if (play) {
            Toast.makeText(getBaseContext(), "Song is Playing",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "Song is not Playing",
                    Toast.LENGTH_SHORT).show();
        }


    }

    private void fetchCsv() {
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(getAssets().open("Brands.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(";");
                for (String string : row) {
                    System.out.println(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
