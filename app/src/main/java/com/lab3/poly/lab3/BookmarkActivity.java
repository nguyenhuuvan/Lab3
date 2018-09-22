package com.lab3.poly.lab3;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Browser;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lab3.poly.lab3.Adapter.ContactAdapter;
import com.lab3.poly.lab3.model.MyContact;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    List<MyContact> myContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        recyclerView = findViewById(R.id.rvListBookmark);
        initsAction();

    }

    public void initsAction() {
        int mang[] = new int[]{R.drawable.internet};
        myContacts = new ArrayList<>();
        MyContact myContact;
        String[] projection = {
                "title",
                "url",
        };
        Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
        Cursor cursor = getContentResolver().query(BOOKMARKS_URI, projection, null, null, null);
        cursor.moveToFirst();
        int titleIndex = cursor.getColumnIndex
                ("title");
        int urlIndex = cursor.getColumnIndex
                ("url");
        while (!cursor.isAfterLast()) {
            myContact = new MyContact();
            String title = cursor.getString(titleIndex);
            String url = cursor.getString(urlIndex);
            if(url.length()>55){
                String urlnew = url.substring(0,55)+"...";
                myContact.setSdt(urlnew);
            }else{
               myContact.setSdt(url);
            }
            if(title.length()>30){
                String titlenew = title.substring(0,30)+"...";
                myContact.setName(titlenew);
            }else{
                myContact.setName(title);
            }
            myContact.setImg(mang[0]);
            myContacts.add(myContact);
            cursor.moveToNext();
        }
        cursor.close();
        contactAdapter = new ContactAdapter(BookmarkActivity.this, myContacts);
        recyclerView.setAdapter(contactAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BookmarkActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
