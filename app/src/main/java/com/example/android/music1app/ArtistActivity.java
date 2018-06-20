package com.example.android.music1app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class    ArtistActivity extends AppCompatActivity {

    /**
     * Add menu to the app bar and set the Artists option to be not visible.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        menu.findItem(R.id.action_artists).setVisible(false);
        return true;
    }

    /**
     * Set intent for each option in the menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent mainIntent = new Intent(ArtistActivity.this, MainActivity.class);
                startActivity(mainIntent);
                return true;
            case R.id.action_genres:
                Intent genresIntent = new Intent(ArtistActivity.this, GenresActivity.class);
                startActivity(genresIntent);
                return true;
            case R.id.action_songs:
                Intent songsIntent = new Intent(ArtistActivity.this, SongActivity.class);
                startActivity(songsIntent);
                return true;
            case R.id.action_shuffle:
                Intent shuffleIntent = new Intent(ArtistActivity.this, ShuffleActivity.class);
                startActivity(shuffleIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            //Set my_toolbar as Action Bar
            Toolbar myToolbar = findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);

            //Create new ArrayList and add all Song objects
            final ArrayList<Song> artists = new ArrayList<>();
            artists.add(new Song("Another Lonely Night", "Adam Lambert", "Rock", R.drawable.adam_ano_lonely));
            artists.add(new Song("Circus", "Britney Spears", "Pop", R.drawable.britney_circus));
            artists.add(new Song("Just looking for you", "Justin Bieber", "Rock", R.drawable.justin_looking_for_you));
            artists.add(new Song("Amarillo", "Shakira", "Pop", R.drawable.shakira_amarillo));

            //Create new adapter with artists ArrayList
            //Get ListView from XML and set adapter to list all artists
            ArtistAdapter adapter = new ArtistAdapter(this, artists);
            ListView listView = findViewById(R.id.list);
            listView.setAdapter(adapter);

            //Set click listener on ListView for each item in the list
            //Set intent to open SongActivity and pass in category and artist to filter
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String category = "artist";
                    String artist = artists.get(position).getArtist();
                    Intent intent = new Intent(ArtistActivity.this, SongActivity.class);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("SPECIFIC", artist);
                    startActivity(intent);
                }
            });
        }
}

