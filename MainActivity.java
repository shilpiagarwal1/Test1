package optionmenu.menu.com.contextmenuexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final int MENU_ID_01 = 100;
    private static final int MENU_ID_02 = 101;

    ListView listView;
    ArrayList<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<String>();
        for(int i=0;i<=10;i++)
        {
            contacts.add("item " + i);
        }

        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        long i=id;

        Toast.makeText(getApplicationContext(),"id is" +i,Toast.LENGTH_LONG).show();
        return false;
    }
});
        // Register the ListView  for Context menu
        registerForContextMenu(listView);
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu Ex");
        menu.add(0, MENU_ID_01, 2, "Context Menu gp 0 1");//groupId, itemId, order, title
        menu.add(0, MENU_ID_02, 1, "Context Menu gp 0 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==MENU_ID_01 && item.getGroupId()==0){
            Toast.makeText(getApplicationContext(),"Clicked on " +item.getGroupId()+"..."+item.getItemId(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==MENU_ID_02 && item.getGroupId()==0){
            Toast.makeText(getApplicationContext(),"Clicked on " +item.getGroupId()+"..."+item.getItemId(),Toast.LENGTH_LONG).show();
        }
        else{
            return false;
        }
        return true;
    }
}
