package de.bruns.example.android.intents;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class IntentsActivity extends ListActivity {

   private static IntentData[] INTENT_DATA = {
         new IntentData("Telefonnummer wählen", Intent.ACTION_CALL, "tel:(+49) 123 4567890"),
         new IntentData("Telefonnummer aufrufen", Intent.ACTION_DIAL, "tel:(+49) 123 4567890"),
         new IntentData("SMS verschicken", Intent.ACTION_VIEW, "sms:(+49) 123 4567890"),
         new IntentData("Webseite anzeigen", Intent.ACTION_VIEW, "http://me4bruno.wordpress.com"),
         new IntentData("Foto aufnehmen", "android.media.action.IMAGE_CAPTURE", null),
         new IntentData("Kontakte anzeigen", Intent.ACTION_VIEW, "content://contacts/people/"),
         new IntentData("Position auf Karte anzeigen", Intent.ACTION_VIEW, "geo:53.076397,8.803648?z=14"),
         new IntentData("Adresse auf Karte anzeigen", Intent.ACTION_VIEW, "geo:0,0?q=Bremen (Hansestadt Bremen)"),
         new IntentData("Google Street View anzeigen", Intent.ACTION_VIEW, "google.streetview:cbll=53.076397,8.803648"),
         new IntentData("Maps-Navigation anzeigen", Intent.ACTION_VIEW, "http://maps.google.com/maps?saddr=53.5536,9.9925&daddr=53.076397,8.803648"),
         new IntentData("Navigator-Navigation anzeigen", Intent.ACTION_VIEW, "google.navigation:q=53.076397,10.803648")
   };

   private static class IntentData {

      private final String label;
      private final String action;
      private final Uri uri;

      public IntentData(String label, String action, String uri) {
         this.label = label;
         this.action = action;
         this.uri = uri != null ? Uri.parse(uri) : null;
      }

      @Override
      public String toString() {
         return label;
      }
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setListAdapter(new ArrayAdapter<IntentData>(this, android.R.layout.simple_list_item_1, INTENT_DATA));
     
      getListView().setOnItemClickListener(new OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            IntentData selectedIntentData = INTENT_DATA[position];
            Intent intent = new Intent(selectedIntentData.action, selectedIntentData.uri);
            startActivity(intent);
         }
      });
   }
}
