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

public class GenresActivity extends AppCompatActivity {

    /**
     * Add menu to the app bar and set the Genres option to be not visible.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        menu.findItem(R.id.action_genres).setVisible(false);
        return true;
    }

    /**
     * Set intent for each option in the menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent mainIntent = new Intent(GenresActivity.this, MainActivity.class);
                startActivity(mainIntent);
                return true;
            case R.id.action_artists:
                Intent artistsIntent = new Intent(GenresActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
                return true;
                case R.id.action_songs:
                Intent songsIntent = new Intent(GenresActivity.this, SongActivity.class);
                startActivity(songsIntent);
                return true;
                case R.id.action_shuffle:
                Intent shuffleIntent = new Intent(GenresActivity.this, ShuffleActivity.class);
                startActivity(shuffleIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Create new ArrayList and add all genres
        final ArrayList<Song> genres = new ArrayList<>();
        genres.add(new Song("Another Lonely Night", "Adam Lambert", "Rock", R.drawable.adam_ano_lonely));
        genres.add(new Song("Circus", "Britney Spears", "Pop", R.drawable.britney_circus));

        //Create new adapter with genres ArrayList
        //Get ListView from XML and set adapter to list all genres
        GenresAdapter adapter = new GenresAdapter(this, genres);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Set click listener on ListView for each item in the list
        //Set intent to open SongActivity and pass in category and genre to filter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String category = "genre";
                String genre = genres.get(position).getGenre();
                Intent intent = new Intent(GenresActivity.this, SongActivity.class);
                intent.putExtra("CATEGORY", category);
                intent.putExtra("SPECIFIC", genre);
                startActivity(intent);
            }
        });
    }
}
