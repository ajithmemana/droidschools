package com.droidschools.contactprovider;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView contactsListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contactsListView = (ListView) findViewById(R.id.contacts_list);
	}

	public void fetchContacts(View v) {
		// Make sure you use Contacts from ContactsContract and Not the
		// deprecated Contacts
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		// android.provider.ContactsContract.Contacts.CONTENT_URI;
		
		// Parameters to Query
		String[] projection = null;
		String selection = null;
		String[] selectionArgs = null;
		String sortOrder = null;
		// Get the default content resolver instance
		ContentResolver contentResolver = getContentResolver();
		// Get the cursor to Contacts
		Cursor cursor =   contentResolver.query(uri, projection, selection,
				selectionArgs, sortOrder);
		Log.d("Number of columns = ", "" + cursor.getColumnCount());
		cursor.moveToFirst();
		for (int i = 0; i < cursor.getColumnCount(); i++) {
			Log.d("Column #" + i, cursor.getColumnName(i));

		}
		ArrayList<String> contactNames = new ArrayList<String>();
		// Fetch all the contacts to an array
		// Cursor will point to each row of the contacts db
		while (cursor.moveToNext()) {
			contactNames.add(cursor.getString(cursor
					.getColumnIndex("display_name")));
		}

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				contactNames);

		contactsListView.setAdapter(arrayAdapter);

	}
}