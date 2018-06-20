package com.example.android.music1app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GenresAdapter extends ArrayAdapter<Song> {

    /**
     * @param context        Current context. Used to inflate the layout file.
     * @param genreArrayList List of genres to display in a list.
     */
    public GenresAdapter(Activity context, ArrayList<Song> genreArrayList) {
        super(context, 0, genreArrayList);
    }

    /**
     * @param position    Position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     * <p>
     * Set TextView to current genre in list.
     * Set background color to color specified for genre category.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentGenre = getItem(position);

        TextView genreTextView = listItemView.findViewById(R.id.item_text_view);
        genreTextView.setText(currentGenre.getGenre());
        RelativeLayout genreLayout = listItemView.findViewById(R.id.list_item_layout);
        genreLayout.setBackgroundColor(genreLayout.getResources().getColor(R.color.genresColor));

        return listItemView;
        }
}
