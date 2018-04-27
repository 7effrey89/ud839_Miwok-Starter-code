package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jeffrey on 05-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int GlobalbackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> Word, int backgroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Word);
        GlobalbackgroundColor = backgroundColor;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


    // Get the {@link AndroidFlavor} object located at this position in the list
        Word listNumber = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(listNumber.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(listNumber.getMiwokTranslation());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);

// Find the container that we want to change color dynamically
        LinearLayout text_container = (LinearLayout) listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), GlobalbackgroundColor);
        text_container.setBackgroundColor(color);

        if(listNumber.hasImage()) {

            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView

            iconView.setImageResource(listNumber.getImageResourceId());
        }
        else
        {
            iconView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }


}
