package android.the.coding.archer.mynotes.adapter;

import android.content.Context;
import android.database.Cursor;
import android.the.coding.archer.mynotes.helper.DBOpenHelper;
import android.the.coding.archer.mynotes.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class NotesCursorAdapter extends CursorAdapter {

    public NotesCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
                                                R.layout.note_list_item,
                                                parent,
                                                false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

        int pos = noteText.indexOf(10);
        if (pos != -1) {
            noteText = noteText.substring(0, pos) + " ...";
        }

        TextView tvNote = view.findViewById(R.id.tvNote);
        tvNote.setText(noteText);
    }
}
