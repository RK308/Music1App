package com.example.android.music1app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<String> {

    /**
     * @param context         Current context. Used to inflate the layout file.
     * @param artistArrayList List of artists to display in a list.
     */
    public ArtistAdapter(Activity context, ArrayList<String> artistArrayList) {
        super(context, 0, artistArrayList);
    }

    /**
     * @param position    Position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     *
     * Set TextView to current artist in list.
     * Set background color to color specified for artist category.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        String currentArtist = getItem(position);
        TextView artistTextView = listItemView.findViewById(R.id.item_text_view);
        artistTextView.setText(currentArtist);
        final RelativeLayout artistLayout = listItemView.findViewById(R.id.list_item_layout);
        artistLayout.setBackgroundColor(artistLayout.getResources().getColor(R.color.artistColor));

        return listItemView;
    }
}
